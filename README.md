# logica-computacional-ep3

Terceiro Exercíco-Programa da Disciplina de Lógica Computacional

## Instalação

Para executar o projeto, você deve ter o `Clojure` e `Lein` instalados em seu computador. Os passos de instalação podem ser encontrados nas páginas oficiais:

[Como instalar Clojure](https://clojure.org/guides/install_clojure)

[Como instalar Lein](https://leiningen.org)


## Como executar

### Automatos finitos determinísticos

Criar um arquivo na pasta  `./resources` no formato json contendo seu autômato segundo a seguinte regra:





Deve haver um atributo "start" que contém o nome do estado inicial.
Deve haver um atributo "accept" que contém uma lista dos estados de aceitação do autômato.
Deve haver um atributo "transition" que mapeia as transições de estado no seguinte formato:

```
"$symbol": {
    "$origin-state": "$destiny-state"
}
```

onde $symbol é o caracter atual lido, $origin-state o estado de origem e $destiny-state o estado de destino.


A exemplo, o autômato seguinte com estado inicial `A`



É representado por

```
{
    "start": "A",
    "accept": [
        "B"
    ],
    "transition": {
        "1": {
            "A": "B",
            "B": "B"
        },
        "0": {
            "A": "A",
            "B": "A"
        }
    }
}
```

### Automatos finitos não-determinísticos

A representação de autômatos finitos não determinísticos é muito similar à representação dos determinísticos.

A primeira diferença é que para os estados destinos de uma transição, passamos uma lista de possíveis estados finais.

Além disso, caso haja uma transição que não consuma caracteres de entrada, utilizamos uma string vazia como $symbol.

Por exemplo, o autômato seguinte



Pode ser representado por:

```
{
    "start": "q0",
    "accept": [
        "q0"
    ],
    "transition": {
        "1": {
            "q0": [
                "q1"
            ],
            "q1": [
                "q2"
            ]
        },
        "0": {
            "q1": [
                "q0",
                "q2"
            ]
        },
        "": {
            "q0": [
                "q2"
            ]
        }
    }
}
```

Utilizar o comando:
```
lein run -m logica-computacional-ep3.core dfa example.json "101101011"
```
