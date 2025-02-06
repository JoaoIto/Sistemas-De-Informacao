### **Sistemas Autônomos (AS - Autonomous Systems)**  

Na comunicação entre redes, um **Sistema Autônomo (AS - Autonomous System)** representa um conjunto de **roteadores e redes IP** sob um mesmo controle administrativo, que compartilham uma política de roteamento comum. Cada AS é identificado por um **número único (ASN - Autonomous System Number)**, atribuído por organizações como a IANA e os RIRs (Regional Internet Registries).  

Os sistemas autônomos desempenham um papel fundamental no funcionamento da Internet, pois permitem que redes de diferentes organizações **se comuniquem de forma organizada e controlada**. Empresas, provedores de internet (ISPs) e grandes instituições utilizam AS para gerenciar o tráfego e otimizar a conectividade global.  

- **Tipos de Sistemas Autônomos**  
  - **AS Stub**: Possui **apenas uma conexão** com outro AS, sem capacidade de roteamento para terceiros.  
  - **AS Multi-Homed**: Conectado a **múltiplos ASs**, aumentando redundância, mas sem repassar tráfego entre eles.  
  - **AS Transit**: Fornece conectividade **entre diferentes ASs**, funcionando como intermediário no roteamento global.  

- **Identificação e Controle**  
  - Cada AS recebe um **ASN (Número de Sistema Autônomo)**, que pode ser público ou privado.  
  - ASNs são registrados pelos **RIRs (Regional Internet Registries)**, como ARIN, RIPE e LACNIC.  
  - Redes privadas podem usar **ASN reservados** (64512-65534 para ASN de 16 bits e 4200000000-4294967294 para 32 bits).  

- **Papel no Roteamento**  
  - Sistemas autônomos são fundamentais para a implementação do **BGP-4**, o protocolo que governa o roteamento entre ASs na Internet.  
  - ASs definem **políticas de roteamento**, escolhendo quais redes anunciar e quais caminhos preferir.  
  - O tráfego da Internet flui entre ASs por meio de acordos como **peering** (troca direta) e **trânsito IP** (uso de infraestrutura de terceiros).  

Compreender sistemas autônomos é essencial para o estudo de **roteamento avançado**, pois eles determinam como grandes redes se interconectam e como o tráfego global é distribuído de maneira eficiente e segura.
