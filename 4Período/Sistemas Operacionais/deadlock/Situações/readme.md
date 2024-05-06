# Situações que ocorrem ***deadlock***


1. **Mutual Exclusion (Exclusão Mútua)**: Pelo menos um recurso deve ser de exclusão mútua, o que significa que apenas um processo por vez pode usá-lo. Se um processo já estiver usando o recurso, outros processos devem esperar até que ele seja liberado.

2. **Hold and Wait (Espera Ocupada)**: Um processo deve estar segurando pelo menos um recurso e esperando para adquirir mais recursos que estão sendo segurados por outros processos. Isso cria uma situação em que os processos podem ficar esperando indefinidamente.

3. **No Preemption (Não Preempção)**: Os recursos não podem ser tomados à força dos processos que já os possuem; eles só podem ser liberados voluntariamente pelos processos que os estão utilizando. Isso significa que um processo não pode ser interrompido e ter seus recursos realocados para outro processo.

4. **Circular Wait (Espera Circular)**: Deve haver um ciclo de espera, onde um processo está esperando por um recurso que é mantido por outro processo, que por sua vez está esperando por um recurso mantido pelo primeiro processo. Isso cria uma situação circular de dependência entre os processos.

Quando todas essas condições são atendidas simultaneamente, um deadlock pode ocorrer.

---