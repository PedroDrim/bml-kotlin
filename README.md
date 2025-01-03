# bml-Kotlin

### Introdução

O objetivo deste repositório é estudar o comportamento, estrutura e o desempenho da linguagem Kotlin.

Este repositório funciona como um plugin para o repositório princial **Benchmark Languages**.

Ferramentas utilizadas neste repositório bem como suas versões:

|Ferramenta |Versão  |
|-----------|--------|
|Kotlin     |2.0.0   |
|JVM        |21      |

### Instalação

1. Clone este repositório com o comando abaixo, onde **<branch>>** se refere ao experimento que deseja realizar:

```
git clone -b <branch> https://github.com/PedroDrim/bml-kotlin
```

2. Configure o **JAVA_HOME** para uma versão compativel com JAVA 21:


3. Entre no diretório do repositório clonado e execute o arquivo **gradlew** com parametro **build**:

```
./gradlew build
```

3. Entre no diretório do repositório clonado e execute o arquivo **Bench.sh** passando como parametro o arquivo a ser lido no teste (.csv):

```
./Bench.sh ./test.csv
```

### Experimentos

Esta seção é a mais divertida (na minha opinião), pois nela descrevo os experimentos realizados com as linguagens bem como as técnicas utilizadas para as respectivas análises.

| Nome (com link) | Objetivo | Técnicas utilizadas para análise |
|-----------------|----------|----------------------------------|
| [simpleclass](https://github.com/PedroDrim/Benchmark-Languages/blob/simpleclass/Documents/simpleclass.md) | Estudar a criação de classes simples | Scatterplot de média com desvio padrão e regressão linear simples.|
| [inputclass](https://github.com/PedroDrim/Benchmark-Languages/blob/master/outputs/inputclass/inputclass.md) | Estudar a leitura de arquivos e interfaces | Análise por média e exibição por Barplot estacado |
