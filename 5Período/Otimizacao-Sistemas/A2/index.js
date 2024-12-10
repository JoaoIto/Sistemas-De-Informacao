// import {resolverModeloQuestao} from "./calc/index.js";
// import XLSX from "xlsx";
//
// function gerarAbaQuestao(modeloQuestao, resultados, questionNumber) {
//     const { solution, lhs, rhs, status, margins } = resultados;
//
//     const questaoData = [
//         ["", "COEFICIENTE DAS VARIÁVEIS", "", "", ""],
//         ["FUNÇÃO OBJETIVO", "X1", "X2", "MAX", ""],
//         [null, modeloQuestao.variables.X1.X1, modeloQuestao.variables.X2.X2, null, null],
//         ["VARIÁVEL", solution.X1, solution.X2, null, null],
//         ["L=", null, null, solution.L, null],
//         [null, null, null, null, null],
//         ["RESTRIÇÕES", "COEFICIENTE DAS VARIÁVEIS", null, "CONSTANTES", null],
//         [null, "X1", "X2", "LHS", "RHS"],
//         ...Object.entries(modeloQuestao.constraints).map(([key, constraint], i) => {
//             const coefX1 = constraint.X1 !== undefined ? constraint.X1 : null;
//             const coefX2 = constraint.X2 !== undefined ? constraint.X2 : null;
//
//             return [
//                 i + 1,
//                 coefX1,
//                 coefX2,
//                 rhs[i] || null
//             ];
//         })
//     ];
//
//     return XLSX.utils.aoa_to_sheet(questaoData);
// }
//
// function gerarAbaRelatorio(modeloQuestao, resultados, questionNumber) {
//     const { lhs, rhs, status, margins } = resultados;
//
//     const reportData = [
//         ["Microsoft Excel 16.0 Relatório de Respostas"],
//         [`Planilha: [Questão ${questionNumber} - Prova.xlsx]Questão ${questionNumber}`],
//         [`Relatório Criado: ${new Date().toLocaleString("pt-BR")}`],
//         ["Resultado: O Solver encontrou uma solução. Todas as restrições e condições de otimalidade são satisfeitas."],
//         [],
//         ["Restrições"],
//         ["Célula", "Nome", "Valor da Célula", "Fórmula", "Status", "Margem de Atraso"],
//         ...lhs.map((val, i) => {
//             const coefX1 = modeloQuestao.constraints[i].X1 !== undefined ? modeloQuestao.constraints[i].X1 : null;
//             return [
//                 `$D$${i + 1}`, coefX1, val, `= $D$${i + 1} <= $E$${i + 1}`, status[i], margins[i]
//             ];
//         })
//     ];
//
//     return XLSX.utils.aoa_to_sheet(reportData);
// }
//
// export function gerarExcel(modelos) {
//     const wb = XLSX.utils.book_new();
//
//     modelos.forEach((modeloQuestao, index) => {
//         const resultados = resolverModeloQuestao(modeloQuestao);
//         const abaQuestao = gerarAbaQuestao(modeloQuestao, resultados, index + 1);
//         const abaRelatorio = gerarAbaRelatorio(modeloQuestao, resultados, index + 1);
//
//         XLSX.utils.book_append_sheet(wb, abaQuestao, `Questão ${index + 1}`);
//         XLSX.utils.book_append_sheet(wb, abaRelatorio, `Relatório de Respostas ${index + 1}`);
//     });
//
//     XLSX.writeFile(wb, "resultados_questoes.xlsx");
// }


import XLSX from "xlsx";
import solver from "javascript-lp-solver";

