# Criptografia Assimétrica, RSA e Complexidade

Para que o entendimento seja completo e prático, esta revisão detalhada foca em analogias, fluxos visuais e exemplos matemáticos aplicados, com base na 6ª Edição de "Criptografia e Segurança de Redes" (William Stallings).

---

## 1. O Paradigma da Chave Pública (Criptografia Assimétrica)

A grande revolução da criptografia de chave pública foi eliminar a necessidade de emissor e receptor combinarem uma senha secreta antes de se comunicarem.

**A Analogia do Cadeado e da Caixa de Correio:**
Imagine que Bob tenha uma caixa de correio com uma fenda aberta (Chave Pública) e uma porta trancada, cuja chave física apenas ele possui (Chave Privada).

* Qualquer pessoa no mundo pode jogar uma carta pela fenda da caixa (Encriptar com a Chave Pública).
* No entanto, uma vez que a carta cai lá dentro, nem mesmo a pessoa que a enviou consegue tirá-la. Apenas Bob, usando sua chave física (Chave Privada), pode abrir a porta e ler a mensagem (Decriptar).

### Fluxo de Comunicação Segura (Confidencialidade)

1. **Geração:** O receptor gera um par matemático de chaves.
2. **Distribuição:** O receptor publica sua Chave Pública para o mundo e esconde sua Chave Privada em um ambiente seguro.
3. **Encriptação:** O emissor captura a Chave Pública do receptor e a usa como parâmetro no algoritmo junto com a mensagem original.
4. **Decriptação:** O receptor recebe o texto ininteligível e aplica o algoritmo inverso usando sua Chave Privada.

<img width="667" height="414" alt="image" src="https://github.com/user-attachments/assets/030e1375-b523-4d90-92c5-7a319208b170" />


---

## 2. O Algoritmo RSA: Matemática na Prática

O RSA (Rivest-Shamir-Adleman) é o sistema assimétrico mais utilizado. Sua segurança não depende de um algoritmo complexo de embaralhamento, mas de um problema matemático clássico: **é fácil multiplicar dois números primos gigantes, mas é computacionalmente quase impossível fazer o caminho inverso (fatoração) para descobrir quais eram esses dois números originais.**

### Exemplo Didático Passo a Passo (Com números pequenos)

Vamos simular a comunicação onde Alice quer enviar a mensagem secreta **"M = 9"** para Bob.

**Fase 1: Bob cria suas chaves**

1. Bob escolhe dois números primos: `p = 3` e `q = 11`.
2. Bob calcula `n` (O módulo público): `n = 3 * 11 = 33`.
3. Bob calcula a função totiente de Euler `φ(n)`: `φ(n) = (3 - 1) * (11 - 1) = 2 * 10 = 20`.
4. Bob escolhe a Chave Pública `e`: Deve ser um número maior que 1, menor que 20, e que não compartilhe divisores com 20. Ele escolhe `e = 3`.
5. Bob calcula a Chave Privada `d`: O número `d` multiplicado por `e` (3), dividido por 20, deve deixar resto 1.
* `3 * 7 = 21`. Dividindo 21 por 20, o resto é 1. Logo, `d = 7`.

<img width="567" height="437" alt="image" src="https://github.com/user-attachments/assets/37510a51-c98e-4a03-ac17-140dc11d7ca3" />

**Resumo das Chaves:**

* **Chave Pública (Divulgada):** `n = 33`, `e = 3`
* **Chave Privada (Secreta):** `n = 33`, `d = 7`

**Fase 2: Alice Encripta a Mensagem**
Alice sabe que a Chave Pública de Bob é `n = 33, e = 3`. A mensagem dela é `M = 9`.

* Fórmula de Encriptação: `C = M^e mod n`
* Cálculo: `C = 9^3 mod 33`
* `9 * 9 * 9 = 729`
* Dividindo 729 por 33, temos 22, com **resto 3**.
* O Texto Cifrado enviado pela rede insegura é **C = 3**.

**Fase 3: Bob Decripta a Mensagem**
Bob recebe `C = 3`. Ele usa sua Chave Privada `d = 7`.

