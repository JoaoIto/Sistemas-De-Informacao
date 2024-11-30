### *1. Teste Unitário*
#### Características:
- *Foco limitado:* Verifica unidades de código isoladamente, como funções ou métodos individuais.
- *Sem dependências externas:* Geralmente não envolve banco de dados, APIs ou interações do usuário. Depende de mocks ou stubs para simular essas dependências.
- *Objetivo:* Garantir que uma parte específica do código funcione como esperado em isolamento.

#### Exemplo:
No seu caso, um teste unitário poderia verificar a lógica de cálculo do saldo em uma função separada:
javascript
function calculateBalance(transactions) {
  return transactions.reduce((acc, transaction) => {
    return transaction.type === 'income'
      ? acc + transaction.amount
      : acc - transaction.amount;
  }, 0);
}

// Teste unitário
describe('calculateBalance', () => {
  it('should correctly calculate the balance', () => {
    const transactions = [
      { type: 'income', amount: 1000 },
      { type: 'expense', amount: 300 },
    ];
    expect(calculateBalance(transactions)).toBe(700);
  });
});


---

### *2. Teste de Integração*
#### Características:
- *Múltiplas partes do sistema:* Testa como diferentes módulos trabalham juntos (ex.: API e banco de dados).
- *Envolve dependências:* Interage com banco de dados real (ou em memória), autenticação, entre outros.
- *Objetivo:* Garantir que os componentes integrados funcionem corretamente.

#### Exemplo:
No teste de integração que apresentei, estamos verificando se:
1. A API POST consegue extrair dados do request.
2. A API autentica o usuário com base no token.
3. A API insere a transação no MongoDB corretamente.

Aqui, o foco não é o funcionamento individual de cada parte, mas sim como elas interagem.

---

### *3. Teste Funcional*
#### Características:
- *Simula o uso real:* Testa o sistema completo do ponto de vista do usuário, incluindo interface e API.
- *Baseado em cenários:* Avalia se o sistema atende aos requisitos de negócios em um cenário típico.
- *Objetivo:* Garantir que as funcionalidades esperadas estejam implementadas e funcionando corretamente.

#### Exemplo:
O teste funcional no Cypress verifica:
1. Se o usuário consegue abrir o formulário, preencher e enviar dados.
2. Se a transação adicionada aparece na lista da interface com os valores corretos.

Esse teste não se preocupa em saber se a API funciona isoladamente, mas sim se o sistema completo entrega a funcionalidade esperada.

---

### *Diferenças Resumidas*

| *Critério*            | *Teste Unitário*                        | *Teste de Integração*                | *Teste Funcional*                  |
|-------------------------|------------------------------------------|---------------------------------------|-------------------------------------|
| *Escopo*             | Parte específica do código (função/método) | Múltiplos componentes do sistema      | Sistema completo                    |
| *Dependências externas* | Geralmente não usa (mocka dependências)   | Envolve banco de dados, APIs, etc.    | Inclui toda a pilha (frontend/backend) |
| *Objetivo*            | Validar comportamento isolado            | Validar integração entre partes       | Validar experiência do usuário       |
| *Exemplo no seu caso* | Testar cálculo do saldo                  | Testar inserção de transação          | Testar adicionar transação via interface |

---

### *Por que não é um teste unitário?*
- *Teste de Integração:* Testa a API com banco de dados e autenticação real, enquanto o teste unitário se limitaria a uma função isolada.
- *Teste Funcional:* Simula interações completas do usuário, incluindo frontend e backend, enquanto o teste unitário ignora a interface ou outras partes externas.

Esses testes têm um escopo maior que os testes unitários e ajudam a garantir que o sistema funcione como um todo.