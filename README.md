# compilerC2assembly
A simple compiler using CUP/JFlex to parse code from C to Assembly 

## Instruções

### Executando análise léxica/sintática e testando entrada

Para testar o fluxo inteiro basta executar em um terminal linux:

```
cd src/all
./makeTest.sh
```

Os comandos desse script incluem geração do Lexer (Analisador léxico), Parser e Sym (Analisador sintático) e a instância para teste a partir de uma entrada chamada `input.c` que contém um programa `.c` escrito corretamente. Além disso, a análise é feita para um programa com sintaxe incorreta, `wrong_input.c`, de forma que o erro é apontado e nenhuma saída é gerada.

`input.c` > `simple.xml`: Árvore do parser para o programa, apontando cada lexema e qual regra foi utilizada.

### Gerando Lexer
Executar os seguintes comandos:

```
cd src/all
jflex lexical_simpler.flex
```

### Gerando Parser e analisador sintático
Executar os seguintes comandos:

```
cd src/all
java -jar ../../lib/java-cup-11b.jar -locations -interface -parser Parser -xmlactions NewParser.cup
javac -cp ../../lib/java-cup-11b-runtime.jar:. *.java
```
Os comandos acima geram arquivos `.class` que poderão ser utilizados para testar qualquer entrada.

### Testando entradas personalizadas
Subentendendo-se que o Parser foi gerado juntamente com o analisador sintático, executar os seguintes comandos:

```
cd src/all
java -cp ../../lib/java-cup-11b-runtime.jar:. Parser <entrada.c> <saida.xml>

```

Se o programa não possuir erros, o arquivo XML será gerado com a árvore de análise, do contrário o erro será reportado.

Para mais informações verificar o [commit](https://github.com/fonluiz/compilerC2assembly/commit/903996afc4501792d59567e7c90e4128776b08dd) referente à essa inserção.