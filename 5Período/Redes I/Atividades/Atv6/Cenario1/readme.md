## Estrutura da Rede

O cenário de rede consiste em:

- **Roteadores**: Quatro roteadores interconectados (`router1`, `router2`, `router3`, `router4`).
- **Switches**: Cada roteador conecta-se a um switch que, por sua vez, conecta-se a dois PCs.
- **PCs**: Estações de trabalho finais conectadas a diferentes sub-redes (total de seis PCs, numerados de `pc1` a `pc6`).
  
### Endereçamento IP

- Rede 1: `192.168.50.0/24`
  - **router1** (eth0): `192.168.50.1`
  - **pc1**: `192.168.50.10`
  - **pc2**: `192.168.50.11`

- Rede 2: `192.168.70.0/24`
  - **router2** (eth0): `192.168.70.1`
  - **pc3**: `192.168.70.10`
  - **pc4**: `192.168.70.11`

- Rede 3: `192.168.90.0/24`
  - **router3** (eth0): `192.168.90.1`
  - **pc5**: `192.168.90.10`
  - **pc6**: `192.168.90.11`

## Passos para Configuração

### 1. Inicializar a Máquina Virtual

- Certifique-se de que o VirtualBox esteja instalado e configurado.
- Abra a máquina virtual que contém o IMUNES.

### 2. Abrir o Cenário no IMUNES

- Dentro da VM, abra o **IMUNES**.
- Carregue o arquivo do cenário fornecido (`Cenario_Roteamento_01.imn`).

### 3. Configurar os Roteadores

Cada roteador deve ser configurado com o roteamento apropriado para permitir a comunicação entre as sub-redes. Abaixo estão os comandos básicos para configurar o roteamento estático em cada roteador.

#### Router 1

```bash
ip route add 192.168.70.0/24 via 192.168.50.2
ip route add 192.168.90.0/24 via 192.168.50.2
```

#### Router 2

```bash
ip route add 192.168.50.0/24 via 192.168.70.1
ip route add 192.168.90.0/24 via 192.168.70.3
```

#### Router 3

```bash
ip route add 192.168.50.0/24 via 192.168.90.2
ip route add 192.168.70.0/24 via 192.168.90.2
```

#### Router 4

```bash
ip route add 192.168.50.0/24 via 192.168.70.3
ip route add 192.168.90.0/24 via 192.168.70.3
```

### 4. Configurar os PCs

Cada PC também deve ser configurado com seu respectivo endereço IP e gateway. Para isso, use os seguintes comandos no terminal de cada PC:

#### PC1

```bash
ifconfig eth0 192.168.50.10/24
route add default gw 192.168.50.1
```

#### PC2

```bash
ifconfig eth0 192.168.50.11/24
route add default gw 192.168.50.1
```

#### PC3

```bash
ifconfig eth0 192.168.70.10/24
route add default gw 192.168.70.1
```

#### PC4

```bash
ifconfig eth0 192.168.70.11/24
route add default gw 192.168.70.1
```

#### PC5

```bash
ifconfig eth0 192.168.90.10/24
route add default gw 192.168.90.1
```

#### PC6

```bash
ifconfig eth0 192.168.90.11/24
route add default gw 192.168.90.1
```

### 5. Testar a Conectividade

- Execute o comando `ping` entre os PCs para testar a conectividade. Por exemplo, para testar a comunicação entre `pc1` e `pc3`, execute no `pc1`:
  
```bash
ping 192.168.70.10
```

- Realize os testes de ping entre todas as máquinas para garantir que o roteamento foi configurado corretamente.