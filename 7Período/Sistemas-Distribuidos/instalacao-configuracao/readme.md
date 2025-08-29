# Guia de Instalação e Configuração — Proxmox VE 9 (com RAID 1)

Este guia foi escrito para ser **técnico** e **didático**, servindo tanto para quem está começando quanto para quem já tem prática. Sempre que aparecer um termo estranho, consulte o **Glossário para Leigos** no fim do documento.

> **Privacidade**: se este repositório for público, **troque** IPs/hostnames reais e e-mails por exemplos (ex.: `192.0.2.10`, `proxmox.exemplo.local`, `admin@example.org`).

---

## 1) O que é o Proxmox VE
O **Proxmox VE** é um sistema que transforma um servidor físico em uma **plataforma de virtualização**: você pode criar e gerenciar **máquinas virtuais (VMs)** e **containers** de forma centralizada, pela web. É muito útil em **sistemas distribuídos** e laboratórios porque permite subir vários “computadores virtuais” num único hardware.

---

## 2) Pré-requisitos e preparação
- **Hardware**: verifique compatibilidade do servidor com Proxmox VE.
- **RAID 1**: defina que serão usados **dois discos** espelhados (protege contra falha de um disco).
- **Rede**: tenha à mão **IP estático**, **gateway** e **DNS**.
- **Mídia de instalação**: crie um pendrive bootável com a **ISO do Proxmox VE 9**.

> Do relatório: a instalação usou o Proxmox VE 9 e o disco `/dev/sda` como destino. Também já foram definidos fuso horário, teclado e rede. (Ver seções 3 e 3.3 do relatório.)

---

## 3) Configurar o RAID 1 (no utilitário do servidor)
> Baseado no passo-a-passo do relatório, usando uma controladora HPE Smart HBA H240ar.

1. **Entrar no utilitário do sistema** — No boot do servidor, acesse `System Utilities` (ex.: `F9`).  
   ![System Utilities](img/raid-01-system-utilities.png)
2. **Acessar armazenamento** — Entre no menu de **Storage** e visualize os dispositivos lógicos.  
   ![Storage](img/raid-02-storage.png)
3. **Selecionar a controladora** — Clique em **Smart HBA H240ar** (painel esquerdo).  
4. **Abrir configurações** — Em **Actions**, clique em **Configure**.
5. **Gerenciar arrays** — Abra **Logical Devices** (coluna esquerda), selecione **ArrayA - 1 Logical Drive(s)** e clique em **Delete Array** (em **Actions**) para remover o array antigo (se houver).
6. **Criar novo array** — Clique em **Create Array** (em **Actions**). Escolha **os HDs** para o novo array.
7. **Definir parâmetros** — Selecione **RAID Level** = **RAID 1** e ajuste **Stripe Size**, **Sectors/Track** e **Size** conforme recomendação do fabricante/ambiente. Clique em **Create Logical Drive**.
8. **Confirmar e finalizar** — Revise o resumo e clique em **Finish**. Feche a janela (ícone `X`) para voltar à tela principal.

> Dica: anote a **capacidade** final do Logical Drive. Ela aparecerá na instalação do Proxmox como um disco (`/dev/sda`, por exemplo).

**Imagens sugeridas para esta seção**
- `img/raid-01-system-utilities.png`
- `img/raid-02-storage.png`
- `img/raid-03-delete-array.png`
- `img/raid-04-create-array.png`
- `img/raid-05-summary-finish.png`

---

## 4) Instalar o Proxmox VE 9

1. **Dar boot pela mídia USB** — No servidor, abra o **Boot Menu** (ex.: `F11`) e selecione o pendrive com a ISO do Proxmox VE 9. Escolha **Install Proxmox VE (Graphical)**.
2. **Aceitar a licença (EULA)** — Continue.
3. **Selecionar o disco de destino** — Ex.: **/dev/sda** (o Logical Drive criado no RAID).
4. **Definir região e teclado** — Ex.: país **Brazil**, região **America/Araguaina**, teclado **Brazil‑Portuguese**.
5. **Criar o usuário administrador** — Defina **senha** e **e-mail** de administração.
6. **Configurar a rede** — Escolha a **interface de gerenciamento** (ex.: `eno1`), defina o **Hostname (FQDN)**, **IP estático** (com máscara), **Gateway** e **DNS**.
7. **Finalizar a instalação** — Aguarde a cópia dos arquivos e a configuração do sistema.

