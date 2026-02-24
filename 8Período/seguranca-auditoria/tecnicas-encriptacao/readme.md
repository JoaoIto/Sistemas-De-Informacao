# Capítulo 2 - Técnicas Clássicas de Encriptação

Esta documentação foi estruturada detalhando a lógica algorítmica, manipulação de matrizes e permutações de strings que fundamentam a criptografia clássica — conceitos muito familiares no desenvolvimento full-stack. Todo o material abaixo é baseado nos fundamentos do livro "Criptografia e Segurança de Redes" (William Stallings, 6ª Edição).

---

## 1. O Modelo de Cifra Simétrica

A encriptação simétrica, também referida como encriptação convencional ou de chave única, foi o único tipo de encriptação amplamente utilizado até o surgimento da criptografia de chave pública.

**Os 5 Ingredientes Fundamentais:**

1. **Texto claro (Plaintext):** A mensagem ou dados originais e inteligíveis alimentados no algoritmo.
2. **Algoritmo de encriptação:** O motor matemático. Realiza várias substituições e transformações no texto claro.
3. **Chave secreta:** A entrada independente. O algoritmo produzirá saídas totalmente diferentes caso a chave fornecida seja alterada.
4. **Texto cifrado (Ciphertext):** A mensagem embaralhada produzida como saída. Ela é aparentemente aleatória e ininteligível.
5. **Algoritmo de decriptação:** O algoritmo de encriptação executado no sentido inverso, que pega o texto cifrado e a chave secreta e produz o texto claro original.

> **Nota de Referência:** O livro enfatiza que a segurança do sistema simétrico deve depender inteiramente do sigilo da chave, e não do sigilo do algoritmo. Essa é uma regra de ouro na segurança da informação.

### 1.1 Criptoanálise e Tipos de Ataques

Existem duas abordagens para comprometer um sistema: a **força bruta** (testar todas as chaves no espaço de chaves) e a **criptoanálise** (explorar fraquezas lógicas ou matemáticas do algoritmo).

A tabela abaixo categoriza os ataques baseados na quantidade de informação prévia que o atacante possui:

| Categoria do Ataque | Informação Conhecida pelo Criptoanalista |
| --- | --- |
| **Apenas texto cifrado** | O algoritmo de encriptação e o próprio texto cifrado a ser decodificado. É o mais difícil. |
| **Texto claro conhecido** | O algoritmo, o texto cifrado e um ou mais pares de texto claro e seu respectivo texto cifrado (gerados com a mesma chave). |
| **Texto claro escolhido** | O algoritmo, o texto cifrado e a capacidade de escolher uma mensagem clara específica e obter seu texto cifrado gerado pelo sistema. |
| **Texto cifrado escolhido** | O algoritmo, o texto cifrado alvo, além de poder inserir textos cifrados falsos no sistema para observar como ele os decripta para texto claro. |
| **Texto escolhido** | Combina o acesso tanto à escolha do texto claro quanto à do texto cifrado. |

---

## 2. Técnicas de Substituição

Uma técnica de substituição é aquela em que as letras do texto claro são substituídas por outras letras, números ou símbolos arbitrários.

### 2.1 Cifra de César

A técnica mais rudimentar. Substitui cada letra por outra localizada $k$ posições adiante no alfabeto.

* **Lógica Matemática:** $C = (P + k) \pmod{26}$
* **Vulnerabilidade:** Possui apenas 25 chaves possíveis. Facilmente quebrada por força bruta em milissegundos.

### 2.2 Cifras Monoalfabéticas

Qualquer permutação arbitrária do alfabeto de 26 letras pode ser usada como chave, associando cada letra a uma correspondente fixa.

* **Espaço de Chaves:** O número de chaves salta para $26!$ (fatorial de 26). A força bruta torna-se inviável.
* **Vulnerabilidade:** A cifra monoalfabética não oculta as frequências de uso das letras. Um atacante usa **análise de frequência** estatística (sabendo que as vogais "A" e "E" são as letras que mais aparecem em um idioma padrão) para quebrar o código mapeando as letras que mais se repetem no texto cifrado.

