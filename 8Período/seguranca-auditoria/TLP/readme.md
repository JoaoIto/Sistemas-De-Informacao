# Tópico: Traffic Light Protocol (TLP) - Versão 2.0

Este documento resume as definições, normas e guias de uso do **Traffic Light Protocol (TLP) Versão 2.0**, baseado na documentação oficial do FIRST (Forum of Incident Response and Security Teams) e materiais do CERT.br (Centro de Estudos, Resposta e Tratamento de Incidentes de Segurança no Brasil).

O objetivo deste resumo é servir como material de apoio para a disciplina de Segurança e Auditoria de Sistemas, padronizando o entendimento sobre classificação e compartilhamento de informações sensíveis.

---

### 1. O que é o TLP?

[cite_start]O Traffic Light Protocol (TLP) é um padrão global criado para facilitar o compartilhamento de informações potencialmente sensíveis e fomentar a colaboração efetiva entre profissionais de segurança[cite: 315].

**Características principais:**
* [cite_start]**Conceito:** É um conjunto de quatro marcações (rótulos) usadas para indicar os limites de compartilhamento que devem ser aplicados pelos destinatários[cite: 317].
* [cite_start]**Objetivo:** Prover um esquema simples e intuitivo para indicar com quem a informação pode ser compartilhada[cite: 322].
* [cite_start]**Limitações:** O TLP não é um esquema formal de classificação legal, não trata de termos de licenciamento e não substitui regras de criptografia[cite: 323].
* [cite_start]**Responsabilidade:** A fonte da informação é responsável por garantir que os destinatários compreendam e sigam as regras do TLP[cite: 329].

---

### 2. Definições Fundamentais

Para aplicar o TLP corretamente, é necessário compreender os conceitos de agrupamento definidos na versão 2.0:

* **Comunidade:** Um grupo que compartilha objetivos, práticas e relacionamentos informais de confiança. [cite_start]Pode ser tão amplo quanto todos os profissionais de segurança de um país ou setor[cite: 384].
* [cite_start]**Organização:** Um grupo que compartilha uma mesma afiliação através de um processo formal e está sujeito a políticas comuns (ex: uma empresa, um órgão governamental)[cite: 386].
* **Clientes:** Pessoas ou entidades que recebem serviços de segurança cibernética de uma organização. [cite_start]No TLP, clientes são frequentemente incluídos no compartilhamento para que possam se proteger[cite: 388, 389].

---

### 3. As Marcações do TLP 2.0

O protocolo utiliza quatro cores principais. A versão 2.0 introduziu mudanças importantes, como a substituição do "TLP:WHITE" pelo "TLP:CLEAR" e a criação do modificador "TLP:AMBER+STRICT".

#### TLP:RED (Restrito ao Indivíduo)
* **Definição:** Somente para os olhos e ouvidos dos indivíduos destinatários. [cite_start]Não é permitido nenhum tipo de compartilhamento, nem mesmo dentro da mesma equipe[cite: 391].
* [cite_start]**Quando a Fonte deve usar:** Quando atuar sobre a informação pode colocar em risco a privacidade, reputação ou operações das partes envolvidas[cite: 392].
* **Regra para o Destinatário:** Não compartilhar com ninguém. [cite_start]Em reuniões, a informação fica limitada aos presentes[cite: 393].

#### TLP:AMBER (Restrito à Organização e Clientes)
* **Definição:** Divulgação limitada baseada na necessidade de saber (*need-to-know*). [cite_start]O compartilhamento é permitido dentro da própria organização e com seus clientes[cite: 394].
* [cite_start]**Quando a Fonte deve usar:** Quando é necessário apoio para agir de maneira efetiva, mas ainda existem riscos de privacidade ou operacionais[cite: 396].
* [cite_start]**Regra para o Destinatário:** Pode compartilhar com membros da própria organização e clientes que precisem da informação para proteção e mitigação[cite: 397].