**Imagens sugeridas para esta seção**
- `img/pve-01-boot-menu.png`
- `img/pve-02-eula.png`
- `img/pve-03-target-disk.png`
- `img/pve-04-locale-timezone.png`
- `img/pve-05-admin.png`
- `img/pve-06-network-fqdn.png`
- `img/pve-07-finish.png`

> **Troubleshooting**: Se a instalação falhar (ex.: erro de mídia), **baixe novamente a ISO** e recrie o pendrive. Teste outra porta USB se necessário.

---

## 5) Pós-instalação e primeiro acesso
- No computador da sua rede, abra o navegador e acesse:  
  `https://SEU_IP:8006`
- Aceite o aviso de certificado (autoassinado) e **faça login** com o usuário/senha definidos na instalação.
- Se a interface abrir, o Proxmox está **operacional**. Depois você poderá:
  - Criar VMs e containers.
  - Adicionar mais discos/armazenamentos.
  - Configurar backups e alta disponibilidade (HA), se aplicável.

---

# Proxmox VE — Instalação em Servidor Físico (com RAID 1)

Documentação passo a passo para instalar e validar o **Proxmox Virtual Environment (PVE)** em um servidor físico com **RAID 1**, com linguagem técnica **didática** para quem está começando.

> **Aviso**: As capturas de tela e parâmetros sensíveis (IP, e-mail, hostname) do relatório original **não devem** ser publicados em um repositório público sem revisão. Substitua por exemplos fictícios antes de subir no GitHub.

## 🧭 Sumário
- [Visão Geral](#visão-geral)
- [Requisitos](#requisitos)
- [Passo a Passo (resumo)](#passo-a-passo-resumo)
- [Estrutura do repositório](#estrutura-do-repositório)
- [Links úteis](#links-úteis)
- [Créditos](#créditos)

## Visão Geral
Este repositório centraliza a documentação e as fotos do processo de:
1) **Configuração de RAID 1** no controladora (ex.: HPE Smart HBA H240ar), e
2) **Instalação do Proxmox VE 9** com configuração de rede e validação de acesso inicial.

Documentação detalhada: [`docs/Guia_Proxmox.md`](docs/Guia_Proxmox.md).

## Requisitos
- Servidor físico compatível com Proxmox VE.
- Midia USB com a **ISO do Proxmox VE 9**.
- Acesso ao utilitário de configuração de armazenamento/RAID do servidor.
- Endereços de rede definidos (IP estático, gateway e DNS).

## Passo a Passo (resumo)
1. **Configurar RAID 1**
   - Acessar utilitário do servidor (ex.: tecla `F9`/`System Utilities`). 
   - Apagar arrays anteriores (se necessário) e **criar novo array RAID 1** com os dois discos.
   - Finalizar criação do **Logical Drive**.
2. **Instalar o Proxmox VE 9**
   - Dar boot pela mídia USB (ex.: `F11` / Boot Menu) e escolher **Install Proxmox VE (Graphical)**.
   - Aceitar a licença, escolher **/dev/sda** como disco de destino, fuso **America/Araguaina**, teclado **Brazil-Portuguese**.
   - Definir senha/e-mail do administrador, **interface de rede** (ex.: `eno1`), **hostname FQDN**, **IP estático**, **gateway** e **DNS**.
   - Concluir a instalação.
3. **Validar o acesso**
   - Pelo navegador, acessar `https://SEU_IP:8006` e fazer login com a conta criada.

> Os detalhes completos e as capturas de tela estão em [`docs/Guia_Proxmox.md`](docs/Guia_Proxmox.md).

## Estrutura do repositório
```
.
├─ README.md
└─ docs/
   ├─ Guia_Proxmox.md
   └─ img/
      ├─ raid-01-system-utilities.png
      ├─ raid-02-storage.png
      ├─ raid-03-delete-array.png
      ├─ raid-04-create-array.png
      ├─ raid-05-summary-finish.png
      ├─ pve-01-boot-menu.png
      ├─ pve-02-eula.png
      ├─ pve-03-target-disk.png
      ├─ pve-04-locale-timezone.png
      ├─ pve-05-admin.png
      ├─ pve-06-network-fqdn.png
      └─ pve-07-finish.png
```

## Links úteis
- Site oficial Proxmox: https://www.proxmox.com/en/proxmox-ve
