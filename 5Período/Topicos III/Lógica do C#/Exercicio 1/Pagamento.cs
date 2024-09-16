using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Pagamento
    {
        private Prefeitura prefeitura;

        // Construtor para inicializar a Prefeitura
        public Pagamento(Prefeitura prefeitura)
        {
            this.prefeitura = prefeitura;
        }

        // Método que realiza o pagamento dos salários
        public double RealizarPagamento(int quantidadeEmpregados, double salarioPorEmpregado, double caixaAtual)
        {
            // Calcula o desconto de 25%
            double desconto = salarioPorEmpregado * 0.25;
            double salarioDescontado = salarioPorEmpregado - desconto;

            // Calcula o total a ser pago após desconto
            double totalPagamento = quantidadeEmpregados * salarioDescontado;

            // Recolhe o imposto pela prefeitura
            prefeitura.ReceberImpostoSalario(desconto * quantidadeEmpregados);

            // Subtrai o valor do pagamento, mesmo que o caixa fique negativo
            caixaAtual -= totalPagamento;

            // Retorna o valor atualizado do caixa, que pode ser negativo
            return caixaAtual;
        }
    }
}

