### **Roteamento Dinâmico**  

O **roteamento dinâmico** é um método de roteamento onde os roteadores aprendem e atualizam automaticamente as melhores rotas da rede através da troca de informações entre si. Esse tipo de roteamento é essencial para redes médias e grandes, onde as rotas podem mudar frequentemente devido a falhas ou novas conexões.  

#### **Características**  
- Os roteadores **trocam informações periodicamente** para manter a tabela de roteamento atualizada.  
- Utiliza **protocolos de roteamento dinâmico**, como OSPF, EIGRP, RIP e BGP.  
- **Se adapta automaticamente** a mudanças na rede, recalculando rotas em caso de falhas.  

#### **Vantagens**  
- **Escalabilidade**: ideal para redes médias e grandes, pois não exige configuração manual para cada rota.  
- **Automação**: os roteadores aprendem e ajustam as rotas sem intervenção humana.  
- **Convergência rápida**: quando uma falha ocorre, os roteadores encontram rapidamente um novo caminho.  

#### **Desvantagens**  
- **Maior uso de CPU e memória**, pois os roteadores precisam processar constantemente as informações de roteamento.  
- **Pode ser alvo de ataques**, caso não haja medidas de segurança adequadas.  
- **Tráfego adicional na rede**, pois há troca de mensagens entre roteadores para manter as tabelas de roteamento atualizadas.  

#### **Principais Protocolos de Roteamento Dinâmico**  
- **RIP (Routing Information Protocol)** → Simples, adequado para redes pequenas.  
- **EIGRP (Enhanced Interior Gateway Routing Protocol)** → Protocolo híbrido da Cisco, eficiente para redes médias.  
- **OSPF (Open Shortest Path First)** → Baseado em estado de enlace, ideal para redes grandes.  
- **BGP (Border Gateway Protocol)** → Utilizado para roteamento entre sistemas autônomos na Internet.  

#### **Exemplo de Configuração OSPF em um Roteador Cisco**  
```bash
router ospf 1
 network 192.168.1.0 0.0.0.255 area 0
```
- O roteador participa do **processo OSPF 1** e anuncia a rede **192.168.1.0/24**.  
- Se um link falhar, o OSPF recalcula automaticamente a melhor rota.  

#### **Quando Usar o Roteamento Dinâmico?**  
- Em **redes grandes**, onde a configuração manual de rotas seria inviável.  
- Em **ambientes dinâmicos**, onde novas conexões ou falhas podem ocorrer frequentemente.  
- Quando **redundância e alta disponibilidade** são essenciais para a rede.  

Em resumo, o roteamento dinâmico traz **flexibilidade e automação**, permitindo que as redes se adaptem rapidamente a mudanças. No entanto, exige mais recursos dos roteadores e pode gerar tráfego adicional na rede.