* Fórmula de Decriptação: `M = C^d mod n`
* Cálculo: `M = 3^7 mod 33`
* `3^7 = 2187`
* Dividindo 2187 por 33, temos 66, com **resto 9**.
* Bob recupera perfeitamente a mensagem original: **M = 9**.

---

## 3. Ataques de Temporização (Timing Attacks)

Mesmo que a matemática do RSA seja perfeita, a implementação física dele em um computador pode vazar informações.

**A Analogia do Ladrão de Cofres:**
Pense em um ladrão de bancos antigo que usa um estetoscópio na porta do cofre. Ele não sabe a combinação (chave privada), mas ao girar o dial, ele escuta os "cliques" das engrenagens internas caindo no lugar. Ao medir o som e o tempo exato de cada clique, ele descobre a senha.

Na computação, o ataque de temporização faz a mesma coisa com o processador (CPU).

**Como funciona na CPU:**
Durante a equação `M = C^d mod n`, o computador analisa a chave privada `d` em formato binário (0s e 1s).

* Se o bit for `0`, a CPU faz apenas uma operação (Exemplo: 2 milissegundos).
* Se o bit for `1`, a CPU faz duas operações matemáticas pesadas (Exemplo: 5 milissegundos).

Um atacante injeta milhares de textos cifrados no servidor e mede meticulosamente o tempo exato que o servidor leva para responder a cada um. Usando estatística, o atacante desenha o gráfico de tempo e revela se o processador estava lidando com um "0" ou um "1", reconstruindo a chave privada inteira sem precisar quebrar a fórmula do RSA.

**Solução principal (Cegamento/Blinding):**
O servidor multiplica o texto recebido por um número aleatório antes de processá-lo. Isso faz com que o tempo de processamento seja totalmente imprevisível e aleatório, "cegando" o estetoscópio digital do atacante.

---

## 4. Complexidade de Algoritmos (P, NP e NP-Completo)

Para entender por que quebrar o RSA na força bruta é considerado impossível, precisamos olhar para a Teoria da Complexidade (Apêndice 20A do livro).

**A Analogia do Quebra-Cabeça de 10.000 peças:**

* **Resolver** o quebra-cabeça do zero, com todas as peças misturadas, pode levar semanas (Problema Difícil).
* Mas se alguém montar o quebra-cabeça e lhe mostrar, você leva apenas **alguns segundos** para olhar e confirmar que a imagem está correta (Verificação Fácil).

### As Categorias de Problemas

| Classe | Significado Prático | O que representa na Criptografia | Exemplo do Dia a Dia |
| --- | --- | --- | --- |
| **Classe P (Polinomial)** | Problemas "Tratáveis". O computador resolve muito rápido, mesmo se a quantidade de dados aumentar. | Encriptar uma mensagem ou verificar uma assinatura digital. | Colocar uma lista de 500 nomes em ordem alfabética. |
| **Classe NP (Não-Determinístico)** | Problemas em que encontrar a solução é brutalmente demorado, mas **verificar** se uma solução apresentada está correta é instantâneo (Classe P). | Fatorar a chave do RSA. Se me derem a resposta, eu multiplico e verifico na hora. Se eu tiver que descobrir sozinho, levo bilhões de anos. | Montar o quebra-cabeça gigante do zero. |
| **NP-Completo** | Os "chefões" da Classe NP. Os problemas mais complexos já mapeados na computação. | Se um computador conseguir resolver um problema NP-Completo rapidamente, ele consegue quebrar todas as senhas do mundo instantaneamente. | Problema do Caixeiro Viajante (calcular a rota mais curta passando por dezenas de cidades). |

**O Resumo de Segurança:**
O RSA (e toda a criptografia moderna) sobrevive porque a humanidade ainda não descobriu uma forma de transformar problemas da classe NP em classe P. Se o problema da fatoração se tornar Classe P um dia (por exemplo, com a evolução dos computadores quânticos), o algoritmo RSA atual deixará de ser seguro.
