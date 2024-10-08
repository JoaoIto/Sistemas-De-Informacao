Aqui está o relatório no formato `readme.md`, com as imagens incluídas conforme solicitado:

---

# Relatório de Atividade de Redes com Ansible

Este relatório descreve as etapas realizadas durante a configuração e uso do Ansible para automatizar tarefas em servidores remotos. Foram utilizadas instâncias configuradas na AWS, e a seguir estão os passos detalhados, com cada imagem ilustrando o procedimento.

---

## 1. Gerando Chaves SSH

A primeira etapa foi gerar as chaves SSH para permitir a conexão segura entre o Control Node e os servidores.

![Geração de chave SSH](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/keys/repassKeysForUbuntu.jpeg)

---

## Atualizando ubuntu nas máquinas:

![Atualização do Ubuntu](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/inicializandoUbuntuServer.jpeg)

![Atualização do Ubuntu](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/updateUbuntu.jpeg)

## 2. Instalando o Ansible no Control Node

A instalação do Ansible foi realizada no Control Node (nossa máquina de controle). Após a instalação, a versão do Ansible foi verificada.

![Instalação do Ansible](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/installAnsible.jpeg)

---

## 3. Configurando o Inventário

O arquivo de inventário foi editado para incluir os servidores que seriam gerenciados. 

![Configuração do Inventário](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/configServers.jpeg)

---

## 4. Testando a Conexão com os Servidores

Antes de enviar comandos ou playbooks, foi verificado se os servidores estavam acessíveis através do comando `ping` do Ansible.

![Teste de conexão com o comando Ping](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/testPing.jpeg)

---

## 5. Enviando Comandos Remotos

Com os servidores devidamente configurados e acessíveis, comandos avulsos foram enviados, como a atualização dos pacotes.

![Playbooks create](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/playbookApache.jpeg)

![Playbooks create 2](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/playbookNginx.jpeg)


---

## 6. Criando e Executando Playbook

Um playbook simples foi criado para instalar o Nginx nos servidores.

![Playbooks execute](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/playPlaybook.jpeg)


![Playbooks execute](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/playPlaybook2.jpeg)

---

## 7. Verificação de Serviços nos Servidores

Por fim, foi verificado se o serviço do Nginx estava rodando corretamente nos servidores através do comando `uptime`.

![Teste de conexão com o comando Ping](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/ansibleVersion.jpeg)

![Uptime Ansible](https://github.com/JoaoIto/Sistemas-De-Informacao/blob/main/5Per%C3%ADodo/Computacao-Orientada-a-Servicos/Atividade2/images/config/controlServer/ansibleUptime.jpeg)

---

Este foi o resumo das atividades realizadas para a configuração de automação de tarefas usando o Ansible.

--- 

Esse relatório contém as imagens em seus respectivos caminhos. Certifique-se de verificar se todos os links estão corretos no repositório.