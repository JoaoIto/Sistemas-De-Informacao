### Implementação de Semáforos

#### Semáforos Básicos
- **Composição:** Fila de tarefas e contador inteiro.
- **Operações:**
    - `down(s)`: Decrementa o contador. Bloqueia se o contador for zero.
    - `up(s)`: Incrementa o contador. Desbloqueia uma tarefa em espera, se houver.

#### Semáforos Mutex
- **Definição:** Semáforos binários usados para garantir exclusão mútua.
- **Operações:** `P(down)` e `V(up)`

### Variáveis de Condição
- **Definição:** Usadas para esperar por condições específicas sem usar espera ocupada.
- **Operações:**
    - `wait(c)`: Coloca a tarefa em espera até a condição ser verdadeira.
    - `signal(c)`: Notifica que a condição se tornou verdadeira.

---