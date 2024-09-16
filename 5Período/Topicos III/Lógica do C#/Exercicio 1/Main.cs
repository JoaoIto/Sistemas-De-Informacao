using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            // Cria as instâncias das entidades
            Prefeitura prefeitura = new Prefeitura();
            Comercio comercio = new Comercio();
            Industria industria = new Industria();

            // Configura o ciclo de operação
            int ciclosAnuais = 12; // Número de ciclos mensais em um ano
            double valorMinimoCaixaIndustria = 10000; // Valor mínimo para a Indústria continuar operando
            double valorMinimoCaixaComercio = 10000; // Valor mínimo para o Comércio continuar operando

            // Inicializa variáveis para rastrear o tempo decorrido
            int anos = 0;
            int meses = 0;

            // Simula cada mês do ano
            while (true)
            {
                meses++;
                if (meses > ciclosAnuais)
                {
                    meses = 1;
                    anos++;
                }

                Console.WriteLine($"Mês {meses} do Ano {anos + 1}");
                Console.WriteLine("teste para ser escrito em vídeo")
;
                // Verifica se a Indústria tem caixa suficiente
                if (industria.ObterCaixa() <= valorMinimoCaixaIndustria)
                {
                    Console.WriteLine("Indústria não tem dinheiro suficiente para operar. Ciclo interrompido.");
                    Console.WriteLine($"Tempo decorrido: {anos} anos e {meses - 1} meses.");
                    break;
                }

                // Verifica se o Comércio pode repor estoque
                if (comercio.ObterCaixa() <= valorMinimoCaixaComercio)
                {
                    Console.WriteLine("Comércio não tem dinheiro suficiente para repor o estoque. Ciclo interrompido.");
                    Console.WriteLine($"Tempo decorrido: {anos} anos e {meses - 1} meses.");
                    break;
                }

                // Realiza os pagamentos de salários
                prefeitura.PagarSalarios();
                comercio.PagarSalarios();
                industria.PagarSalarios();

                // Comércio compra itens da Indústria
                comercio.ReporEstoque(industria);

                // Comércio vende produtos
                comercio.VenderProduto(100, prefeitura); // Exemplo: vende 100 produtos

                // Comércio paga imposto sobre salários
                comercio.PagarImpostoSalario(prefeitura);

                Console.WriteLine("-------------------------------");
            }
        }
    }
}

