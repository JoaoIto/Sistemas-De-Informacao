import solver from 'javascript-lp-solver';

function calcularLHSandMargins(solution, modeloQuestao) {
    const lhs = Object.keys(modeloQuestao.constraints).map((constraintKey) => {
        const coefX1 = modeloQuestao.variables.X1[constraintKey] || 0;
        const coefX2 = modeloQuestao.variables.X2[constraintKey] || 0;
        return coefX1 * solution.X1 + coefX2 * solution.X2;
    });

    const rhs = Object.values(modeloQuestao.constraints).map(constraint => constraint.max);
    const status = lhs.map((val, i) => (val <= rhs[i] ? "Associação" : "Não-associação"));
    const margins = rhs.map((val, i) => Math.max(0, val - lhs[i]));

    return { lhs, rhs, status, margins };
}

export function resolverModeloQuestao(modeloQuestao) {
    // Resolver o modelo usando um solver (assumindo que você tenha um método `solver.Solve`).
    const solution = solver.Solve(modeloQuestao);

    // Calcular LHS e margens
    const { lhs, rhs, status, margins } = calcularLHSandMargins(solution, modeloQuestao);

    return { solution, lhs, rhs, status, margins };
}
