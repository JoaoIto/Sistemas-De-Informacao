using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Prefeitura
    {
        // Parâmetros iniciais da Prefeitura
        int funcionarios = 125;
        double caixa = 500000; // Valor inicial no caixa
        int salarioFuncionarios = 20000; // Salário de cada funcionário
        int bolsaServicosSociais = 1000; // Valor da bolsa dos serviços sociais
        int bolsistas = 55;
        private Pagamento pagamento;
        public Prefeitura()
        {
            // Inicializa a classe Pagamento com a instância atual de Prefeitura
            pagamento = new Pagamento(this);
        }
        // Método que tenta realizar o pagamento dos salários dos funcionários
        public void PagarSalarios()
        {

            try
            {
                // Tenta realizar o pagamento dos salários
                caixa = pagamento.RealizarPagamento(funcionarios, salarioFuncionarios, caixa);
                Console.WriteLine($"Pagamento realizado PREFEITURA com sucesso. Caixa atual: {caixa:C}");

                // Realiza o pagamento das bolsas dos serviços sociais
                caixa = pagamento.RealizarPagamento(bolsistas, bolsaServicosSociais, caixa);
                Console.WriteLine($"Pagamento das bolsas PREFEITURA realizado.");

                Console.WriteLine($"Caixa atual PREFEITURA: {caixa:C}\n");
            }
            catch (InvalidOperationException ex)
            {
                // Caso o caixa seja insuficiente, exibe a mensagem de erro
                Console.WriteLine($"Erro: {ex.Message}");
            }
        }

        // Método que recebe o imposto sobre os salários do comércio
        public void ReceberImpostoSalario(double valorImposto)
        {
            caixa += valorImposto;
            Console.WriteLine($"Prefeitura recebeu R$ {valorImposto:C} de impostos sobre salários do comércio.");
            Console.WriteLine($"Caixa atual PREFEITURA: {caixa:C}\n");
        }

        // Novo método para receber o imposto sobre as vendas
        public void ReceberImpostoVenda(double valorImpostoVenda)
        {
            caixa += valorImpostoVenda;
            Console.WriteLine($"Prefeitura recebeu R$ {valorImpostoVenda:C} de impostos sobre vendas do comércio.");
            Console.WriteLine($"Caixa atual PREFEITURA: {caixa:C}\n");
        }

    }
}