### 2.3 Cifra Playfair

Esta técnica trata diagramas (pares de letras) no texto claro e os traduz para diagramas de texto cifrado. Utiliza uma matriz 5x5 de letras construída com base em uma palavra-chave.

* **Vantagem:** Destrói as frequências de letras únicas, pois a análise passa a exigir a observação de $26 \times 26 = 676$ diagramas possíveis, tornando a criptoanálise estatística exponencialmente mais difícil.

### 2.4 Cifras Polialfabéticas

Para dificultar ainda mais, utiliza-se diferentes regras de substituição monoalfabética ao longo da mensagem. A **Cifra de Vigenère** é o melhor exemplo:

* Dependendo da letra de uma palavra-chave repetitiva, a cifra alterna para qual "alfabeto de César" ela enviará o caractere, achatando completamente as distribuições de frequência.

### 2.5 O One-Time Pad (Caderneta de Uso Único)

Proposto no início do século XX, resolve o problema fundamental das repetições.

* **Mecanismo:** Usa uma chave totalmente aleatória que possui o *mesmo tamanho* exato da mensagem original.
* **Status:** É a **única cifra incondicionalmente segura** existente. Como a chave é puramente aleatória e nunca se repete, o texto cifrado também é puramente aleatório e não fornece nenhuma pista matemática sobre o texto original.
* **Os Dois Problemas Práticos (Segundo Stallings):**
1. A geração de uma quantidade massiva de caracteres perfeitamente aleatórios.
2. O pesadelo logístico de distribuir com segurança uma chave do tamanho da mensagem para ambas as partes a cada nova comunicação.



---

## 3. Técnicas de Transposição

Diferente da substituição, as técnicas de transposição não alteram os caracteres, apenas rearranjam a ordem em que eles aparecem.

* **Cerca de Trilho (Rail Fence):** Escreve a mensagem em linhas diagonais alternadas (profundidade) e lê o resultado horizontalmente.
* **Transposição Colunar:** A mensagem é escrita horizontalmente em um grid e lida verticalmente, porém a ordem de leitura das colunas é ditada pela ordem alfabética de uma palavra-chave.
* **Transposição Dupla:** Como visto nos manuais militares detalhados no livro, submeter o texto a uma segunda transposição colunar destrói quase que por completo a regularidade estrutural da mensagem, tornando-a altamente resistente a criptoanálise.



---

## 4. Máquinas de Rotores

Antes da introdução das cifras modernas complexas via software, as máquinas eletromecânicas de rotores (como a Enigma alemã) representavam o ápice da criptografia clássica.

* **Como funciona:** Uma série de cilindros giratórios (rotores), onde cada cilindro aplica uma substituição monoalfabética por contatos elétricos. O detalhe letal para os analistas da época é que o rotor girava a cada tecla pressionada, mudando o alfabeto de substituição dinamicamente para cada letra da mensagem (um período polialfabético gigantesco).

---

## 5. Esteganografia

Enquanto as técnicas acima ocultam o *significado* de uma mensagem, a esteganografia oculta a própria *existência* da comunicação.

* **Exemplos práticos citados:** Tintas simpáticas (invisíveis), arranjos de caracteres em um texto de cobertura inofensivo ou a alteração do bit menos significativo em arquivos de imagem e áudio digitais.
* **Vantagens vs. Desvantagens:** A esteganografia atrai menos atenção suspeita do que um texto cifrado óbvio. No entanto, sua desvantagem principal é que seu custo de largura de banda é alto (requer um grande arquivo de cobertura para pouca informação) e, se o método for descoberto, a mensagem original fica instantaneamente exposta, pois raramente possui criptografia atrelada. O uso recomendado em sistemas seguros é a união de ambas as técnicas.