#### TLP:AMBER+STRICT (Restrito APENAS à Organização)
* **Definição:** Uma variação restritiva do AMBER. O compartilhamento é permitido **apenas** dentro da organização do destinatário. [cite_start]**Não** pode ser compartilhado com clientes[cite: 395].
* [cite_start]**Quando a Fonte deve usar:** Quando a informação é sensível demais para sair da organização, mas precisa circular internamente para ação[cite: 398].
* [cite_start]**Nota:** Esta é a principal adição da versão 2.0 para diferenciar dados internos de dados compartilháveis com clientes[cite: 167].

#### TLP:GREEN (Comunidade)
* **Definição:** Divulgação limitada à comunidade. [cite_start]A informação é útil para conscientização de pares e parceiros[cite: 399].
* [cite_start]**Quando a Fonte deve usar:** Quando a informação é útil para a comunidade mais ampla de segurança, mas não deve ser pública[cite: 400].
* **Regra para o Destinatário:** Pode compartilhar com organizações parceiras e pares na comunidade. [cite_start]**Não** pode ser publicado em canais publicamente acessíveis (como sites abertos ou redes sociais)[cite: 401].

#### TLP:CLEAR (Público)
* **Definição:** Não há limites na divulgação. [cite_start]Substitui o antigo TLP:WHITE[cite: 404].
* [cite_start]**Quando a Fonte deve usar:** Quando há risco mínimo ou inexistente de mau uso da informação[cite: 405].
* [cite_start]**Regra para o Destinatário:** Pode disseminar para o mundo, respeitando direitos autorais padrão[cite: 406].

---

### 4. Guia de Uso e Formatação

Para que o protocolo funcione, a formatação deve ser consistente.

#### Em Mensagens (E-mail e Chat)
1.  [cite_start]**Obrigatoriedade:** A marcação TLP deve preceder a informação[cite: 339].
2.  [cite_start]**Assunto:** A marcação deve (SHOULD) constar na linha de assunto do e-mail[cite: 340].
3.  [cite_start]**Sintaxe:** Deve ser escrita em maiúsculas e sem espaços (ex: `TLP:RED`, e não `tlp red`)[cite: 320].

#### Em Documentos (PDF, DOCX)
1.  [cite_start]**Localização:** A marcação deve constar no cabeçalho e no rodapé de **cada página**[cite: 343].
2.  [cite_start]**Tamanho:** Recomenda-se fonte tamanho 12 ou maior para acessibilidade[cite: 344].
3.  [cite_start]**Alinhamento:** Recomenda-se alinhar à direita[cite: 345].

#### Cores Oficiais (Acessibilidade)
[cite_start]O TLP 2.0 define códigos de cores específicos para garantir contraste suficiente para leitura, inclusive para pessoas com baixa visão[cite: 377].

| Marcação | Código Hex (Fonte) | Código Hex (Fundo) |
| :--- | :--- | :--- |
| **TLP:RED** | `#FF2B2B` | `#000000` |
| **TLP:AMBER** | `#FFC000` | `#000000` |
| **TLP:GREEN** | `#33FF00` | `#000000` |
| **TLP:CLEAR** | `#FFFFFF` | `#000000` |

[cite_start]*Fonte dos códigos de cores: Tabela oficial FIRST [cite: 331]*

---

### 5. Resumo Comparativo TLP 1.0 vs TLP 2.0

As principais alterações na nova versão incluem:
* [cite_start]**Mudança de Nomenclatura:** `TLP:WHITE` agora é `TLP:CLEAR` para maior clareza[cite: 124].
* [cite_start]**Nova Categoria:** Introdução do `TLP:AMBER+STRICT` para restringir o compartilhamento apenas à organização, excluindo clientes[cite: 122].
* [cite_start]**Definições:** Formalização dos termos Comunidade, Organização e Clientes[cite: 129].
* [cite_start]**Clareza:** O texto foi revisado para remover ambiguidades e facilitar a tradução (ex: uso de "MUST" e "SHOULD" conforme RFC-2119)[cite: 413].

---

### 6. Referências

* **FIRST Standards Definitions and Usage Guidance — Version 2.0**: Documento oficial de padronização.
* **CERT.br (NIC.br)**: Apresentação sobre TLP 2.0 no GTS 37 (2022) por Dra. Cristine Hoepers.
* **Tradução Oficial**: Versão em Português Brasileiro mantida pelo CERT.br, CAIS/RNP e CSIRT PETROBRAS.

---
