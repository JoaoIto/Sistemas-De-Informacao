// Definir os modelos de otimização para as questões 1, 2 e 3
import {gerarExcel} from "../index.js";

const modeloQuestao1 = {
    optimize: "L",
    opType: "max",
    constraints: {
        X1: { max: 7 },
        X2: { max: 8 },
        _3: { max: 3 },
        _4: { max: 2 },
    },
    variables: {
        X1: { L: 4, X1: 1, X2: 0, _3: 1, _4: 1 },
        X2: { L: 3, X1: 0, X2: 1, _3: 1, _4: 0 },
    },
    ints: { X1: 1, X2: 1 },
};

const modeloQuestao2 = {
    optimize: "L",
    opType: "max",
    constraints: {
        X1: { max: 2 },
        X2: { max: 2 },
        _3: { max: 3 },
        _4: { max: 7 },
        _5: { max: 8 },
    },
    variables: {
        X1: { L: 4, X1: 1, X2: 0, _3: 1, _4: 1, _5: 2 },
        X2: { L: 3, X1: 0, X2: 1, _3: 1, _4: 3, _5: 2 },
    },
    ints: { X1: 1, X2: 1 },
};

const modeloQuestao3 = {
    optimize: "lucro",
    opType: "max",
    constraints: {
        X1: { max: 160 },
        X2: { max: 120 },
        X3: { max: 60 },
    },
    variables: {
        morango: { lucro: 1, morango: 133.3333333, uva: 0.4, X2: 0.5, X3: 0.1 },
        uva: { lucro: 0.9, morango: 177.7777778, uva: 0.6, X2: 0.3, X3: 0.15 },
    },
    ints: { morango: 1, uva: 1 },
};

// Passar os modelos para a função que gera o arquivo
gerarExcel([modeloQuestao1, modeloQuestao2, modeloQuestao3]);