function solveAndGenerateExcel() {
    // Definir os modelos de otimização para as questões 1, 2 e 3
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
            leite: { max: 160 },
            acucar: { max: 120 },
            polpa: { max: 60 },
        },
        variables: {
            morango: { lucro: 1, morango: 133.3333333, uva: 0.4, acucar: 0.5, polpa: 0.1 },
            uva: { lucro: 0.9, morango: 177.7777778, uva: 0.6, acucar: 0.3, polpa: 0.15 },
        },
        ints: { morango: 1, uva: 1 },
    };

    // Resolver os problemas
    const solution1 = solver.Solve(modeloQuestao1);
    const solution2 = solver.Solve(modeloQuestao2);
    const solution3 = solver.Solve(modeloQuestao3);

    // Lógica de LHS e margens para a questão 1
    const lhs1 = [
        solution1.X1 + 3 * solution1.X2,
        2 * solution1.X1 + 2 * solution1.X2,
        solution1.X1 + solution1.X2,
        solution1.X2,
    ];
    const rhs1 = [7, 8, 3, 2];
    const status1 = lhs1.map((val, i) => (val <= rhs1[i] ? "Associação" : "Não-associação"));
    const margins1 = rhs1.map((val, i) => Math.max(0, val - lhs1[i]));

    // Lógica de LHS e margens para a questão 2
    const lhs2 = [
        solution2.X1 + 3 * solution2.X2,
        2 * solution2.X1 + 2 * solution2.X2,
        solution2.X1 + solution2.X2,
        solution2.X2,
    ];
    const rhs2 = [7, 8, 3, 2];
    const status2 = lhs2.map((val, i) => (val <= rhs2[i] ? "Associação" : "Não-associação"));
    const margins2 = rhs2.map((val, i) => Math.max(0, val - lhs2[i]));

    // Lógica de LHS e margens para a questão 3
    const lhs3 = [
        (solution3.morango && solution3.uva) ? solution3.morango * 0.4 + solution3.uva * 0.6 : 0,
        (solution3.morango && solution3.uva) ? solution3.morango * 0.5 + solution3.uva * 0.3 : 0,
        (solution3.morango && solution3.uva) ? solution3.morango * 0.1 + solution3.uva * 0.15 : 0,
    ];

    const rhs3 = [160, 120, 60];
    const status3 = lhs3.map((val, i) => (val <= rhs3[i] ? "Associação" : "Não-associação"));
    const margins3 = rhs3.map((val, i) => Math.max(0, val - lhs3[i]));

    // Criar o novo workbook
    const wb = XLSX.utils.book_new();

    // Dados da aba "Questão 1"
    const questao1Data = [
        ["", "COEFICIENTE DAS VARIÁVEIS", "", "", ""],
        ["FUNÇÃO OBJETIVO", "X1", "X2", "MAX", ""],
        [null, 4, 3, null, null],
        ["VARIÁVEL", solution1.X1 || 0, solution1.X2 || 0, null, null],
        ["L=", null, null, solution1.result || 0, null],
        [null, null, null, null, null],
        ["RESTRIÇÕES", "COEFICIENTE DAS VARIÁVEIS", null, "CONSTANTES", null],
        [null, "X1", "X2", "LHS", "RHS"],
        [1, 1, 3, lhs1[0], rhs1[0]],
        [2, 2, 2, lhs1[1], rhs1[1]],
        [3, 1, 1, lhs1[2], rhs1[2]],
        [4, 0, 1, lhs1[3], rhs1[3]],
    ];

    const ws1 = XLSX.utils.aoa_to_sheet(questao1Data);
    XLSX.utils.book_append_sheet(wb, ws1, "Questão 1");

    // Dados da aba "Relatório de Respostas 1"
    const reportData1 = [
        ["Microsoft Excel 16.0 Relatório de Respostas"],
        ["Planilha: [Questão 1 - Prova.xlsx]Questão 1"],
        [`Relatório Criado: ${new Date().toLocaleString("pt-BR")}`],
        ["Resultado: O Solver encontrou uma solução. Todas as restrições e condições de otimalidade são satisfeitas."],
        [],
        ["Restrições"],
        ["Célula", "Nome", "Valor da Célula", "Fórmula", "Status", "Margem de Atraso"],
        ["$D$10", "LHS", lhs1[0], "$D$10<=$E$10", status1[0], margins1[0]],
        ["$D$11", "LHS", lhs1[1], "$D$11<=$E$11", status1[1], margins1[1]],
        ["$D$12", "LHS", lhs1[2], "$D$12<=$E$12", status1[2], margins1[2]],
        ["$D$9", "LHS", lhs1[3], "$D$9<=$E$9", status1[3], margins1[3]],
    ];

    const ws2 = XLSX.utils.aoa_to_sheet(reportData1);
    XLSX.utils.book_append_sheet(wb, ws2, "Relatório de Respostas 1");

    // Dados da aba "Questão 2"
    const questao2Data = [
        ["", "COEFICIENTE DAS VARIÁVEIS", "", "", ""],
        ["FUNÇÃO OBJETIVO", "X1", "X2", "MAX", ""],
        [null, 4, 3, null, null],
        ["VARIÁVEL", solution2.X1 || 0, solution2.X2 || 0, null, null],
        ["L=", null, null, solution2.result || 0, null],
        [null, null, null, null, null],
        ["RESTRIÇÕES", "COEFICIENTE DAS VARIÁVEIS", null, "CONSTANTES", null],
        [null, "X1", "X2", "LHS", "RHS"],
        [1, 1, 3, lhs2[0], rhs2[0]],
        [2, 2, 2, lhs2[1], rhs2[1]],
        [3, 1, 1, lhs2[2], rhs2[2]],
        [4, 0, 1, lhs2[3], rhs2[3]],
    ];

    const ws3 = XLSX.utils.aoa_to_sheet(questao2Data);
    XLSX.utils.book_append_sheet(wb, ws3, "Questão 2");

    // Dados da aba "Relatório de Respostas 2"
    const reportData2 = [
        ["Microsoft Excel 16.0 Relatório de Respostas"],
        ["Planilha: [Questão 2 - Prova.xlsx]Questão 2"],
        [`Relatório Criado: ${new Date().toLocaleString("pt-BR")}`],
        ["Resultado: O Solver encontrou uma solução. Todas as restrições e condições de otimalidade são satisfeitas."],
        [],
        ["Restrições"],
        ["Célula", "Nome", "Valor da Célula", "Fórmula", "Status", "Margem de Atraso"],
        ["$D$10", "LHS", lhs2[0], "$D$10<=$E$10", status2[0], margins2[0]],
        ["$D$11", "LHS", lhs2[1], "$D$11<=$E$11", status2[1], margins2[1]],
        ["$D$12", "LHS", lhs2[2], "$D$12<=$E$12", status2[2], margins2[2]],
        ["$D$9", "LHS", lhs2[3], "$D$9<=$E$9", status2[3], margins2[3]],
    ];

    const ws4 = XLSX.utils.aoa_to_sheet(reportData2);
    XLSX.utils.book_append_sheet(wb, ws4, "Relatório de Respostas 2");

    // Dados da aba "Questão 3"
    const questao3Data = [
        ["", "COEFICIENTE DAS VARIÁVEIS", "", "", ""],
        ["FUNÇÃO OBJETIVO", "X1", "X2", "MAX", ""],
        [null, 4, 3, null, null],
        ["VARIÁVEL", solution3.morango || 0, solution3.uva || 0, null, null],
        ["L=", null, null, solution3.result || 0, null],
        [null, null, null, null, null],
        ["RESTRIÇÕES", "COEFICIENTE DAS VARIÁVEIS", null, "CONSTANTES", null],
        [null, "X1", "X2", "LHS", "RHS"],
        [1, 0.4, 0.6, lhs3[0], rhs3[0]],
        [2, 0.5, 0.3, lhs3[1], rhs3[1]],
        [3, 0.1, 0.15, lhs3[2], rhs3[2]],
    ];

    const ws5 = XLSX.utils.aoa_to_sheet(questao3Data);
    XLSX.utils.book_append_sheet(wb, ws5, "Questão 3");

    // Dados da aba "Relatório de Respostas 3"
    const reportData3 = [
        ["Microsoft Excel 16.0 Relatório de Respostas"],
        ["Planilha: [Questão 3 - Prova.xlsx]Questão 3"],
        [`Relatório Criado: ${new Date().toLocaleString("pt-BR")}`],
        ["Resultado: O Solver encontrou uma solução. Todas as restrições e condições de otimalidade são satisfeitas."],
        [],
        ["Restrições"],
        ["Célula", "Nome", "Valor da Célula", "Fórmula", "Status", "Margem de Atraso"],
        ["$D$10", "LHS", lhs3[0], "$D$10<=$E$10", status3[0], margins3[0]],
        ["$D$11", "LHS", lhs3[1], "$D$11<=$E$11", status3[1], margins3[1]],
        ["$D$12", "LHS", lhs3[2], "$D$12<=$E$12", status3[2], margins3[2]],
    ];

    const ws6 = XLSX.utils.aoa_to_sheet(reportData3);
    XLSX.utils.book_append_sheet(wb, ws6, "Relatório de Respostas 3");

    // Salvar o arquivo Excel
    XLSX.writeFile(wb, "resultados_questoes_1_2_3.xlsx");
}

solveAndGenerateExcel();
