package src.alocadores_processos;

import src.Particao;
import src.Processo;

import java.util.List;

public class AlocadorMemoria {

    public void firstFit(List<Particao> particoes, List<Processo> processos) {
        for (Processo processo : processos) {
            for (Particao particao : particoes) {
                if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                    particao.processoID = processo.id;
                    particao.fragmentacao = particao.tamanho - processo.tamanho;
                    break;
                }
            }
        }
    }

    public void bestFit(List<Particao> particoes, List<Processo> processos) {
        for (Processo processo : processos) {
            Particao melhorParticao = null;
            for (Particao particao : particoes) {
                if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                    if (melhorParticao == null || particao.tamanho < melhorParticao.tamanho) {
                        melhorParticao = particao;
                    }
                }
            }
            if (melhorParticao != null) {
                melhorParticao.processoID = processo.id;
                melhorParticao.fragmentacao = melhorParticao.tamanho - processo.tamanho;
            }
        }
    }

    public void worstFit(List<Particao> particoes, List<Processo> processos) {
        for (Processo processo : processos) {
            Particao piorParticao = null;
            for (Particao particao : particoes) {
                if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                    if (piorParticao == null || particao.tamanho > piorParticao.tamanho) {
                        piorParticao = particao;
                    }
                }
            }
            if (piorParticao != null) {
                piorParticao.processoID = processo.id;
                piorParticao.fragmentacao = piorParticao.tamanho - processo.tamanho;
            }
        }
    }
}

