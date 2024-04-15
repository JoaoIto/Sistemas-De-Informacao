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
