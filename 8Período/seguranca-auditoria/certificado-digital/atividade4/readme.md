# Atividade 4 - certificado digital - ***[link-repo](https://github.com/JoaoIto/encrypt-decrypt-sign/tree/main/packages/assignature)***

# 🔐 Tutorial: HTTPS com Nginx + TLS 1.3 + Certificado Autoassinado RSA 4096 + Joomla

> **Atividade:** Configuração de Certificado Digital Autoassinado  
> **Servidor:** Nginx 1.28  
> **Aplicação:** Joomla 5.4.3  
> **Protocolo:** HTTPS obrigatório, TLS 1.3, RSA 4096 bits  
> **Infraestrutura:** Docker / Contêiner  

---

## Arquitetura da Solução

```
Internet / Navegador do Aluno
             │
             ▼ HTTPS (TLS 1.3 / RSA 4096)
    ┌─────────────────┐
    │  Nginx 1.28     │  ◄── Proxy Reverso + Terminação SSL
    │  (porta 443)    │      Redireciona HTTP→HTTPS
    └────────┬────────┘
             │ HTTP interno (sem SSL) 
             ▼
    ┌─────────────────┐
    │    Moodle       │  ◄── Aplicação PHP
    │  (porta 8080)   │
    └────────┬────────┘
             │
             ▼
    ┌─────────────────┐
    │   MySQL/MariaDB │  ◄── Banco de dados
    └─────────────────┘
```

---

## Pré-Requisitos

```bash
# Verificar se Docker está instalado
docker --version
docker compose version

# Instalar Docker se necessário (Ubuntu/Debian)
curl -fsSL https://get.docker.com | sh
sudo usermod -aG docker $USER
```

---

## Estrutura de Arquivos do Projeto

```
token_nodejs/
├── docs/packages/assignature/
│   └── README.md               ← Esta documentação (com prints)
│
└── packages/assignature/       ← Código e configuração (para rodar)
    ├── docker-compose.yml
    ├── generate-cert.js
    └── nginx/
        ├── nginx.conf
        └── certs/
            ├── server.crt      ← Gerado no Passo 1
            └── server.key      ← Gerado no Passo 1
```

Entrar na pasta de execução:
```bash
cd packages/assignature
```

---

## PASSO 1: Gerar o Certificado Autoassinado (RSA 4096 bits)

### Opção A: Linha de Comando (Linux / Mac / Git Bash / WSL)
```bash
openssl req -x509 -nodes -days 365 \
  -newkey rsa:4096 \
  -keyout nginx/certs/server.key \
  -out nginx/certs/server.crt \
  -subj "/C=BR/ST=SP/L=SaoPaulo/O=Faculdade/OU=Seguranca/CN=localhost"
```

### Opção B: Windows (PowerShell / CMD) — via script Node.js incluído

Se o `openssl` não estiver no seu PATH do Windows, use o script que já acompanha este projeto:

```bash
node generate-cert.js
```

O script detecta automaticamente o OpenSSL do Git for Windows e gera o par de chaves no local correto.

### Verificar o certificado gerado:
```bash
# Confirmar que é RSA 4096 bits
openssl x509 -in nginx/certs/server.crt -text -noout | grep -E "Public-Key|Subject|Not"
```

**Saída esperada:**
```
Subject: C=BR, ST=SP, L=SaoPaulo, O=Faculdade, OU=Seguranca, CN=localhost
Not Before: ...
Not After : ...
           Public-Key: (4096 bit)
```

> ✅ **O que acabou de acontecer?** Criamos um par de chaves RSA: a **chave privada** (`server.key`) que NUNCA sai do servidor, e o **certificado público** (`server.crt`) que será enviado para o navegador do aluno para validar a identidade.

---

## PASSO 2: Configurar o Nginx com TLS 1.3

Criar o arquivo `nginx/nginx.conf`:

```nginx
# nginx/nginx.conf

user  nginx;
worker_processes  auto;

events {
    worker_connections 1024;
}

http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    # ─────────────────────────────────────────────────
    # Redirecionar TODO o tráfego HTTP → HTTPS
    # ─────────────────────────────────────────────────
    server {
        listen 80;
        server_name localhost;
        
        # Retornar 301 Permanent Redirect para HTTPS
        return 301 https://$host$request_uri;
    }

    # ─────────────────────────────────────────────────
    # Servidor HTTPS com TLS 1.3 e RSA 4096
    # ─────────────────────────────────────────────────
    server {
        listen 443 ssl;
        server_name localhost;

        # Caminho dos certificados
        ssl_certificate     /etc/nginx/certs/server.crt;
        ssl_certificate_key /etc/nginx/certs/server.key;

        # ════════════════════════════════════════════
        # PROTOCOLO: Somente TLS 1.3 (mais seguro)
        # ════════════════════════════════════════════
        ssl_protocols TLSv1.3;

        # Cipher Suites aprovados pelo TLS 1.3
        ssl_ciphers TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256:TLS_AES_128_GCM_SHA256;
        ssl_prefer_server_ciphers off;

        # ════════════════════════════════════════════
        # Headers de Segurança HTTP
        # ════════════════════════════════════════════
        add_header Strict-Transport-Security "max-age=31536000; includeSubDomains" always;
        add_header X-Content-Type-Options nosniff;
        add_header X-Frame-Options DENY;
        add_header X-XSS-Protection "1; mode=block";

        # ════════════════════════════════════════════
        # Proxy Reverso → Moodle (PHP interno)
        # ════════════════════════════════════════════
        location / {
            proxy_pass http://moodle:8080;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto https;
        }
    }
}
```

