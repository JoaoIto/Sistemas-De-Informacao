import numpy as np

# Função de ativação sigmoid
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

# Derivada da função sigmoid
def sigmoid_derivative(x):
    return x * (1 - x)

# Classe da Rede Neural Multicamadas
class NeuralNetwork:
    def __init__(self, input_size, hidden_sizes, output_size, learning_rate=0.1, epochs=10000):
        # Inicializa os parâmetros
        self.learning_rate = learning_rate
        self.epochs = epochs
        
        # Lista de pesos para cada camada
        layer_sizes = [input_size] + hidden_sizes + [output_size]
        self.weights = []
        for i in range(len(layer_sizes) - 1):
            # Pesos inicializados aleatoriamente
            weight_matrix = np.random.uniform(-1, 1, (layer_sizes[i], layer_sizes[i+1]))
            self.weights.append(weight_matrix)
    
    def feedforward(self, x):
        activations = [x]
        input = x
        # Propagação para frente
        for weight in self.weights:
            net_input = np.dot(input, weight)
            activation = sigmoid(net_input)
            activations.append(activation)
            input = activation
        return activations
    
    def backpropagation(self, activations, y_true):
        # Calcula o erro na saída
        error = y_true - activations[-1]
        deltas = [error * sigmoid_derivative(activations[-1])]
        
        # Propaga o erro para trás
        for i in reversed(range(len(self.weights)-1)):
            delta = deltas[-1].dot(self.weights[i+1].T) * sigmoid_derivative(activations[i+1])
            deltas.append(delta)
        
        deltas.reverse()
        # Atualiza os pesos
        for i in range(len(self.weights)):
            layer_input = np.atleast_2d(activations[i])
            delta = np.atleast_2d(deltas[i])
            self.weights[i] += self.learning_rate * layer_input.T.dot(delta)
    
    def train(self, X, y):
        for epoch in range(self.epochs):
            for xi, yi in zip(X, y):
                activations = self.feedforward(xi)
                self.backpropagation(activations, yi)
            # Opcional: Impressão do erro a cada 1000 épocas
            if epoch % 1000 == 0:
                loss = np.mean(np.square(y - self.predict(X)))
                print(f"Época {epoch}, Erro: {loss}")
    
    def predict(self, X):
        y_pred = []
        for xi in X:
            activations = self.feedforward(xi)
            y_pred.append(activations[-1])
        return np.array(y_pred)

# Exemplo de uso
if __name__ == "__main__":
    # Dados de entrada (função XOR)
    X = np.array([
        [0, 0],
        [0, 1],
        [1, 0],
        [1, 1],
    ])
    
    # Saídas desejadas
    y = np.array([
        [0],
        [1],
        [1],
        [0],
    ])
    
    # Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[2], output_size=1, learning_rate=0.1, epochs=100000)
    
    # Treina a rede neural
    nn.train(X, y)
    
    # Testa a rede neural
    outputs = nn.predict(X)
    print("\nResultados:")
    for xi, yi_pred in zip(X, outputs):
        print(f"Entrada: {xi}, Saída Prevista: {yi_pred.round()}")  # Arredonda a saída
