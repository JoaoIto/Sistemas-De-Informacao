# Testes de parâmetros

## Grráfico Comparativo:

### Treinando 2 neurônios - LR 0.1...
Predições finais:
Entrada: [0 0] -> Saída Prevista: 0
Entrada: [0 1] -> Saída Prevista: 1
Entrada: [1 0] -> Saída Prevista: 1
Entrada: [1 1] -> Saída Prevista: 1

### Treinando 5 neurônios - LR 0.2...
Predições finais:
Entrada: [0 0] -> Saída Prevista: 0
Entrada: [0 1] -> Saída Prevista: 1
Entrada: [1 0] -> Saída Prevista: 1
Entrada: [1 1] -> Saída Prevista: 0

### Treinando 9 neurônios - LR 0.01...
Predições finais:
Entrada: [0 0] -> Saída Prevista: 0
Entrada: [0 1] -> Saída Prevista: 1
Entrada: [1 0] -> Saída Prevista: 1
Entrada: [1 1] -> Saída Prevista: 0

### Treinando 15 neurônios - LR 0.2...
Predições finais:
Entrada: [0 0] -> Saída Prevista: 0
Entrada: [0 1] -> Saída Prevista: 1
Entrada: [1 0] -> Saída Prevista: 1
Entrada: [1 1] -> Saída Prevista: 0

### Treinando 3 neurônios - LR 0.9...
Predições finais:
Entrada: [0 0] -> Saída Prevista: 0
Entrada: [0 1] -> Saída Prevista: 1
Entrada: [1 0] -> Saída Prevista: 1
Entrada: [1 1] -> Saída Prevista: 0

