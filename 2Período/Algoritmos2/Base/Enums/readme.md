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
    BRANCA(1, "branca", "#ffffff"),
    PRETA(2, "preta", "#000000"),
    AZUL(3, "azul", "#000fff"),
    AMARELA(4,"amarela", "#FFFF00"),
    VERDE(5, "verde", "#008000");

    private int id;
    private String label;
    private String hexa;

    private Cor(int id, String label, String hexa){
        this.id = id;
        this.label = label;
        this.hexa = hexa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", hexa='" + hexa + '\'' +
                '}';
    }
}
```

## Métodos em Enums:

- ``name()``: Nome o algarismo enum;
- ``ordinal()``: Número da enum;

---
### - ``@Overrride valueOF()``: 
Nesta aplicação queremos que receba
um valor do usuário, e devolva o objeto referente a este id dentro da enum
```java
public static Cor valueOf(Integer id){
        if(id == null){
            return null;
        }
        for (Cor cor: Cor.values()) {
            if(cor.getId() == id){
                return cor;
            }
        }
        return null;
    }
```

Este método é utilizado como comparação ao valor de cada index
do nosso enum, em que ele consegue receber este inteiro, e devolve
o referente do objeto, na qual usamos o reescrito do método toString;

```java
@Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", hexa='" + hexa + '\'' +
                '}';
    }
```

---