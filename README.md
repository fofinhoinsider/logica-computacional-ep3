# logica-computacional-ep1

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

![alt text](https://postimg.cc/N2g29NhQ)

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

Além disso, caso haja uma transição que utiliza

Por exemplo, o autômato seguinte



Utilizar o comando:
```
lein run -m logica-computacional-ep3.core dfa example.json "101101011"
```

O fecho reflexivo e transitivo será representado na matriz em "reflexive_transitive_closure.csv".

Você pode executar os testes EndToEnd pelo comando
```
lein test
```

Caso queira incluir novos tests, insira um novo arquivo de entrada na pasta `test/logica_computacional_ep1/data/input` com o nome matrix`{N}`.csv e um arquivo de saída em `test/logica_computacional_ep1/data/expected_output` nomeado expected_output`{N}`.csv com a saída esperada. Execute o comando de teste novamente e verifique se o teste passa para seu caso.

## Relatório

Com esse projeto foi possível entender melhor a teoria de conjuntos em respeito as relações (...)