### **Roteamento Estático**  

O **roteamento estático** é um método de roteamento onde as rotas são configuradas manualmente pelo administrador da rede. Diferente do roteamento dinâmico, que ajusta automaticamente os caminhos da rede, o roteamento estático mantém as rotas fixas, sem alteração automática em caso de falha.  

#### **Características**  
- As rotas são **definidas manualmente** e armazenadas na tabela de roteamento.  
- **Não há troca de informações entre roteadores**, reduzindo o tráfego de controle na rede.  
- **Não se adapta automaticamente a mudanças na topologia**, exigindo reconfiguração manual.  

#### **Vantagens**  
- **Baixo consumo de recursos**: como não há cálculos dinâmicos, o uso de CPU e memória do roteador é menor.  
- **Maior controle**: o administrador pode definir exatamente como o tráfego deve ser encaminhado.  
- **Segurança**: menos vulnerável a ataques de falsificação de rotas, pois não há propagação automática.  

#### **Desvantagens**  
- **Difícil de gerenciar em redes grandes**, pois qualquer alteração exige ajustes manuais.  
- **Não se adapta a falhas**: se um link cair, o tráfego pode ser interrompido até que a configuração seja atualizada.  
- **Propenso a erros humanos**, o que pode resultar em problemas de conectividade.  

#### **Exemplo de Configuração em um Roteador Cisco**  
```bash
ip route 192.168.2.0 255.255.255.0 192.168.1.1
```
- O tráfego para **192.168.2.0/24** será enviado pelo gateway **192.168.1.1**.  
- Se esse gateway falhar, será necessário configurar uma nova rota manualmente.  

#### **Quando Usar o Roteamento Estático?**  
- Em **redes pequenas**, onde a topologia raramente muda.  
- Para **definir rotas específicas**, como caminhos preferenciais para determinados tipos de tráfego.  
- Como **backup** em conjunto com protocolos de roteamento dinâmico, garantindo um caminho fixo em caso de falha.  

Em resumo, o roteamento estático é simples e eficiente para redes pequenas, mas se torna inviável em infraestruturas complexas que exigem maior dinamismo e adaptação automática.
