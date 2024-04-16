# Máquinas Virtuais (VMs)

## Definição:
Máquinas Virtuais (VMs) são ambientes de computação virtuais que emulam o hardware físico de um computador e permitem a execução de sistemas operacionais e aplicativos neles. Elas fornecem uma camada de abstração entre o software e o hardware físico, permitindo a execução de múltiplos sistemas operacionais ou instâncias de aplicativos em um único hardware físico.

## Resumo 

Em resumo, as máquinas virtuais são ferramentas poderosas para criar ambientes de computação isolados e independentes. As VMs de sistema são usadas para virtualizar sistemas operacionais completos, enquanto as VMs de aplicação são usadas para virtualizar aplicativos específicos, oferecendo diferentes níveis de isolamento e overhead.


### Tipos:
1. **Máquinas Virtuais de Sistema**:
   - Permitem a execução de sistemas operacionais completos em uma máquina virtual.
   - Cada VM de sistema é como um computador independente com seu próprio sistema operacional, recursos e aplicativos.
   - Exemplos: VirtualBox, VMware, Hyper-V.

2. **Máquinas Virtuais de Aplicação**:
   - Permitem a virtualização de aplicativos específicos em vez de sistemas operacionais completos.
   - São projetadas para isolar e executar aplicativos em um ambiente virtualizado, sem afetar o sistema operacional hospedeiro.
   - Exemplos: Docker, Java Virtual Machine (JVM).

### Diferenças:
1. **Escopo**:
   - As VMs de sistema virtualizam todo o sistema operacional, incluindo kernel, drivers e subsistemas.
   - As VMs de aplicação virtualizam apenas os recursos necessários para executar aplicativos específicos, mantendo o sistema operacional hospedeiro intacto.

2. **Isolamento**:
   - As VMs de sistema oferecem isolamento completo entre as VMs, pois cada uma executa seu próprio sistema operacional e kernel.
   - As VMs de aplicação oferecem isolamento em nível de aplicativo, permitindo que aplicativos sejam executados em contêineres independentes.

3. **Overhead**:
   - As VMs de sistema geralmente têm um overhead maior devido à virtualização de recursos completos de hardware.
   - As VMs de aplicação têm um overhead menor, pois compartilham recursos do sistema operacional hospedeiro.
---
