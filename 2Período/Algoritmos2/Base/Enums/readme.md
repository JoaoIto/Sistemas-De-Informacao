# Enums

Traduzidos como ***enumeradores***, são um tipo de
"classe" dentro da linguagem, (já que este tipo de
recurso está disponível em várias linguagens, não só
no Java...) em que você pode criar atributos enumerados com
valores sequenciais ou pré-definidos.

---

## Constructor enum:

Uma regra a ser citada é que uma enum, **deve ser sempre criada a partir de 
um constructor privado da própria classe!** Sendo assim ainda este podendo
ser um constructor ainda a cada parâmetro:

```java
package src.enums;

public enum Cor {
    BRANCA(1, "branca"),
    PRETA(2, "preta"),
    AZUL(3, "azul"),
    AMARELA(4,"amarela"),
    VERDE(5, "verde");

    private int id;
    private String label;

    private Cor(int id, String label){
        this.id = id;
        this.label = label;
    }
}
```

## Métodos em Enums:

- ``name()``: Nome o algarismo enum;
- ``ordinal()``: Número da enum;

---