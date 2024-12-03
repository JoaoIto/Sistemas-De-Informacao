### **README - Automação com Docker e Ansible na AWS**

---

#### **Descrição do Projeto**
Esta atividade consiste em configurar, instalar, versionar e manipular containers Docker em máquinas virtuais (VMs) hospedadas na AWS. O objetivo era criar, gerenciar e excluir containers de maneira automatizada utilizando o Ansible, com arquivos playbook para executar todas as operações. Foi utilizada a infraestrutura da AWS para provisionar as VMs necessárias.

---

### **Passos Realizados**

---

#### **1. Configuração da AWS**
1. **Criação de uma instância EC2**:
    - Escolha da AMI: `Amazon Linux 2`.
    - Tipo de instância: `t2.micro` (camada gratuita).
    - Par de chaves: Criado e baixado localmente como `VM1.pem`.
    - Configuração do grupo de segurança:
        - Porta 22 (SSH) aberta para o meu IP.
        - Porta 80 (HTTP) aberta para acesso externo.
    - Anexado um endereço IP público à instância.

2. **Acesso à instância via SSH**:
   Com o arquivo `.pem` baixado, conectei à instância usando:
   ```bash
   ssh -i "VM1.pem" ec2-user@<IP-PÚBLICO-DA-VM>
   ```

---

#### **2. Configuração da Máquina**
1. **Atualização do sistema operacional**:
   ```bash
   sudo yum update -y
   ```

2. **Instalação do Python 3 e Ansible**:
    - Habilitei o repositório Ansible:
      ```bash
      sudo amazon-linux-extras enable ansible2
      sudo yum install -y ansible python3
      ```

3. **Adicionei o Python ao inventário para evitar warnings**:
   Editei o arquivo `inventory.ini`:
   ```ini
   [docker]
   172.31.10.50 ansible_user=ec2-user ansible_ssh_private_key_file=/home/ec2-user/VM1.pem ansible_python_interpreter=/usr/bin/python3.9
   ```

4. **Criei um arquivo de inventário do Ansible**:
   ```bash
   nano inventory.ini
   ```
   Conteúdo:
   ```ini
   [docker]
   172.31.10.50 ansible_user=ec2-user ansible_ssh_private_key_file=/home/ec2-user/VM1.pem
   ```

---

#### **3. Instalação do Docker**
1. **Criação do Playbook `install_docker.yml`**:
   ```bash
   nano install_docker.yml
   ```
   Conteúdo:
   ```yaml
   ---
   - hosts: docker
     become: true
     tasks:
       - name: Atualizar pacotes
         yum:
           name: "*"
           state: latest
       - name: Instalar Docker
         yum:
           name: docker
           state: present
       - name: Iniciar Docker
         service:
           name: docker
           state: started
           enabled: true
   ```

2. **Execução do Playbook**:
   ```bash
   ansible-playbook -i inventory.ini install_docker.yml
   ```

3. **Adição do usuário ao grupo Docker**:
   ```bash
   sudo usermod -aG docker ec2-user
   exit
   ssh -i "VM1.pem" ec2-user@<IP-PÚBLICO-DA-VM>
   ```

---

#### **4. Criação e Gerenciamento de Containers**
1. **Baixar a imagem do Docker Hub**:
    - Criação do arquivo `pull_image.yml`:
      ```bash
      nano pull_image.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Baixar imagem do Nginx
            docker_image:
              name: nginx
              source: pull
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini pull_image.yml
      ```

2. **Criação dos containers**:
    - Criação do arquivo `create_containers.yml`:
      ```bash
      nano create_containers.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Criar containers
            docker_container:
              name: "web{{ item }}"
              image: nginx
              state: started
              ports:
                - "808{{ item }}:80"
            with_sequence: start=1 end=8
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini create_containers.yml
      ```

3. **Adicionar conteúdo às páginas dos containers**:
   ```bash
   for i in {1..8}; do
       echo "<h1>Bem-vindo ao WebServer $i</h1>" > /home/ec2-user/web$i/index.html
   done
   ```

---

#### **5. Gerenciamento de Containers**
1. **Pausar um container**:
    - Criação do arquivo `pause-web1.yml`:
      ```bash
      nano pause-web1.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Pausar container web1
            command: docker pause web1
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini pause-web1.yml
      ```

2. **Parar múltiplos containers**:
    - Criação do arquivo `stop_containers.yml`:
      ```bash
      nano stop_containers.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Parar múltiplos containers
            docker_container:
              name: "{{ item }}"
              state: stopped
            with_items:
              - web1
              - web2
              - web3
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini stop_containers.yml
      ```

3. **Despausar todos os containers**:
    - Criação do arquivo `unpause_all.yml`:
      ```bash
      nano unpause_all.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Listar containers pausados
            command: docker ps -q --filter "status=paused"
            register: paused_containers
          - name: Despausar containers
            command: docker unpause {{ item }}
            loop: "{{ paused_containers.stdout_lines }}"
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini unpause_all.yml
      ```

4. **Excluir todos os containers**:
    - Criação do arquivo `delete_all.yml`:
      ```bash
      nano delete_all.yml
      ```
      Conteúdo:
      ```yaml
      ---
      - hosts: docker
        become: true
        tasks:
          - name: Listar todos os containers
            command: docker ps -aq
            register: all_containers
          - name: Remover containers
            command: docker rm -f {{ item }}
            loop: "{{ all_containers.stdout_lines }}"
      ```
    - Execução:
      ```bash
      ansible-playbook -i inventory.ini delete_all.yml
      ```

---

#### **Resumo dos Playbooks Criados**
- `install_docker.yml`: Instala o Docker.
- `pull_image.yml`: Baixa a imagem do Nginx.
- `create_containers.yml`: Cria 8 containers com Nginx.
- `pause-web1.yml`: Pausa o container `web1`.
- `stop_containers.yml`: Para múltiplos containers.
- `unpause_all.yml`: Despausa todos os containers.
- `delete_all.yml`: Exclui todos os containers.

---
