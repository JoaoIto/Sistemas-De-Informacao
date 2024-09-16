using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Industria
    {
        int funcionarios = 675;
        double salarioFuncionarios = 10000;
        double caixa = 50000000;
        double custoProducaoItem = 42.75;
        double precoVendaItem = 75;

        public double ObterCaixa()
        {
            return caixa;
        }

        public void PagarSalarios()
        {
            Prefeitura prefeitura = new Prefeitura();
            Pagamento pagamento = new Pagamento(prefeitura);

            try
            {
                // Tenta realizar o pagamento dos salários
                caixa = pagamento.RealizarPagamento(funcionarios, salarioFuncionarios, caixa);
                Console.WriteLine($"Pagamento realizado INDÚSTRIA com sucesso.");
                Console.WriteLine($"Caixa atual INDÚSTRIA: {caixa:C}\n");
            }
            catch (InvalidOperationException ex)
            {
                // Caso o caixa seja insuficiente, exibe a mensagem de erro
                Console.WriteLine($"Erro: {ex.Message}");
            }
        }

        public double VenderItens(double quantidadeItens)
        {
            Prefeitura prefeitura = new Prefeitura();
            double totalVenda = quantidadeItens * precoVendaItem;
            double custoProducao = quantidadeItens * custoProducaoItem;
            double impostoVenda = totalVenda * 0.18;

            // Subtrai o custo de produção do caixa da indústria
            caixa -= custoProducao;

            // Adiciona o valor da venda ao caixa da indústria
            caixa += totalVenda;

            // Envia o imposto para a prefeitura
            prefeitura.ReceberImpostoVenda(impostoVenda);

            Console.WriteLine($"Indústria vendeu {quantidadeItens} itens. Total arrecadado: {totalVenda:C}. Caixa atual INDÚSTRIA: {caixa:C}");
            return totalVenda; // Retorna o valor total da venda
        }
    }
}