---

## PASSO 3: Docker Compose (Joomla + Nginx + MySQL)

O arquivo já se encontra em `packages/assignature/docker-compose.yml`.

```yaml
services:

  mysql:          # Banco de dados MySQL 8
    image: mysql:8.0

  joomla:         # Aplicação Joomla 5 com Apache
    image: joomla:5-apache
    depends_on: [mysql]

  nginx:          # Nginx 1.28 — proxy HTTPS com TLS 1.3
    image: nginx:1.28
    ports:
      - "80:80"    # Redireciona → 443
      - "443:443"  # HTTPS com TLS 1.3
```

> O arquivo completo com todas as variáveis de ambiente está em `packages/assignature/docker-compose.yml`.

---

## PASSO 4: Subir os Contêineres

```bash
# Na pasta packages/assignature/
cd packages/assignature
docker compose up -d

# Verificar se os contêineres estão rodando
docker compose ps
```

**Saída esperada:**
```
NAME             IMAGE              STATUS
joomla_db        mysql:8.0          Up
joomla_app       joomla:5-apache    Up
joomla_nginx     nginx:1.28         Up (ports: 0.0.0.0:443->443/tcp)
```

---

## PASSO 5: Testar e Verificar

### Acessar no navegador:
```
https://localhost
```

> ⚠️ O navegador vai mostrar **"Sua conexão não é privada"** — isso é ESPERADO porque o certificado é autoassinado. Clique em **"Avançado" → "Prosseguir para localhost"**.

![Aviso de Conexão Não Privada — certificado autoassinado (esperado)](01-aviso-conexao-nao-privada.png)

### Verificar o Certificado no Navegador:
1. Clique no **🔒 cadeado** na barra de endereço.
2. Clique em **"A conexão é segura"** → **"O certificado é válido"**.
3. Confirme: **RSA 4096 bits**, **TLS 1.3**, validade de 365 dias.

### Verificar via Terminal:
```bash
# Verificar versão do TLS negociada e tamanho da chave
openssl s_client -connect localhost:443 -tls1_3 2>&1 | grep -E "Protocol|Cipher|bits"
```

**Saída esperada:**
```
Protocol  : TLSv1.3
Cipher    : TLS_AES_256_GCM_SHA384
Server public key is 4096 bit
```

### Confirmar redirecionamento HTTP → HTTPS:
```bash
curl -v http://localhost 2>&1 | grep -E "Location|301"
# Esperado: < HTTP/1.1 301 Moved Permanently
# Esperado: < Location: https://localhost/
```

![Visualizador do Certificado — Aba Geral: Emitido para Faculdade/Seguranca](02-verificacao-certificado-geral.png)

![Visualizador do Certificado — Aba Detalhes: Campos e Impressões Digitais SHA-256](03-verificacao-certificado-detalhes.png)

---

## PASSO 6: Acessar o Joomla (Credenciais)

```
URL Pública:  https://localhost
URL Admin:    https://localhost/administrator
Usuário:      admin
Senha:        (a que você definiu na instalação)
```

![Tela de Login do Joomla Administrator](04-tela-login-joomla.png)

![Instalação Concluída — Joomla está pronto](05-joomla-instalado-parabens.png)

![Certificado — Chave Pública RSA 4096 bits confirmada](06-certificado-chave-publica-rsa4096.png)

---

## Resumo para o Relatório

| Componente | Tecnologia | Justificativa |
|---|---|---|
| Contêiner | Docker + Docker Compose | Ambiente reproduzível e portátil |
| Servidor Web | **Nginx 1.28** | Alta performance, suporte nativo a SSL |
| Plataforma | **Joomla 5.4.3** | CMS de código aberto (alternativa ao Moodle) |
| Banco de Dados | MySQL 8.0 | Recomendado pelo Joomla, gratuito |
| Protocolo TLS | **TLS 1.3** | Mais recente e seguro (2018) |
| Tamanho da Chave | **RSA 4096 bits** | Exigido pela atividade |
| Certificado | Autoassinado (OpenSSL) | Sem custo, válido para ambiente interno |
| HTTP | Redirecionado obrigatoriamente para HTTPS | Garantia de uso exclusivo de HTTPS |

![Joomla Admin Dashboard rodando via HTTPS em https://localhost/administrator](07-joomla-admin-dashboard.png)

![Certificado — Aba Detalhes mostrando hierarquia e campos do certificado](08-certificado-aba-detalhes.png)

## Encerrar os Contêineres

```bash
docker compose down         # Para e remove contêineres (dados preservados nos volumes)
docker compose down -v      # ⚠️ Remove TUDO incluindo os dados do banco
```


---
