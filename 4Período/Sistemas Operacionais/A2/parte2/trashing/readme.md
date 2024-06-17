**Causas do Thrashing:**

* **Memória Insuficiente:** Mesas demais para um restaurante pequeno.
* **Algoritmos Ineficientes:** Garçons mal treinados que se perdem entre os pedidos.
* **Processos com Grande Demanda:** Clientes que pedem pratos elaborados que demoram para preparar.

**Soluções para Thrashing:**

* **Aumentar a RAM:** Ampliar o restaurante para acomodar mais mesas.
* **Aprimorar Algoritmos:** Treinar os garçons para serem mais eficientes.
* **Limitar Processos:** Controlar o número de clientes no restaurante.
* **Técnicas de Compactação:** Reorganizar as mesas para liberar espaço.

**Pergunta Técnica:**

**Em um sistema com 4 GB de RAM e algoritmo First Fit, qual a fragmentação interna após alocar três processos de 1 GB, 512 MB e 768 MB?**

**Resposta:**

1. Primeiro processo aloca 1 GB, sem fragmentação.
2. Segundo processo aloca 512 MB nos 1,5 GB restantes, fragmentando 992 MB.
3. Terceiro processo não cabe nos 992 MB fragmentados, necessitando de mais RAM.

**Fragmentação interna:** 992 MB

---
