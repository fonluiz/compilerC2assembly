# compilerC2assembly
A simple compiler using CUP/JFlex to parse code from C to Assembly 

## Instruções

### Análise Léxica
É necessário ter o Jflex instalado no PC e com variáveis de ambiente setadas.

Dessa forma, execute:

```
cd src/lexical
jflex lexical.flex
```

O analisador léxico será gerado e salvo em `Lexer.java`.

### Análise Sintática
Execute os seguintes comandos:

```
cd src/syntax
java -jar java-cup-11b.jar parser.cup
```

O analisador sintático será gerado em `parser.java` e os símbolos em `sym.java`.

### Testando uma entrada

Gostaria de saber