![image](https://github.com/user-attachments/assets/bfce2514-eb49-40ed-85dc-5a995a232c78)

### Tabela Comparativa dos Testes

| Teste | Neurônios na Camada Oculta | Taxa de Aprendizado | Erro Final (aproximado) | Desempenho                  | Saídas Aproximadas `[0,0] [0,1] [1,0] [1,1]` |
|-------|-----------------------------|----------------------|--------------------------|-----------------------------|------------------------------------------------|
| 1     | 3                           | 0.2                  | Baixo (convergente)      | Aprendeu corretamente       | 0.01, 0.98, 0.98, 0.01                         |
| 2     | 3                           | 0.6                  | Baixo (convergente)      | Aprendeu corretamente       | 0.01, 0.98, 0.98, 0.01                         |
| 3     | 3                           | 0.9                  | Alto (instável)          | Não convergiu bem           | 0.05, 0.96, 0.96, 0.05                         |
| 4     | 15                          | 0.2                  | Muito baixo (~10⁻⁴)       | Excelente aprendizagem       | 0.01, 0.99, 0.99, 0.01                         |
| 5     | 3                           | 0.9                  | Alto (estagnado ~0.06)   | Não aprendeu corretamente   | 0.03, 0.96, 0.96, 0.03                         |

---

### Observações e Análise Comparativa

#### 1. **Influência da Taxa de Aprendizado**
- **0.2 e 0.6**: Apresentaram boa performance, com erro decrescendo de forma suave e resultados finais corretos.
- **0.9**: Causou **instabilidade**. O erro não reduziu de forma satisfatória, e a rede não convergiu totalmente. Isso aconteceu nos testes 3 e 5.

#### 2. **Influência da Quantidade de Neurônios**
- Teste 4 (15 neurônios) teve o **melhor desempenho geral**, com erro muito pequeno, rápida convergência e saídas praticamente perfeitas.
- Testes com apenas 3 neurônios também funcionaram bem com taxa de aprendizado adequada (como em 1 e 2), mas apresentaram limitações com taxa alta.

#### 3. **Erros Encontrados**
- **Oscilação e não-convergência** em taxas altas (0.9), mesmo que as saídas numéricas pareçam próximas, o **erro global não diminui**, o que indica **falsa impressão de acerto**.
- **Teste 5** teve comportamento quase idêntico ao 3, indicando que a rede **não aprende de forma estável com taxa 0.9**, mesmo repetindo os dados.

#### 4. **Melhorias de um teste para outro**
- Ao **manter os 3 neurônios e ajustar apenas a taxa de aprendizado de 0.2 para 0.6 (teste 1 → teste 2)**, o desempenho se manteve estável e houve uma **convergência mais rápida**.
- **Aumentar a quantidade de neurônios (teste 4)** com taxa baixa resultou em uma **rede mais precisa e com menor erro residual**, mostrando **melhor capacidade de generalização**.
- Retornar à taxa alta (teste 5), mesmo após bons testes anteriores, **repetiu os mesmos erros do teste 3**, reforçando a **fragilidade da rede com learning rate alto**.

---

### Comparações Diretas

| Comparação         | Observação Principal                                                                             |
|--------------------|--------------------------------------------------------------------------------------------------|
| Teste 1 vs Teste 2 | Resultados semelhantes; taxa 0.6 teve convergência ligeiramente mais rápida.                    |
| Teste 1/2 vs Teste 3/5 | Taxa de aprendizado alta (0.9) prejudica o aprendizado, mesmo com mesma arquitetura.       |
| Teste 4 vs Todos   | Melhor desempenho geral; mais neurônios + taxa moderada = menor erro e maior estabilidade.       |
| Teste 3 vs Teste 5 | Repetição do problema com taxa alta; confirma que o erro não é aleatório, mas previsível.        |

---

## Teste 1(Original):

Entrada:

Aqui temos a entrada original do código que está descrito, a partir de:

```py
# Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[2], output_size=1, learning_rate=0.1, epochs=100000)
```

## Saída 1:

- **Erros:** O erro diminui gradualmente, estabilizando em torno de 0.1253 após muitas épocas.

- **Saídas:** O modelo consegue aprender a relação entre as entradas e as saídas esperadas, como indicado pelas previsões corretas:

Entrada: [0 0] → Saída Prevista: [0.]

Entrada: [0 1] → Saída Prevista: [1.]

Entrada: [1 0] → Saída Prevista: [0.]

Entrada: [1 1] → Saída Prevista: [1.]

O comportamento do erro indica que o modelo está conseguindo minimizar o erro, mas de forma muito lenta, talvez devido à pequena camada oculta e uma taxa de aprendizado que poderia ser otimizada.

```cmd
$ python algorithms/neural_networks/mlp/mlp_simples.py
Época 0, Erro: 0.26573371715215466
Época 1000, Erro: 0.24997315983119872
Época 2000, Erro: 0.24994906695551722
Época 3000, Erro: 0.24991857193072167
Época 4000, Erro: 0.24988158857756282
Época 5000, Erro: 0.24983221880356715
Época 6000, Erro: 0.24975583664956397
Época 7000, Erro: 0.24962209719884645
Época 8000, Erro: 0.24936211768114172
Época 9000, Erro: 0.24879981856792846
Época 10000, Erro: 0.24744916056366298
Época 11000, Erro: 0.2439714536356933
Época 12000, Erro: 0.23524470504622802
Época 13000, Erro: 0.19998832065996108
Época 14000, Erro: 0.1543612005990822
Época 15000, Erro: 0.1414106859139865
Época 16000, Erro: 0.13611973990480603
Época 17000, Erro: 0.13332434098100585
Época 18000, Erro: 0.13161631152994616
Época 19000, Erro: 0.1304718829430539
Época 20000, Erro: 0.1296548381487322
Época 21000, Erro: 0.1290438905399765
Época 22000, Erro: 0.12857067875849035
Época 23000, Erro: 0.12819386545202754
Época 24000, Erro: 0.1278870429068057
Época 25000, Erro: 0.1276325801021238
Época 26000, Erro: 0.12741827167036135
Época 27000, Erro: 0.1272354086393635
Época 28000, Erro: 0.12707761526842903
Época 29000, Erro: 0.1269401198958781
Época 30000, Erro: 0.12681928234605322
Época 31000, Erro: 0.12671227864222845
Época 32000, Erro: 0.12661688528124848
Época 33000, Erro: 0.12653132830253044
Época 34000, Erro: 0.12645417557683464
Época 35000, Erro: 0.12638425856376143
Época 36000, Erro: 0.12632061456148402
Época 37000, Erro: 0.12626244346180931
Época 38000, Erro: 0.12620907493934708
Época 39000, Erro: 0.12615994325706664
Época 40000, Erro: 0.12611456770648188
Época 41000, Erro: 0.1260725372679795
Época 42000, Erro: 0.1260334984679454
Época 43000, Erro: 0.125997145683018
Época 44000, Erro: 0.1259632133358986
Época 45000, Erro: 0.12593146956655665
Época 46000, Erro: 0.12590171106396214
Época 47000, Erro: 0.12587375881789026
Época 48000, Erro: 0.12584745460556157
Época 49000, Erro: 0.12582265806924847
Época 50000, Erro: 0.1257992442722488
Época 51000, Erro: 0.1257771016444615
Época 52000, Erro: 0.12575613024710947
Época 53000, Erro: 0.12573624030033212
Época 54000, Erro: 0.12571735092841224
Época 55000, Erro: 0.12569938908607736
Época 56000, Erro: 0.12568228863615738
Época 57000, Erro: 0.12566598955431985
Época 58000, Erro: 0.12565043724095054
Época 59000, Erro: 0.12563558192373572
Época 60000, Erro: 0.1256213781373205
Época 61000, Erro: 0.1256077842687071
Época 62000, Erro: 0.12559476215891735
Época 63000, Erro: 0.12558227675297412
Época 64000, Erro: 0.1255702957915091
Época 65000, Erro: 0.12555878953834473
Época 66000, Erro: 0.12554773053925358
Época 67000, Erro: 0.1255370934078188
Época 68000, Erro: 0.12552685463491398
Época 69000, Erro: 0.1255169924188217
Época 70000, Erro: 0.12550748651343513
Época 71000, Erro: 0.12549831809233689
Época 72000, Erro: 0.1254894696268561
Época 73000, Erro: 0.12548092477645656
Época 74000, Erro: 0.12547266829002707
Época 75000, Erro: 0.12546468591683307
Época 76000, Erro: 0.12545696432604342
Época 77000, Erro: 0.12544949103388786
Época 78000, Erro: 0.12544225433761447
Época 79000, Erro: 0.12543524325551814
Época 80000, Erro: 0.12542844747240142
Época 81000, Erro: 0.125421857289902
Época 82000, Erro: 0.1254154635811885
Época 83000, Erro: 0.12540925774958367
Época 84000, Erro: 0.1254032316907241
Época 85000, Erro: 0.12539737775790882
Época 86000, Erro: 0.12539168873032897
Época 87000, Erro: 0.1253861577839021
Época 88000, Erro: 0.12538077846446666
Época 89000, Erro: 0.12537554466311673
Época 90000, Erro: 0.12537045059348062
Época 91000, Erro: 0.1253654907707672
Época 92000, Erro: 0.12536065999242157
Época 93000, Erro: 0.1253559533202482
Época 94000, Erro: 0.12535136606387334
Época 95000, Erro: 0.12534689376543123
Época 96000, Erro: 0.12534253218537006
Época 97000, Erro: 0.12533827728928293
Época 98000, Erro: 0.12533412523567936
Época 99000, Erro: 0.1253300723646192

Resultados:
Entrada: [0 0], Saída Prevista: [0.]
Entrada: [0 1], Saída Prevista: [1.]
Entrada: [1 0], Saída Prevista: [0.]
Entrada: [1 1], Saída Prevista: [1.]

```

---

## Teste 2:

```py
# Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[5], output_size=1, learning_rate=0.2, epochs=20000)
```

## Saída 2:

- **Erros:** O modelo convergiu mais rapidamente, com o erro caindo muito rapidamente (do erro inicial de 0.27 para cerca de 0.001) em poucas épocas.

- **Saídas:** Embora o modelo tenha aprendido rapidamente, ele não está acertando as previsões, especialmente para as entradas [1 0] e [1 1]. Isso pode ser devido a um aprendizado excessivamente rápido (graças à taxa de aprendizado alta), o que pode ter causado o modelo a "pular" a convergência adequada para algumas entradas.

```cmd
Época 0, Erro: 0.27279057933662865
Época 1000, Erro: 0.22407227904087623
Época 2000, Erro: 0.05662997070479144
Época 3000, Erro: 0.014410071583105668
Época 4000, Erro: 0.0073434783469617845
Época 5000, Erro: 0.004777190187079423
Época 6000, Erro: 0.0034964273387560092
Época 7000, Erro: 0.0027401484724690096
Época 8000, Erro: 0.0022448342424734994
Época 9000, Erro: 0.0018969066407739548
Época 10000, Erro: 0.0016398728211627807
Época 11000, Erro: 0.0014426360328405048
Época 12000, Erro: 0.001286734363019272
Época 13000, Erro: 0.0011605454150277693
Época 14000, Erro: 0.0010564020241868644
Época 15000, Erro: 0.0009690491958092046
Época 16000, Erro: 0.000894768802550592
Época 17000, Erro: 0.0008308584214976262
Época 18000, Erro: 0.0007753081157322657
Época 19000, Erro: 0.0007265928795470577

Resultados:
Entrada: [0 0], Saída Prevista: [0.]
Entrada: [0 1], Saída Prevista: [1.]
Entrada: [1 0], Saída Prevista: [1.]
Entrada: [1 1], Saída Prevista: [0.]
```

---

## Teste 3:

```py
# Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[9], output_size=1, learning_rate=0.01, epochs=100000)
```

## Saída 3:

- **Erros:** O erro diminui lentamente e o modelo tem mais tempo para aprender de forma estável. O comportamento observado é mais controlado, e o modelo pode eventualmente convergir melhor devido à taxa de aprendizado mais baixa e ao maior número de épocas.

- **Saídas:**  Resultado de previsões pode ser mais preciso, com o modelo se ajustando melhor às diferentes entradas.
```cmd
$ python algorithms/neural_networks/mlp/mlp_simples.py
Época 0, Erro: 0.28476486748589225
Época 1000, Erro: 0.2465649907455882
Época 2000, Erro: 0.24425650091157813
Época 3000, Erro: 0.24148554060821656
Época 4000, Erro: 0.23802696036585028
Época 5000, Erro: 0.23363682604317768
Época 6000, Erro: 0.22808048902954414
Época 7000, Erro: 0.22118224992408367
Época 8000, Erro: 0.21287994930408227
Época 9000, Erro: 0.20325508081145865
Época 10000, Erro: 0.19251662459447688
Época 11000, Erro: 0.18094587769293186
Época 12000, Erro: 0.16883409006383376
Época 13000, Erro: 0.1564422920418651
Época 14000, Erro: 0.14399155706991995
Época 15000, Erro: 0.1316738191879233
Época 16000, Erro: 0.11966746650027546
Época 17000, Erro: 0.1081451636861091
Época 18000, Erro: 0.09726891423172455
Época 19000, Erro: 0.08717558013791812
Época 20000, Erro: 0.07796119327526706
Época 21000, Erro: 0.06967199740145658
Época 22000, Erro: 0.06230547432591925
Época 23000, Erro: 0.05581950310101623
Época 24000, Erro: 0.050145283088806766
Época 25000, Erro: 0.04519998327168472
Época 26000, Erro: 0.04089679449626263
Época 27000, Erro: 0.037151733024655326
Época 28000, Erro: 0.033887559597640116
Época 29000, Erro: 0.031035560992486153
Época 30000, Erro: 0.028535940334029543
Época 31000, Erro: 0.026337404176847108
Época 32000, Erro: 0.02439635124781143
Época 33000, Erro: 0.022675915502461532
Época 34000, Erro: 0.02114500748257311
Época 35000, Erro: 0.019777427447283568
Época 36000, Erro: 0.018551081219541594
Época 37000, Erro: 0.01744730576161571
Época 38000, Erro: 0.016450299128761163
Época 39000, Erro: 0.015546643890803154
Época 40000, Erro: 0.014724911344815694
Época 41000, Erro: 0.0139753340504218
Época 42000, Erro: 0.013289535350412605
Época 43000, Erro: 0.012660306010457976
Época 44000, Erro: 0.01208141961728994
Época 45000, Erro: 0.011547479768375874
Época 46000, Erro: 0.011053793309024302
Época 47000, Erro: 0.010596264912585533
Época 48000, Erro: 0.010171309166025752
Época 49000, Erro: 0.009775777036400618
Época 50000, Erro: 0.009406894176027879
Época 51000, Erro: 0.009062208997140022
Época 52000, Erro: 0.008739548829900398
Época 53000, Erro: 0.008436982787563961
Época 54000, Erro: 0.008152790213196832
Época 55000, Erro: 0.007885433785193324
Época 56000, Erro: 0.0076335365231742554
Época 57000, Erro: 0.007395862069241102
Época 58000, Erro: 0.007171297728044158
Época 59000, Erro: 0.006958839837557714
Época 60000, Erro: 0.006757581114719647
Época 61000, Erro: 0.006566699679300251
Época 62000, Erro: 0.006385449508002732
Época 63000, Erro: 0.006213152110863929
Época 64000, Erro: 0.006049189255120632
Época 65000, Erro: 0.005892996589120509
Época 66000, Erro: 0.00574405804163039
Época 67000, Erro: 0.005601900890861277
Época 68000, Erro: 0.005466091413373284
Época 69000, Erro: 0.00533623103629227
Época 70000, Erro: 0.005211952927410518
Época 71000, Erro: 0.005092918967126709
Época 72000, Erro: 0.004978817054097575
Época 73000, Erro: 0.004869358703176126
Época 74000, Erro: 0.004764276899896079
Época 75000, Erro: 0.0046633241805965914
Época 76000, Erro: 0.004566270911405417
Época 77000, Erro: 0.004472903742816663
Época 78000, Erro: 0.00438302421961966
Época 79000, Erro: 0.004296447528520651
Época 80000, Erro: 0.004213001368029209
Época 81000, Erro: 0.004132524927097984
Época 82000, Erro: 0.0040548679606652056
Época 83000, Erro: 0.0039798899516832395
Época 84000, Erro: 0.003907459350461977
Época 85000, Erro: 0.003837452883238037
Época 86000, Erro: 0.003769754922821888
Época 87000, Erro: 0.003704256914997336
Época 88000, Erro: 0.003640856855065752
Época 89000, Erro: 0.003579458809555279
Época 90000, Erro: 0.0035199724786672804
Época 91000, Erro: 0.0034623127955156425
Época 92000, Erro: 0.00340639955864093
Época 93000, Erro: 0.003352157094656889
Época 94000, Erro: 0.0032995139482174226
Época 95000, Erro: 0.003248402596785916
Época 96000, Erro: 0.0031987591879476464
Época 97000, Erro: 0.0031505232972356785
Época 98000, Erro: 0.003103637704645509
Época 99000, Erro: 0.003058048188194707

Resultados:
Entrada: [0 0], Saída Prevista: [0.]
Entrada: [0 1], Saída Prevista: [1.]
Entrada: [1 0], Saída Prevista: [1.]
Entrada: [1 1], Saída Prevista: [0.]

```

## Teste 4

A rede neural com uma camada oculta de 15 neurônios e um learning rate de 0.2 parece estar aprendendo de forma eficaz, com o erro diminuindo consideravelmente ao longo das épocas. O valor do erro diminui de forma gradual, chegando a números bem pequenos (da ordem de 10^-4) após 100.000 épocas.

- **Erro:** O erro diminui de forma consistente e a rede parece ter convergido para um valor bem baixo.

- **Saídas:** As previsões de saída para as entradas [0,0], [0,1], [1,0], e [1,1] estão corretas, como esperado em uma rede neural treinada para aprender o comportamento de uma porta XOR.

Isso sugere que a arquitetura da rede está funcionando bem com 15 neurônios na camada oculta, e o modelo conseguiu aprender a tarefa.

```py
# Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[15], output_size=1, learning_rate=0.2, epochs=100000)
```

## Saída 4:

```cmd
$ python algorithms/neural_networks/mlp/mlp_simples.py
Época 0, Erro: 0.2676396845896816
Época 1000, Erro: 0.21301878168894345
Época 2000, Erro: 0.0340878684913191
Época 3000, Erro: 0.010936691642512795
Época 4000, Erro: 0.005921851554404587
Época 5000, Erro: 0.003936752908434194
Época 6000, Erro: 0.00290696825521593
Época 7000, Erro: 0.0022863077227005045
Época 8000, Erro: 0.0018749739661349408
Época 9000, Erro: 0.001583956556354345
Época 10000, Erro: 0.0013680093352260597
Época 11000, Erro: 0.0012018477039480056
Época 12000, Erro: 0.0010702963093778598
Época 13000, Erro: 0.0009637246102517496
Época 14000, Erro: 0.0008757407947866172
Época 15000, Erro: 0.0008019436201271157
Época 16000, Erro: 0.0007392078620345041
Época 17000, Erro: 0.0006852557203479109
Época 18000, Erro: 0.0006383894153272597
Época 19000, Erro: 0.000597318629476034
Época 20000, Erro: 0.0005610458533299537
Época 21000, Erro: 0.0005287882333283937
Época 22000, Erro: 0.0004999230863542805
Época 23000, Erro: 0.00047394914531844276
Época 24000, Erro: 0.00045045849534140867
Época 25000, Erro: 0.00042911592093658463
Época 26000, Erro: 0.0004096434836047979
Época 27000, Erro: 0.00039180885133222845
Época 28000, Erro: 0.0003754163595477659
Época 29000, Erro: 0.0003603000877375871
Época 30000, Erro: 0.0003463184420990101
Época 31000, Erro: 0.00033334987642287837
Época 32000, Erro: 0.00032128948237752236
Época 33000, Erro: 0.00031004625040883757
Época 34000, Erro: 0.00029954085266515625
Época 35000, Erro: 0.00028970383575109755
Época 36000, Erro: 0.0002804741377958173
Época 37000, Erro: 0.0002717978640819816
Época 38000, Erro: 0.00026362727025814285
Época 39000, Erro: 0.0002559199133059966
Época 40000, Erro: 0.0002486379389172698
Época 41000, Erro: 0.00024174748044133396
Época 42000, Erro: 0.00023521814959264668
Época 43000, Erro: 0.00022902260302005577
Época 44000, Erro: 0.00022313617190590046
Época 45000, Erro: 0.00021753654418009313
Época 46000, Erro: 0.00021220349085213682
Época 47000, Erro: 0.00020711862949395973
Época 48000, Erro: 0.0002022652191337107
Época 49000, Erro: 0.00019762798181051757
Época 50000, Erro: 0.0001931929468421016
Época 51000, Erro: 0.00018894731451040025
Época 52000, Erro: 0.00018487933640443205
Época 53000, Erro: 0.00018097821009845547
Época 54000, Erro: 0.00017723398620559007
Época 55000, Erro: 0.00017363748614677608
Época 56000, Erro: 0.0001701802292242739
Época 57000, Erro: 0.0001668543677968883
Época 58000, Erro: 0.00016365262952825382
Época 59000, Erro: 0.00016056826582584602
Época 60000, Erro: 0.0001575950057118399
Época 61000, Erro: 0.0001547270144711235
Época 62000, Erro: 0.0001519588565103678
Época 63000, Erro: 0.00014928546193723069
Época 64000, Erro: 0.0001467020964331252
Época 65000, Erro: 0.00014420433404769507
Época 66000, Erro: 0.00014178803259047557
Época 67000, Erro: 0.0001394493113355698
Época 68000, Erro: 0.00013718453079018827
Época 69000, Erro: 0.00013499027430793916
Época 70000, Erro: 0.00013286333135402586
Época 71000, Erro: 0.00013080068225211505
Época 72000, Erro: 0.0001287994842623568
Época 73000, Erro: 0.00012685705885721491
Época 74000, Erro: 0.00012497088007687592
Época 75000, Erro: 0.0001231385638590473
Época 76000, Erro: 0.00012135785824953371
Época 77000, Erro: 0.00011962663441006872
Época 78000, Erro: 0.00011794287834885103
Época 79000, Erro: 0.00011630468330703527
Época 80000, Erro: 0.00011471024274137417
Época 81000, Erro: 0.00011315784384939497
Época 82000, Erro: 0.00011164586158885379
Época 83000, Erro: 0.00011017275314810668
Época 84000, Erro: 0.00010873705282830981
Época 85000, Erro: 0.00010733736730216647
Época 86000, Erro: 0.00010597237121733711
Época 87000, Erro: 0.00010464080311570832
Época 88000, Erro: 0.00010334146164242333
Época 89000, Erro: 0.00010207320202094763
Época 90000, Erro: 0.00010083493277272523
Época 91000, Erro: 9.962561266189204e-05
Época 92000, Erro: 9.844424784722424e-05
Época 93000, Erro: 9.728988922519974e-05
Época 94000, Erro: 9.616162994934515e-05
Época 95000, Erro: 9.505860311244383e-05
Época 96000, Erro: 9.397997957926048e-05
Época 97000, Erro: 9.292496595852615e-05
Época 98000, Erro: 9.189280270388967e-05
Época 99000, Erro: 9.088276233438334e-05

Resultados:
Entrada: [0 0], Saída Prevista: [0.]
Entrada: [0 1], Saída Prevista: [1.]
Entrada: [1 0], Saída Prevista: [1.]
Entrada: [1 1], Saída Prevista: [0.]

```

## Teste 5:

A rede neural com uma camada oculta de 3 neurônios e um learning rate de 0.9 está apresentando um erro que parece se estabilizar em torno de 0.0627, sem muita redução ao longo das épocas.

- **Erros:** O erro não está diminuindo muito, o que pode ser um sinal de que o modelo está tendo dificuldades para aprender devido ao high learning rate.

-  **Saídas:** A rede parece ter "congelado" em um erro local mínimo (em torno de 0.0627), sem apresentar uma redução significativa ao longo das épocas, o que indica que o parâmetro de taxa de aprendizado (learning_rate=0.9) pode estar muito alto. Quando a taxa de aprendizado é muito alta, a rede pode não estar ajustando os pesos adequadamente, pulando as mínimas de erro e não conseguindo convergir corretamente.

```py
 # Cria a rede neural com uma camada oculta de 2 neurônios
    nn = NeuralNetwork(input_size=2, hidden_sizes=[3], output_size=1, learning_rate=0.9, epochs=100000)
```

## Saída 5:

```cmd
$ python algorithms/neural_networks/mlp/mlp_simples.py
Época 0, Erro: 0.25070201512247947
Época 1000, Erro: 0.0768287525238342
Época 2000, Erro: 0.0662421329702902
Época 3000, Erro: 0.06458057785914992
Época 4000, Erro: 0.06392592244191365
Época 5000, Erro: 0.06357885700279758
Época 6000, Erro: 0.06336469794841373
Época 7000, Erro: 0.06321966897693072
Época 8000, Erro: 0.06311506022873486
Época 9000, Erro: 0.06303607618285328
Época 10000, Erro: 0.0629743299307283
Época 11000, Erro: 0.06292471718490966
Época 12000, Erro: 0.06288395499215366
Época 13000, Erro: 0.06284983598485261
Época 14000, Erro: 0.0628208205080451
Época 15000, Erro: 0.06279580061308068
Época 16000, Erro: 0.06277395690714818
Época 17000, Erro: 0.0627546681147734
Época 18000, Erro: 0.0627374517933652
Época 19000, Erro: 0.06272192404191537
Época 20000, Erro: 0.06270777100524705
Época 21000, Erro: 0.06269472766733013
Época 22000, Erro: 0.06268256086508048
Época 23000, Erro: 0.06267105410590937
Época 24000, Erro: 0.06265999178352402
Época 25000, Erro: 0.06264913961273834
Época 26000, Erro: 0.0626382159304391
Época 27000, Erro: 0.06262684319894397
Época 28000, Erro: 0.06261445561963881
Época 29000, Erro: 0.06260010142993523
Época 30000, Erro: 0.06258195907737328
Época 31000, Erro: 0.0625559211777377
Época 32000, Erro: 0.06251015094802509
Época 33000, Erro: 0.062390298963679654
Época 34000, Erro: 0.0603891223216347
Época 35000, Erro: 0.007114579373686779
Época 36000, Erro: 0.004750373833763627
Época 37000, Erro: 0.0035734788543393603
Época 38000, Erro: 0.002862482343755378
Época 39000, Erro: 0.0023858725763076876
Época 40000, Erro: 0.0020441795419493007
Época 41000, Erro: 0.0017873054083454144
Época 42000, Erro: 0.0015872264519815535
Época 43000, Erro: 0.0014270330415603835
Época 44000, Erro: 0.0012959159492356002
Época 45000, Erro: 0.0011866434331264646
Época 46000, Erro: 0.001094194950380808
Época 47000, Erro: 0.0010149765655625277
Época 48000, Erro: 0.0009463482222962791
Época 49000, Erro: 0.0008863272422084568
Época 50000, Erro: 0.000833395898505784
Época 51000, Erro: 0.0007863728085012892
Época 52000, Erro: 0.0007443247517756723
Época 53000, Erro: 0.0007065048318412367
Época 54000, Erro: 0.0006723082386891511
Época 55000, Erro: 0.0006412400346931992
Época 56000, Erro: 0.0006128913183001813
Época 57000, Erro: 0.0005869213304039713
Época 58000, Erro: 0.0005630438447044616
Época 59000, Erro: 0.0005410166919967301
Época 60000, Erro: 0.0005206336080221393
Época 61000, Erro: 0.000501717825372556
Época 62000, Erro: 0.00048411698937333216
Época 63000, Erro: 0.00046769908961198864
Época 64000, Erro: 0.00045234917816793234
Época 65000, Erro: 0.0004379667027144111
Época 66000, Erro: 0.00042446332423988335
Época 67000, Erro: 0.00041176111973028235
Época 68000, Erro: 0.00039979109289650823
Época 69000, Erro: 0.0003884919330998978
Época 70000, Erro: 0.0003778089755514244
Época 71000, Erro: 0.0003676933257282102
Época 72000, Erro: 0.00035810111854459785
Época 73000, Erro: 0.0003489928887024095
Época 74000, Erro: 0.0003403330332415369
Época 75000, Erro: 0.00033208935092494637
Época 76000, Erro: 0.00032423264594924183
Época 77000, Erro: 0.00031673638574546717
Época 78000, Erro: 0.00030957640445381527
Época 79000, Erro: 0.0003027306451192883
Época 80000, Erro: 0.0002961789348386089
Época 81000, Erro: 0.00028990278805069493
Época 82000, Erro: 0.00028388523394700976
Época 83000, Erro: 0.0002781106646233598
Época 84000, Erro: 0.00027256470112341376
Época 85000, Erro: 0.00026723407496367934
Época 86000, Erro: 0.00026210652309320906
Época 87000, Erro: 0.00025717069454478484
Época 88000, Erro: 0.0002524160672878865
Época 89000, Erro: 0.00024783287400693916
Época 90000, Erro: 0.00024341203570735573
Época 91000, Erro: 0.00023914510220343586
Época 92000, Erro: 0.00023502419867062343
Época 93000, Erro: 0.0002310419775535968
Época 94000, Erro: 0.00022719157521485872
Época 95000, Erro: 0.00022346657278761166
Época 96000, Erro: 0.00021986096076525408
Época 97000, Erro: 0.0002163691069180777
Época 98000, Erro: 0.0002129857271783419
Época 99000, Erro: 0.00020970585917830004

Resultados:
Entrada: [0 0], Saída Prevista: [0.]
Entrada: [0 1], Saída Prevista: [1.]
Entrada: [1 0], Saída Prevista: [1.]
Entrada: [1 1], Saída Prevista: [0.]

```

---
