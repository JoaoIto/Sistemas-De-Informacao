# Arquiteturas de Sistemas Operacionais

1. **Monolítica**:
   - **Definição**: Na arquitetura monolítica, todo o sistema operacional é implementado como um único programa grande e complexo. Todas as funcionalidades, como gerenciamento de processos, sistema de arquivos e drivers de dispositivo, residem no mesmo espaço de endereço e operam no modo kernel.
   - **Características**: Este tipo de arquitetura é conhecido por ser simples e eficiente em termos de desempenho, pois não há sobrecarga de comunicação entre os componentes do sistema operacional.
   - **Exemplo**: O Linux é um exemplo de um sistema operacional com uma arquitetura monolítica. No Linux, todos os principais componentes do sistema operacional, incluindo gerenciamento de processos, sistema de arquivos e drivers de dispositivo, estão integrados ao núcleo do sistema (kernel).

2. **Micronúcleo (ou Núcleo Exocernel)**:
   - **Definição**: Na arquitetura de micronúcleo, apenas as funcionalidades essenciais do sistema operacional, como gerenciamento de memória e comunicação entre processos, residem no núcleo do sistema. Funcionalidades mais complexas, como gerenciamento de arquivos e protocolos de rede, são implementadas como processos de usuário.
   - **Características**: Esta abordagem visa maximizar a modularidade e a segurança do sistema operacional, permitindo que os serviços sejam adicionados ou removidos facilmente. Além disso, ela visa reduzir o tamanho do núcleo do sistema, aumentando a confiabilidade e a segurança.
   - **Exemplo**: O sistema operacional Mach é um exemplo de um sistema operacional com uma arquitetura de micronúcleo. Ele foi desenvolvido na Universidade Carnegie Mellon e serviu como base para sistemas como macOS e GNU Hurd.

3. **Híbrida**:
   - **Definição**: A arquitetura híbrida combina características da arquitetura monolítica e do micronúcleo. Ela mantém algumas funcionalidades essenciais no núcleo do sistema operacional, enquanto outras funcionalidades são implementadas como processos de usuário.
   - **Características**: Essa abordagem visa combinar a eficiência e o desempenho da arquitetura monolítica com a modularidade e a segurança da arquitetura de micronúcleo.
   - **Exemplo**: O Windows NT é um exemplo de um sistema operacional com uma arquitetura híbrida. Ele possui um núcleo (kernel) que contém funcionalidades essenciais, como gerenciamento de memória e comunicação entre processos, enquanto outros componentes, como o sistema de arquivos e os drivers de dispositivo, são executados em modo de usuário.
  
   - ---
   
