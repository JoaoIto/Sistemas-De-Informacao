### Sincronização e Exclusão Mútua

#### Condições de Corrida
- **Definição:** Situações onde processos concorrentes acessam dados compartilhados, levando a resultados imprevisíveis.
- **Exemplo:** Atualização de um saldo de conta bancária por múltiplos processos simultaneamente.

#### Regiões Críticas
- **Definição:** Trechos de código que acessam recursos compartilhados e podem causar condições de corrida.
- **Exemplo:** Reservas de assentos onde é necessário evitar overbooking.

#### Soluções para Exclusão Mútua
- **Inibição de Interrupções:** Desativa interrupções para proteger a região crítica. Raramente utilizada devido a limitações.
- **Espera Ocupada (Busy Waiting):** Uso de variáveis para indicar se a região crítica está ocupada. Ineficiente e pode causar condições de corrida.
- **Operações Atômicas:** Instruções de hardware que executam operações de teste e atribuição de forma indivisível.
- **Semáforos:** Variáveis que utilizam operações atômicas `down` e `up` para controlar o acesso a recursos.
- **Monitores:** Estruturas que encapsulam o recurso compartilhado, garantindo a exclusão mútua automaticamente.

### Monitores
- **Definição:** Estruturas que automatizam a exclusão mútua, encapsulando recursos e procedimentos.
- **Elementos:**
    - Recurso compartilhado
    - Procedimentos de acesso
    - Mutex ou semáforo
    - Invariante que deve sempre ser verdadeira

#### Implementação em Linguagens de Programação
- **Java:** Uso da cláusula `synchronized` para associar semáforos a métodos de um objeto.

### Exemplo de Aplicação Concorrente

#### Problema de Condições de Corrida
- **Exemplo:** Depósitos em uma conta bancária por múltiplos usuários.
- **Solução:** Uso de semáforos ou monitores para garantir que apenas um processo acesse a região crítica por vez.

#### Soluções de Exclusão Mútua
- **Inibição de Interrupções:** Não recomendado para sistemas complexos.
- **Espera Ocupada:** Ineficiente e propensa a erros.
- **Semáforos e Monitores:** Soluções mais robustas e eficientes para garantir a sincronização e evitar condições de corrida.
