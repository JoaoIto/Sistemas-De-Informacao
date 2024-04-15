# Relacionamentos

Fazendo casos de uso, precisamos entender quais os tipos de relacionamento que tem, e a diferença de um pro outro...

1. **Associação (Association):** Representada por uma linha simples, a associação é uma relação geral entre dois elementos. Por exemplo, em um diagrama de caso de uso de um sistema de biblioteca, pode haver uma associação entre o ator "Usuário" e o caso de uso "Realizar Empréstimo". Isso indica que os usuários estão associados à ação de realizar empréstimos de livros.

   ```
   Usuário ----- Realizar Empréstimo
   ```

2. **Inclusão (Inclusion):** Representada por uma linha tracejada com uma seta aberta na ponta, a inclusão indica que um caso de uso (incluído) é parte de outro caso de uso (incluidor). Por exemplo, no mesmo sistema de biblioteca, o caso de uso "Renovar Empréstimo" pode ser incluído no caso de uso "Realizar Empréstimo". Isso significa que a renovação de empréstimos é uma etapa que faz parte do processo de realizar um empréstimo.

   ```
   Realizar Empréstimo -----► Renovar Empréstimo
   ```

3. **Extensão (Extension):** Representada por uma linha tracejada com uma seta aberta na ponta e um ponto de extensão marcado, a extensão indica que um caso de uso (extensão) pode adicionar funcionalidades opcionais a outro caso de uso (base) em um ponto específico. Por exemplo, no sistema de biblioteca, o caso de uso "Notificar Usuário de Atraso" pode ser uma extensão do caso de uso "Realizar Empréstimo". Isso significa que, se um empréstimo estiver atrasado, o sistema pode notificar o usuário durante o processo de empréstimo.

   ```
   Realizar Empréstimo -----(ponto de extensão)----► Notificar Usuário de Atraso
   ```

Esses são exemplos simplificados para ilustrar como cada tipo de seta é usado em um diagrama de caso de uso.

## Representações de relacionamentos

As representações das setas nos relacionamentos, que tem, temos que entender qual a diferenças dessas setas de relacionamentos.

Claro, vou fornecer um exemplo de cada tipo de seta com as setas apropriadas:

1. **Seta Tracejada (Relação Opcional):**
   - Exemplo: No sistema de uma loja online, há o caso de uso "Realizar Pagamento". Esse caso de uso pode opcionalmente incluir o caso de uso "Utilizar Cupom de Desconto". Nem todos os clientes usam cupons de desconto, então essa relação é opcional.
   
   ```
   Realizar Pagamento -----► Utilizar Cupom de Desconto
   ```

2. **Seta Contínua (Relação Obrigatória):**
   - Exemplo: No mesmo sistema da loja online, após o cliente realizar o pagamento, é necessário gerar um comprovante de compra. Portanto, o caso de uso "Gerar Comprovante de Compra" é uma parte essencial do fluxo de "Realizar Pagamento".
   
   ```
   Realizar Pagamento -----► Gerar Comprovante de Compra
   ```

3. **Seta do Lado Esquerdo ou Direito (Direção do Fluxo):**
   - Exemplo: No contexto da loja online, o ator "Cliente" inicia o processo de realizar um pedido, então a seta estará no lado esquerdo do caso de uso "Realizar Pedido", indicando que o cliente é quem inicia esse caso de uso.
   
   ```
   Cliente ----- Realizar Pedido
   ```

Espero que esses exemplos ilustrem claramente o uso de cada tipo de seta em um diagrama de caso de uso.

---
