import java_cup.*;
import java_cup.runtime.*;
import compiler.core.*;

%%

%public
%class Scanner
%unicode
%line
%column
%cup
%cupdebug

%{
   StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
	return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  private long parseLong(int start, int end, int radix) {
	long result = 0;
	long digit;

	for (int i = start; i < end; i++) {
	  digit  = Character.digit(yycharat(i),radix);
	  result*= radix;
	  result+= digit;
	}

	return result;
  }
%}

O = [0-7]
D = [0-9]
NZ = [1-9]
L = [a-zA-Z_]
A= [a-zA-Z_0-9]
H = [a-fA-F0-9]
HP = (0[xX])
E = ([Ee][+-]?{D}+)
P = ([Pp][+-]?{D}+)
FS = (f|F|l|L)
IS = (((u|U)(l|L|ll|LL)?)|((l|L|ll|LL)(u|U)?))
CP = (u|U|L)
SP = (u8|u|U|L)
ES = (\\(['"\?\\abfnrtv]|[0-7]{1,3}|x[a-fA-F0-9]+))
WS = [ \t\v\n\f]

"/*"                                    { comment(); }
"//".*                                    { /* consume //-comment */ }

%%

<YYINITIAL> {

    "auto"					{ return symbol(sym.AUTO); }
    "break"					{ return symbol(sym.BREAK); }
    "case"					{ return symbol(sym.CASE); }
    "char"					{ return symbol(sym.CHAR); }
    "const"					{ return symbol(sym.CONST); }
    "continue"				{ return symbol(sym.CONTINUE); }
    "default"				{ return symbol(sym.DEFAULT); }
    "do"					{ return symbol(sym.DO); }
    "double"				{ return symbol(sym.DOUBLE); }
    "else"					{ return symbol(sym.ELSE); }
    "enum"					{ return symbol(sym.ENUM); }
    "extern"				{ return symbol(sym.EXTERN); }
    "float"					{ return symbol(sym.FLOAT); }
    "for"					{ return symbol(sym.FOR); }
    "goto"					{ return symbol(sym.GOTO); }
    "if"					{ return symbol(sym.IF); }
    "inline"				{ return symbol(sym.INLINE); }
    "int"					{ return symbol(sym.INT); }
    "long"					{ return symbol(sym.LONG); }
    "register"				{ return symbol(sym.REGISTER); }
    "restrict"				{ return symbol(sym.RESTRICT); }
    "return"				{ return symbol(sym.RETURN); }
    "short"					{ return symbol(sym.SHORT); }
    "signed"				{ return symbol(sym.SIGNED); }
    "sizeof"				{ return symbol(sym.SIZEOF); }
    "static"				{ return symbol(sym.STATIC); }
    "struct"				{ return symbol(sym.STRUCT); }
    "switch"				{ return symbol(sym.SWITCH); }
    "typedef"				{ return symbol(sym.TYPEDEF); }
    "union"					{ return symbol(sym.UNION); }
    "unsigned"				{ return symbol(sym.UNSIGNED); }
    "void"					{ return symbol(sym.VOID); }
    "volatile"				{ return symbol(sym.VOLATILE); }
    "while"					{ return symbol(sym.WHILE); }

    /* Essa parte de baixo ainda falta terminar porque deu preguiça, mas é mais ou menos
    nesse esquema */
    "_Alignas"                              { return ALIGNAS; }
    "_Alignof"                              { return ALIGNOF; }
    "_Atomic"                               { return ATOMIC; }
    "_Bool"                                 { return BOOL; }
    "_Complex"                              { return COMPLEX; }
    "_Generic"                              { return GENERIC; }
    "_Imaginary"                            { return IMAGINARY; }
    "_Noreturn"                             { return NORETURN; }
    "_Static_assert"                        { return STATIC_ASSERT; }
    "_Thread_local"                         { return THREAD_LOCAL; }
    "__func__"                              { return FUNC_NAME; }

    {L}{A}*					{ return check_type(); }

    {HP}{H}+{IS}?				{ return I_CONSTANT; }
    {NZ}{D}*{IS}?				{ return I_CONSTANT; }
    "0"{O}*{IS}?				{ return I_CONSTANT; }
    {CP}?"'"([^'\\\n]|{ES})+"'"		{ return I_CONSTANT; }

    {D}+{E}{FS}?				{ return F_CONSTANT; }
    {D}*"."{D}+{E}?{FS}?			{ return F_CONSTANT; }
    {D}+"."{E}?{FS}?			{ return F_CONSTANT; }
    {HP}{H}+{P}{FS}?			{ return F_CONSTANT; }
    {HP}{H}*"."{H}+{P}{FS}?			{ return F_CONSTANT; }
    {HP}{H}+"."{P}{FS}?			{ return F_CONSTANT; }

    ({SP}?\"([^"\\\n]|{ES})*\"{WS}*)+	{ return STRING_LITERAL; }

    "..."					{ return ELLIPSIS; }
    ">>="					{ return RIGHT_ASSIGN; }
    "<<="					{ return LEFT_ASSIGN; }
    "+="					{ return ADD_ASSIGN; }
    "-="					{ return SUB_ASSIGN; }
    "*="					{ return MUL_ASSIGN; }
    "/="					{ return DIV_ASSIGN; }
    "%="					{ return MOD_ASSIGN; }
    "&="					{ return AND_ASSIGN; }
    "^="					{ return XOR_ASSIGN; }
    "|="					{ return OR_ASSIGN; }
    ">>"					{ return RIGHT_OP; }
    "<<"					{ return LEFT_OP; }
    "++"					{ return INC_OP; }
    "--"					{ return DEC_OP; }
    "->"					{ return PTR_OP; }
    "&&"					{ return AND_OP; }
    "||"					{ return OR_OP; }
    "<="					{ return LE_OP; }
    ">="					{ return GE_OP; }
    "=="					{ return EQ_OP; }
    "!="					{ return NE_OP; }
    ";"					{ return ';'; }
    ("{"|"<%")				{ return '{'; }
    ("}"|"%>")				{ return '}'; }
    ","					{ return ','; }
    ":"					{ return ':'; }
    "="					{ return '='; }
    "("					{ return '('; }
    ")"					{ return ')'; }
    ("["|"<:")				{ return '['; }
    ("]"|":>")				{ return ']'; }
    "."					{ return '.'; }
    "&"					{ return '&'; }
    "!"					{ return '!'; }
    "~"					{ return '~'; }
    "-"					{ return '-'; }
    "+"					{ return '+'; }
    "*"					{ return '*'; }
    "/"					{ return '/'; }
    "%"					{ return '%'; }
    "<"					{ return '<'; }
    ">"					{ return '>'; }
    "^"					{ return '^'; }
    "|"					{ return '|'; }
    "?"					{ return '?'; }

    {WS}+					{ /* whitespace separates tokens */ }
    .					{ /* discard bad characters */ }

}


