package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    private int typecheck(String s){
		if (Parser.lookupType(s.trim()))
			return TYPE_NAME;
		else 
			return IDENTIFIER;
    }
%}

D				=		[0-9]
L				=		[a-zA-Z_]
H				=		[a-fA-F0-9]
E				=		[Ee][+-]?{D}+
FS				=		(f|F|l|L)
IS				=		(u|U|l|L)*
TC              =       "/*" [^*] ~"*/" | "/*" "*"+ "/"
EC              =       "//" [^\r\n]* {new_line}    
new_line        =       \r|\n|\r\n
white_space     =       {new_line} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  {EC}                    { }
  {TC}                    { }
  
  "auto"			{ return symbol("AUTO",AUTO,yytext()); }
  "break"			{ return symbol("BREAK",BREAK,yytext()); }
  "case"			{ return symbol("CASE",CASE,yytext()); }
  "char"			{ return symbol("CHAR",CHAR,yytext()); }
  "const"			{ return symbol("CONST",CONST,yytext()); }
  "continue"		{ return symbol("CONTINUE",CONTINUE,yytext()); }
  "default"			{ return symbol("DEFAULT",DEFAULT,yytext()); }
  "do"				{ return symbol("DO",DO,yytext()); }
  "double"			{ return symbol("DOUBLE",DOUBLE,yytext()); }
  "else"			{ return symbol("ELSE",ELSE,yytext()); }
  "enum"			{ return symbol("ENUM",ENUM,yytext()); }
  "extern"			{ return symbol("EXTERN",EXTERN,yytext()); }
  "float"			{ return symbol("FLOAT",FLOAT,Float.parseFloat(yytext())); }
  "for"				{ return symbol("FOR",FOR,yytext()); }
  "goto"			{ return symbol("GOTO",GOTO,yytext()); }
  "if"				{ return symbol("GOTO",IF,yytext()); }
  "int"				{ return symbol("INT",INT, Integer.parseInt(yytext())); }
  "long"			{ return symbol("LONG", LONG, Long.parseLong(yytext())); }
  "register"		{ return symbol("REGISTER",REGISTER,yytext()); }
  "return"			{ return symbol("RETURN",RETURN,yytext()); }
  "short"			{ return symbol("SHORT",SHORT,yytext()); }
  "signed"			{ return symbol("SIGNED",SIGNED,yytext()); }
  "sizeof"			{ return symbol("SIZEOF",SIZEOF,yytext()); }
  "static"			{ return symbol("STATIC",STATIC,yytext()); }
  "struct"			{ return symbol("STRUCT",STRUCT,yytext()); }
  "switch"			{ return symbol("SWITCH",SWITCH,yytext()); }
  "typedef"			{ return symbol("TYPEDEF",TYPEDEF,yytext()); }
  "union"			{ return symbol("UNION",UNION,yytext()); }
  "unsigned"		{ return symbol("UNSIGNED",UNSIGNED,yytext()); }
  "void"			{ return symbol("VOID",VOID,yytext()); }
  "volatile"		{ return symbol("VOLATILE",VOLATILE,yytext()); }
  "while"			{ return symbol("WHILE",WHILE,yytext()); }

  {L}({L}|{D})*		{ return symbol(typecheck(yytext()), yytext()); }

  0[xX]{H}+{IS}?		{ return symbol(CONSTANT,yytext()); }
  0{D}+{IS}?		{ return symbol(CONSTANT,yytext()); }
  {D}+{IS}?		{ return symbol(CONSTANT,yytext()); }
  L?'(\\.|[^\\'])+'	{ return symbol(CONSTANT,yytext()); }

  {D}+{E}{FS}?		{ return symbol(CONSTANT,yytext()); }
  {D}*"."{D}+({E})?{FS}?	{ return symbol(CONSTANT,yytext()); }
  {D}+"."{D}*({E})?{FS}?	{ return symbol(CONSTANT,yytext()); }

  L?\"(\\.|[^\\\"])*\"	{ return symbol(STRING_LITERAL,yytext()); }

  "..."			{ return symbol("ELLIPSIS",ELLIPSIS); }
  ">>="			{ return symbol("RIGHT_ASSIGN",RIGHT_ASSIGN); }
  "<<="			{ return symbol("LEFT_ASSIGN",LEFT_ASSIGN); }
  "+="			{ return symbol("ADD_ASSIGN",ADD_ASSIGN); }
  "-="			{ return symbol("SUB_ASSIGN",SUB_ASSIGN); }
  "*="			{ return symbol("MUL_ASSIGN",MUL_ASSIGN); }
  "/="			{ return symbol("DIV_ASSIGN",DIV_ASSIGN); }
  "%="			{ return symbol("MOD_ASSIGN",MOD_ASSIGN); }
  "&="			{ return symbol("AND_ASSIGN",AND_ASSIGN); }
  "^="			{ return symbol("XOR_ASSIGN",XOR_ASSIGN); }
  "|="			{ return symbol("OR_ASSIGN",OR_ASSIGN); }
  ">>"			{ return symbol("RIGHT_OP",RIGHT_OP); }
  "<<"			{ return symbol("LEFT_OP",LEFT_OP); }
  "++"			{ return symbol("INC_OP",INC_OP); }
  "--"			{ return symbol("DEC_OP",DEC_OP); }
  "->"			{ return symbol("PTR_OP",PTR_OP); }
  "&&"			{ return symbol("AND_OP",AND_OP); }
  "||"			{ return symbol("OR_OP",OR_OP); }
  "<="			{ return symbol("LE_OP",LE_OP); }
  ">="			{ return symbol("GE_OP",GE_OP); }
  "=="			{ return symbol("EQ_OP",EQ_OP); }
  "!="			{ return symbol("NE_OP",NE_OP); }
  ";"			{ return symbol("SEMI",SEMI); }
  ("{"|"<%")		{ return symbol("CURLYL",CURLYL); }
  ("}"|"%>")		{ return symbol("CURLYR",CURLYR); }
  ","			{ return symbol("COMMA",COMMA); }
  ":"			{ return symbol("COLON",COLON); }
  "="			{ return symbol("ASSIGN",ASSIGN); }
  "("			{ return symbol("PARAL",PARAL); }
  ")"			{ return symbol("PARAR",PARAR); }
  ("["|"<:")		{ return symbol("SQUAREDL",SQUAREDL); }
  ("]"|":>")		{ return symbol("SQUAREDR",SQUAREDR); }
  "."			{ return symbol("POINT",POINT); }
  "&"			{ return symbol("ADRESS",ADRESS); }
  "!"			{ return symbol("NOT",NOT); }
  "~"			{ return symbol("TILDE",TILDE); }
  "-"			{ return symbol("MINUS",MINUS); }
  "+"			{ return symbol("PLUS",PLUS); }
  "*"			{ return symbol("MUL",MUL); }
  "/"			{ return symbol("DIVIDE",DIVIDE); }
  "%"			{ return symbol("MODULUS",MODULUS); }
  "<"			{ return symbol("LESS",LESS); }
  ">"			{ return symbol("GREATER",GREATER); }
  "^"			{ return symbol("XOR",XOR); }
  "|"			{ return symbol("OR",OR); }
  "?"			{ return symbol("COND",COND); }
   
  {white_space}		{ /* ignore bad characters */ }
}



// error fallback
[^]|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
