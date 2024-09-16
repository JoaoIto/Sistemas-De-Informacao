using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Comercio
    {
        int funcionarios = 200;
        double salarioFuncionarios = 7500;
        double caixa = 10000000;
        double custoReposicao = 75;
        double precoItem = 203;

        double salarioLiquido = 4650;
        double impostoSalario = 3575;

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
                Console.WriteLine($"Pagamento realizado COMÉRCIO com sucesso.");
                Console.WriteLine($"Caixa atual COMÉRCIO: {caixa:C}\n");
            }
            catch (InvalidOperationException ex)
            {
                // Caso o caixa seja insuficiente, exibe a mensagem de erro
                Console.WriteLine($"Erro: {ex.Message}");
            }
        }

        // Método para vender produtos ao consumidor
        public void VenderProduto(int quantidadeItens, Prefeitura prefeitura)
        {
            // Calcula o total da venda
            double valorTotalVendas = quantidadeItens * precoItem;

            // Calcula o imposto sobre a venda (38% do valor total)
            double impostoSobreVendas = valorTotalVendas * 0.38;

            // Calcula o valor líquido que o comércio retém
            double valorLiquidoComercio = valorTotalVendas - impostoSobreVendas;

            // Atualiza o caixa do comércio com o valor líquido
            caixa += valorLiquidoComercio;

            // Repassa o valor do imposto para a prefeitura
            prefeitura.ReceberImpostoVenda(impostoSobreVendas);

            Console.WriteLine($"Comércio vendeu {quantidadeItens} itens por um total de {valorTotalVendas:C}.");
            Console.WriteLine($"Imposto recolhido: {impostoSobreVendas:C}. Valor líquido: {valorLiquidoComercio:C}.");
            Console.WriteLine($"Caixa atual COMÉRCIO: {caixa:C}\n");
        }

        public void ReporEstoque(Industria industria)
        {
            double quantidadeItensARepor = 36.94;

            // Compra os itens da indústria
            double totalCompra = industria.VenderItens(quantidadeItensARepor);

            // Subtrai o valor total da compra do caixa do comércio
            caixa -= totalCompra;

            Console.WriteLine($"Comércio repôs {quantidadeItensARepor} itens. Valor total da compra: {totalCompra:C}. Caixa atual COMÉRCIO: {caixa:C}");
        
        }

        // Método que calcula e paga o imposto sobre salários para a prefeitura
        public void PagarImpostoSalario(Prefeitura prefeitura)
        {
            // Calcula o valor total de imposto sobre os salários
            double totalImposto = funcionarios * impostoSalario;

            // Subtrai o valor do imposto do caixa do comércio
            caixa -= totalImposto;

            Console.WriteLine($"Comércio pagou R$ {totalImposto:C} em impostos sobre salários.");

            // Envia o valor do imposto para a prefeitura
            prefeitura.ReceberImpostoSalario(totalImposto);

            Console.WriteLine($"Caixa atual COMÉRCIO após pagamento do imposto: {caixa:C}\n");
        }
    }
}
