# **Documentação do Projeto: **[Node-Balancer](https://github.com/JoaoIto/node-balancer)****

## **Introdução**

O projeto **Node Balancer** visa construir uma aplicação escalável e resiliente utilizando **Node.js** com **Express.js** ou **Nest.js**, **MongoDB Replica Set** para alta disponibilidade de dados, e **Nginx** como balanceador de carga. A arquitetura do sistema foi projetada para garantir **alta disponibilidade**, **escalabilidade horizontal** e **resiliência** em ambientes de produção, especialmente em cenários onde ocorrem falhas nos servidores ou nos componentes principais.

Este documento explica teoricamente as **arquiteturas distribuídas** utilizadas no projeto e como cada componente será implementado de forma a garantir uma solução robusta e eficiente.

---

## **Arquiteturas Envolvidas**

### **1. Arquitetura de Microsserviços**

A arquitetura **microsserviços** envolve a criação de aplicações modulares, onde cada serviço é responsável por uma parte do sistema e se comunica com os outros por meio de APIs bem definidas. Cada microsserviço pode ser escalado independentemente e é isolado em termos de recursos e dados.

#### **Vantagens da Arquitetura de Microsserviços:**

* **Escalabilidade**: Permite escalar cada serviço independentemente, dependendo da carga de trabalho.
* **Modularidade**: Facilita a manutenção, pois cada serviço pode ser atualizado sem afetar o restante do sistema.
* **Resiliência**: Se um microsserviço falhar, ele pode ser isolado sem afetar todo o sistema.

#### **Como será implementado:**

* **Node.js (Express/Nest.js)** será utilizado para criar APIs RESTful para cada microsserviço.
* Cada serviço será **containerizado com Docker**, o que facilita o gerenciamento e o deploy.
* O **Nginx** será configurado para atuar como **balanceador de carga**, distribuindo as requisições entre as instâncias de cada microsserviço.

---

### **2. Arquitetura de Banco de Dados (MongoDB Replica Set)**

A arquitetura de banco de dados adotada é a configuração de **MongoDB Replica Set**, onde uma instância primária é responsável pelas operações de gravação, enquanto as instâncias secundárias são usadas para leitura. O **failover automático** garante que, em caso de falha da instância primária, uma das secundárias seja promovida automaticamente.

#### **Vantagens do MongoDB Replica Set:**

* **Alta disponibilidade**: Em caso de falha de uma instância, o MongoDB promove automaticamente uma instância secundária.
* **Redundância**: As instâncias secundárias mantêm uma cópia dos dados da instância primária, garantindo que os dados estejam sempre disponíveis.
* **Escalabilidade**: Podemos adicionar mais réplicas de leitura para distribuir a carga de consultas.

#### **Como será implementado:**

* O **MongoDB Replica Set** será configurado em três instâncias para garantir a alta disponibilidade.
* A **instância primária** realizará operações de **gravação**, enquanto as **instâncias secundárias** se encarregarão das **consultas** de leitura.
* A comunicação entre as instâncias será configurada com a URL do **replica set** no arquivo `.env` da aplicação.

---

### **3. Balanceamento de Carga com Nginx**

O **Nginx** será utilizado como **proxy reverso** e **balanceador de carga**. Ele é responsável por distribuir as requisições de entrada para as instâncias de **Node.js** (microsserviços). O Nginx garante que o tráfego seja distribuído de forma equilibrada entre as instâncias e que, em caso de falha de uma delas, o tráfego seja redirecionado automaticamente para as instâncias saudáveis.

#### **Vantagens do Nginx como Balanceador de Carga:**

* **Alta Performance**: O Nginx é altamente eficiente em lidar com grandes volumes de tráfego.
* **Escalabilidade**: O Nginx pode distribuir as requisições entre várias instâncias de backend, garantindo que o sistema seja escalável horizontalmente.
* **Failover**: Se uma instância backend falhar, o Nginx redireciona as requisições para outras instâncias, garantindo continuidade do serviço.

#### **Como será implementado:**

* O **Nginx** será configurado para distribuir as requisições entre as instâncias de **Node.js** (backend).
* **Health checks** serão configurados para monitorar a saúde das instâncias e garantir que o tráfego só seja direcionado para instâncias ativas.

---

### **4. Escalabilidade Manual com Docker e Nginx**

O projeto utilizará **Docker** para **containerizar** os microsserviços, facilitando a replicação e o deploy de novas instâncias do backend. O **Nginx** realizará o **balanceamento de carga** manual, e o número de instâncias backend pode ser ajustado conforme a demanda de tráfego.

#### **Vantagens da Escalabilidade Manual:**

* **Flexibilidade**: O uso de Docker permite que novas instâncias sejam adicionadas facilmente.
* **Controle sobre o Escalonamento**: A escalabilidade é controlada manualmente com base no monitoramento de métricas como uso de **CPU**, **memória** e **latência**.
* **Isolamento**: Cada instância de backend é isolada em seu próprio container, permitindo fácil gerenciamento.

#### **Como será implementado:**

* **Docker Compose** ou **Kubernetes** (se necessário no futuro) será usado para orquestrar os containers.
* **Nginx** realizará o balanceamento entre as instâncias de backend, e novas instâncias poderão ser adicionadas ou removidas manualmente.

---

## **Como Rodar o Projeto**

### **Passo a Passo para Configuração Local**

Para rodar este projeto localmente, siga os passos abaixo:

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/JoaoIto/node-balancer.git
   cd node-balancer
   ```

2. **Instale as dependências**:
   Execute o seguinte comando para instalar as dependências:

   ```bash
   npm install
   ```

3. **Configure as variáveis de ambiente**:
   Crie um arquivo `.env` na raiz do projeto e adicione as variáveis de configuração, como a URL do MongoDB:

   ```
   MONGODB_URI=mongodb://localhost:27017/node-balancer
   PORT=3000
   ```

4. **Inicie o servidor**:
   Para rodar a aplicação em desenvolvimento, utilize o **Nodemon**:

   ```bash
   npm run dev
   ```

5. **Acesse a API**:
   Acesse a API através de `http://localhost:3000`. As rotas e funcionalidades da aplicação serão disponibilizadas conforme definido no backend.

---

## **Diagrama de Arquitetura**

Aqui está o diagrama ilustrando a arquitetura do sistema **Node Balancer**:

![Diagrama de Arquitetura](A_digital_architecture_diagram_illustrates_the_Nod.png)

---

## **Conclusão**

Este projeto foi desenvolvido com o objetivo de proporcionar uma solução **escalável**, **resiliente** e **altamente disponível** para sistemas distribuídos, utilizando **Node.js**, **MongoDB Replica Set**, e **Nginx** para balanceamento de carga. A modularidade da arquitetura facilita a manutenção, a escalabilidade horizontal e a continuidade do serviço mesmo em cenários de falha.

A implementação será validada por meio de testes de **resiliência** e de **escala** para garantir que o sistema opere de forma eficiente sob alta carga e possa se recuperar rapidamente de falhas.

---
