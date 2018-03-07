/* The following code was generated by JFlex 1.3.5 on 07/03/18 13:11 */

package core;

import java.io.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java.util.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 07/03/18 13:11 from the specification file
 * <tt>file:/home/luiz/Faculdade/compilerC2assembly/spec/lexer.jflex</tt>
 */
class Lexer implements java_cup.runtime.Scanner, sym {

  /** This character denotes the end of file */
  final public static int YYEOF = -1;

  /** initial size of the lookahead buffer */
  final private static int YY_BUFFERSIZE = 16384;

  /** lexical states */
  final public static int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = {
     0,  0,  0,  0,  0,  0,  0,  0,  0, 16, 14,  0, 16, 15,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    16, 52, 43,  0,  0, 48, 49, 40, 58, 59, 13, 47, 56,  5, 42, 12, 
    38,  1,  1,  1,  1,  1,  1,  1,  1,  1, 57, 53, 46, 45, 44, 63, 
     0,  3,  3,  3,  3,  4,  7,  2,  2,  2,  2,  2,  9,  2,  2,  2, 
     2,  2,  2,  2,  2, 11,  2,  2, 39,  2,  2, 60, 41, 61, 50,  2, 
     0, 17, 20, 24, 29, 22,  6, 32, 26, 28,  2, 23,  8, 30, 27, 19, 
    36,  2, 21, 25, 18, 10, 37, 34, 31, 35, 33, 54, 51, 55, 62,  0
  };

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    64,   128,   192,   256,   320,   384,   448,   512,   576, 
      640,    64,   704,   768,   832,   896,   960,  1024,  1088,  1152, 
     1216,  1280,  1344,  1408,  1472,  1536,  1600,  1664,  1728,  1792, 
     1856,  1920,  1984,  2048,  2112,  2176,  2240,  2304,    64,    64, 
       64,    64,  2368,    64,    64,    64,    64,    64,    64,  2432, 
     2496,  2560,    64,    64,    64,  2624,  2688,  2752,  1600,  1728, 
     2816,  2880,  2944,    64,    64,  3008,  3072,  3136,  3200,  3264, 
     3328,  3392,  3456,  3520,  3584,  3648,  3712,  3776,  3840,   192, 
     3904,  3968,  4032,  4096,  4160,  4224,  4288,  4352,  4416,  4480, 
     4544,    64,  4608,    64,    64,    64,  4672,    64,    64,    64, 
       64,    64,    64,    64,    64,    64,  4736,  4800,    64,  4864, 
      192,  4928,  4992,  5056,    64,  5120,  5184,  5248,  5312,  5376, 
     5440,  5504,  5568,  5632,  5696,  5760,  5824,  5888,  5952,  6016, 
     6080,  6144,  6208,  6272,  6336,   192,  6400,  6464,  6528,  6592, 
     6656,  6720,  6784,    64,    64,    64,  6848,   192,  6912,  6976, 
     7040,   192,  7104,  7168,  7232,  7296,   192,   192,  7360,   192, 
     7424,  7488,   192,  7552,  7616,  7680,  7744,  7808,  7872,  7936, 
     8000,   192,  8064,  8128,   192,   192,  8192,   192,  8256,   192, 
     8320,  8384,  8448,  8512,   192,  8576,  8640,   192,  8704,  8768, 
     8832,  8896,  8960,   192,  9024,  9088,  9152,   192,  9216,   192, 
     9280,   192,   192,   192,   192,   192,   192,  9344,  9408,  9472, 
      192,  9536,  9600,   192,  9664,   192,   192,   192,   192
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\2\1\3\3\4\1\5\1\6\1\4\1\7\1\10"+
    "\1\11\1\4\1\12\1\13\1\14\1\15\1\14\1\16"+
    "\1\17\1\4\1\20\1\21\1\22\1\4\1\23\1\24"+
    "\2\4\1\25\1\26\2\4\1\27\1\4\1\30\2\4"+
    "\1\31\1\32\1\4\1\33\1\2\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\101\0\1\3\2\0\1\62\3\0"+
    "\4\63\12\0\1\62\17\0\1\3\3\0\1\64\26\0"+
    "\4\4\1\0\6\4\5\0\27\4\35\0\1\65\46\0"+
    "\1\66\1\67\23\0\4\4\1\0\2\4\1\70\3\4"+
    "\5\0\2\4\1\71\24\4\31\0\4\4\1\0\6\4"+
    "\5\0\2\4\1\72\24\4\31\0\4\4\1\0\6\4"+
    "\5\0\27\4\1\73\2\0\1\74\25\0\4\4\1\0"+
    "\6\4\5\0\12\4\1\75\14\4\44\0\1\76\1\77"+
    "\37\0\1\100\77\0\1\101\40\0\1\14\62\0\4\4"+
    "\1\0\4\4\1\102\1\4\5\0\27\4\31\0\4\4"+
    "\1\0\6\4\5\0\22\4\1\103\4\4\31\0\4\4"+
    "\1\0\6\4\5\0\4\4\1\104\22\4\31\0\4\4"+
    "\1\0\6\4\5\0\5\4\1\105\21\4\31\0\4\4"+
    "\1\0\2\4\1\106\3\4\5\0\12\4\1\107\3\4"+
    "\1\110\10\4\31\0\4\4\1\0\6\4\5\0\1\111"+
    "\1\4\1\112\6\4\1\113\15\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\114\7\4\1\115\1\4\1\116"+
    "\5\4\1\117\5\4\31\0\4\4\1\0\1\120\5\4"+
    "\5\0\12\4\1\121\14\4\31\0\4\4\1\0\6\4"+
    "\5\0\2\4\1\122\2\4\1\123\21\4\31\0\4\4"+
    "\1\0\6\4\5\0\2\4\1\124\24\4\31\0\4\4"+
    "\1\0\6\4\5\0\11\4\1\125\15\4\31\0\4\4"+
    "\1\0\6\4\5\0\2\4\1\126\24\4\31\0\1\3"+
    "\2\0\1\62\3\0\4\63\12\0\1\62\10\0\1\127"+
    "\6\0\1\3\1\127\2\0\1\64\25\0\50\130\1\0"+
    "\1\131\26\130\1\0\1\64\44\0\1\64\3\0\1\132"+
    "\25\0\51\74\1\133\1\74\1\134\24\74\54\0\1\135"+
    "\1\136\77\0\1\137\77\0\1\140\1\141\1\0\1\50"+
    "\10\0\1\56\63\0\1\142\1\0\1\143\74\0\1\51"+
    "\1\144\77\0\1\145\3\0\1\146\73\0\1\147\77\0"+
    "\1\150\5\0\1\151\71\0\1\152\76\0\1\57\24\0"+
    "\1\153\3\0\1\154\40\0\1\153\10\0\1\154\30\0"+
    "\4\63\65\0\1\64\2\0\1\62\1\0\4\155\14\0"+
    "\1\62\17\0\1\64\32\0\4\4\1\0\6\4\5\0"+
    "\2\4\1\156\24\4\31\0\4\4\1\0\6\4\5\0"+
    "\4\4\1\157\22\4\31\0\4\4\1\0\6\4\5\0"+
    "\12\4\1\160\14\4\31\0\4\4\1\0\6\4\5\0"+
    "\10\4\1\161\2\4\1\162\13\4\30\0\16\76\1\163"+
    "\1\164\60\76\15\165\1\166\62\165\1\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\167\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\23\4\1\170\3\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\171\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\172\15\4\1\173\7\4\31\0"+
    "\4\4\1\0\6\4\5\0\10\4\1\174\16\4\31\0"+
    "\4\4\1\0\4\4\1\175\1\4\5\0\27\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\4\1\176\25\4\31\0"+
    "\4\4\1\0\6\4\5\0\10\4\1\177\16\4\31\0"+
    "\4\4\1\0\6\4\5\0\12\4\1\200\14\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\201\26\4\31\0\4\4"+
    "\1\0\6\4\5\0\1\202\3\4\1\203\22\4\31\0"+
    "\4\4\1\0\6\4\5\0\2\4\1\204\24\4\31\0"+
    "\4\4\1\0\6\4\5\0\17\4\1\205\1\206\6\4"+
    "\31\0\4\4\1\0\6\4\5\0\13\4\1\207\13\4"+
    "\31\0\4\4\1\0\6\4\5\0\1\4\1\210\25\4"+
    "\31\0\4\4\1\0\4\4\1\211\1\4\5\0\27\4"+
    "\31\0\4\4\1\0\1\212\5\4\5\0\27\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\4\1\213\25\4\31\0"+
    "\4\4\1\0\6\4\5\0\13\4\1\214\13\4\31\0"+
    "\4\4\1\0\2\4\1\215\3\4\5\0\13\4\1\216"+
    "\13\4\31\0\1\217\1\0\2\217\1\0\2\217\11\0"+
    "\1\217\2\0\1\217\1\0\1\217\1\0\1\217\4\0"+
    "\1\217\10\0\1\217\31\0\50\130\1\155\1\131\44\130"+
    "\1\0\61\130\52\0\1\220\25\0\16\74\1\0\61\74"+
    "\55\0\1\221\77\0\1\222\23\0\1\153\4\0\4\155"+
    "\34\0\1\153\32\0\1\153\44\0\1\153\32\0\4\4"+
    "\1\0\6\4\5\0\1\223\26\4\31\0\4\4\1\0"+
    "\6\4\5\0\17\4\1\224\7\4\31\0\4\4\1\0"+
    "\6\4\5\0\13\4\1\225\13\4\31\0\4\4\1\0"+
    "\6\4\5\0\2\4\1\226\24\4\46\0\1\163\61\0"+
    "\15\165\1\227\62\165\14\0\1\163\1\166\63\0\4\4"+
    "\1\0\6\4\5\0\2\4\1\230\24\4\31\0\4\4"+
    "\1\0\6\4\5\0\5\4\1\231\21\4\31\0\4\4"+
    "\1\0\6\4\5\0\1\232\26\4\31\0\4\4\1\0"+
    "\4\4\1\233\1\4\5\0\27\4\31\0\4\4\1\0"+
    "\6\4\5\0\13\4\1\234\13\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\235\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\15\4\1\236\11\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\237\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\240\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\241\6\4\1\242\16\4\31\0"+
    "\4\4\1\0\6\4\5\0\4\4\1\243\22\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\4\1\244\25\4\31\0"+
    "\4\4\1\0\4\4\1\245\1\4\5\0\27\4\31\0"+
    "\4\4\1\0\6\4\5\0\4\4\1\246\22\4\31\0"+
    "\4\4\1\0\6\4\5\0\12\4\1\247\14\4\31\0"+
    "\4\4\1\0\6\4\5\0\5\4\1\250\21\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\4\1\251\25\4\31\0"+
    "\4\4\1\0\6\4\5\0\3\4\1\252\23\4\31\0"+
    "\4\4\1\0\6\4\5\0\1\253\26\4\31\0\4\4"+
    "\1\0\6\4\5\0\2\4\1\254\24\4\31\0\4\4"+
    "\1\0\2\4\1\255\3\4\5\0\27\4\31\0\4\4"+
    "\1\0\6\4\5\0\1\256\26\4\31\0\4\4\1\0"+
    "\6\4\5\0\14\4\1\257\12\4\31\0\1\217\1\0"+
    "\2\217\1\0\2\217\4\63\5\0\1\217\2\0\1\217"+
    "\1\0\1\217\1\0\1\217\4\0\1\217\10\0\1\217"+
    "\32\0\4\4\1\0\6\4\5\0\1\4\1\260\25\4"+
    "\31\0\4\4\1\0\6\4\5\0\17\4\1\261\7\4"+
    "\31\0\4\4\1\0\6\4\5\0\12\4\1\262\14\4"+
    "\30\0\14\165\1\163\1\227\62\165\1\0\4\4\1\0"+
    "\6\4\5\0\14\4\1\263\12\4\31\0\4\4\1\0"+
    "\6\4\5\0\6\4\1\264\20\4\31\0\4\4\1\0"+
    "\6\4\5\0\4\4\1\265\22\4\31\0\4\4\1\0"+
    "\6\4\5\0\10\4\1\266\16\4\31\0\4\4\1\0"+
    "\6\4\5\0\4\4\1\267\22\4\31\0\4\4\1\0"+
    "\6\4\5\0\13\4\1\270\13\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\271\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\13\4\1\272\13\4\31\0\4\4\1\0"+
    "\6\4\5\0\7\4\1\273\17\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\274\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\275\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\2\4\1\276\24\4\31\0\4\4\1\0"+
    "\6\4\5\0\7\4\1\277\17\4\31\0\4\4\1\0"+
    "\2\4\1\300\3\4\5\0\27\4\31\0\4\4\1\0"+
    "\4\4\1\301\1\4\5\0\27\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\302\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\303\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\12\4\1\304\14\4\31\0\4\4\1\0"+
    "\6\4\5\0\5\4\1\305\21\4\31\0\4\4\1\0"+
    "\6\4\5\0\12\4\1\306\14\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\307\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\12\4\1\310\14\4\31\0\4\4\1\0"+
    "\6\4\5\0\12\4\1\311\14\4\31\0\4\4\1\0"+
    "\6\4\5\0\7\4\1\312\17\4\31\0\4\4\1\0"+
    "\6\4\5\0\1\4\1\313\25\4\31\0\4\4\1\0"+
    "\6\4\5\0\14\4\1\314\12\4\31\0\4\4\1\0"+
    "\1\315\5\4\5\0\27\4\31\0\4\4\1\0\6\4"+
    "\5\0\11\4\1\316\15\4\31\0\4\4\1\0\6\4"+
    "\5\0\5\4\1\317\21\4\31\0\4\4\1\0\2\4"+
    "\1\320\3\4\5\0\27\4\31\0\4\4\1\0\6\4"+
    "\5\0\13\4\1\321\13\4\31\0\4\4\1\0\6\4"+
    "\5\0\5\4\1\322\21\4\31\0\4\4\1\0\1\323"+
    "\5\4\5\0\27\4\31\0\4\4\1\0\6\4\5\0"+
    "\5\4\1\324\21\4\31\0\4\4\1\0\4\4\1\325"+
    "\1\4\5\0\27\4\31\0\4\4\1\0\6\4\5\0"+
    "\1\4\1\326\25\4\31\0\4\4\1\0\2\4\1\327"+
    "\3\4\5\0\27\4\31\0\4\4\1\0\6\4\5\0"+
    "\14\4\1\330\12\4\31\0\4\4\1\0\6\4\5\0"+
    "\4\4\1\331\22\4\31\0\4\4\1\0\6\4\5\0"+
    "\5\4\1\332\21\4\31\0\4\4\1\0\6\4\5\0"+
    "\5\4\1\333\21\4\30\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack();


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  9,  9,  9,  9,  1,  9,  9,  9,  9,  9, 
     9,  0,  1,  1,  9,  9,  9,  1,  1,  1,  0,  0,  1,  0,  0,  9, 
     9,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  9,  1,  9,  9,  9, 
     1,  9,  9,  9,  9,  9,  9,  9,  9,  9,  1,  0,  9,  1,  1,  1, 
     1,  1,  9,  1,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  9, 
     9,  9,  1,  1,  1,  1,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean yy_eof_done;

  /* user code: */

    ComplexSymbolFactory symbolFactory;
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
  
    private Symbol symbol(int sym) {
      return symbolFactory.newSymbol("sym", sym, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+yylength(),yychar+yylength()));
  }
  private Symbol symbol(int sym, Object val) {
      Location left = new Location(yyline+1,yycolumn+1,yychar);
      Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
      return symbolFactory.newSymbol("sym", sym, left, right,val);
  } 
  private Symbol symbol(int sym, Object val,int buflength) {
      Location left = new Location(yyline+1,yycolumn+yylength()-buflength,yychar+yylength()-buflength);
      Location right= new Location(yyline+1,yycolumn+yylength(), yychar+yylength());
      return symbolFactory.newSymbol("sym", sym, left, right,val);
  }
    
  //    static TreeSet typeset = new TreeSet();
    
    private int typecheck(String s){

	if (Parser.lookupType(s.trim())) {
	    return TYPE_NAME;
	}

	else {
	    return IDENTIFIER;
	}
	
    }
    


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[9728];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  final public void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  final public char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void yy_do_eof() throws java.io.IOException {
    if (!yy_eof_done) {
      yy_eof_done = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      yychar+= yy_markedPos_l-yy_startRead;

      boolean yy_r = false;
      for (yy_currentPos_l = yy_startRead; yy_currentPos_l < yy_markedPos_l;
                                                             yy_currentPos_l++) {
        switch (yy_buffer_l[yy_currentPos_l]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          yy_r = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          yy_r = true;
          break;
        case '\n':
          if (yy_r)
            yy_r = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          yy_r = false;
          yycolumn++;
        }
      }

      if (yy_r) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean yy_peek;
        if (yy_markedPos_l < yy_endRead_l)
          yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        else if (yy_atEOF)
          yy_peek = false;
        else {
          boolean eof = yy_refill();
          yy_markedPos_l = yy_markedPos;
          yy_buffer_l = yy_buffer;
          if (eof) 
            yy_peek = false;
          else 
            yy_peek = yy_buffer_l[yy_markedPos_l] == '\n';
        }
        if (yy_peek) yyline--;
      }
      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 10: 
          {  return symbol(MUL,"*");  }
        case 220: break;
        case 35: 
          {  return symbol(XOR,"^");  }
        case 221: break;
        case 36: 
          {  return symbol(OR,"|");  }
        case 222: break;
        case 37: 
          {  return symbol(NOT,"!");  }
        case 223: break;
        case 1: 
        case 26: 
        case 28: 
          {  System.err.println("Fehler: unbekanntes Zeichen:"+yytext()+" "+(yyline+1)+"/"+(yycolumn+1));  }
        case 224: break;
        case 48: 
          {  return symbol(COND,"?");  }
        case 225: break;
        case 47: 
          {  return symbol(TILDE,"~");  }
        case 226: break;
        case 44: 
          {  return symbol(PARAR,")");  }
        case 227: break;
        case 43: 
          {  return symbol(PARAL,"(");  }
        case 228: break;
        case 42: 
          {  return symbol(COLON,":");  }
        case 229: break;
        case 41: 
          {  return symbol(COMMA,",");  }
        case 230: break;
        case 38: 
          {  return symbol(SEMI,";");  }
        case 231: break;
        case 27: 
          {  return symbol(POINT,".");  }
        case 232: break;
        case 4: 
          {  return symbol(MINUS,"-");  }
        case 233: break;
        case 31: 
          {  return symbol(LESS,"<");  }
        case 234: break;
        case 32: 
          {  return symbol(PLUS,"+");  }
        case 235: break;
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 55: 
        case 56: 
        case 57: 
        case 60: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 80: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 109: 
        case 111: 
        case 112: 
        case 113: 
        case 118: 
        case 119: 
        case 120: 
        case 121: 
        case 122: 
        case 123: 
        case 124: 
        case 125: 
        case 126: 
        case 127: 
        case 128: 
        case 129: 
        case 130: 
        case 131: 
        case 132: 
        case 133: 
        case 134: 
        case 136: 
        case 137: 
        case 138: 
        case 139: 
        case 140: 
        case 141: 
        case 146: 
        case 148: 
        case 149: 
        case 152: 
        case 153: 
        case 154: 
        case 155: 
        case 158: 
        case 160: 
        case 161: 
        case 163: 
        case 164: 
        case 165: 
        case 166: 
        case 167: 
        case 168: 
        case 169: 
        case 170: 
        case 172: 
        case 173: 
        case 176: 
        case 178: 
        case 180: 
        case 181: 
        case 182: 
        case 183: 
        case 185: 
        case 186: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
        case 192: 
        case 194: 
        case 195: 
        case 196: 
        case 198: 
        case 200: 
        case 207: 
        case 208: 
        case 209: 
        case 211: 
        case 212: 
        case 214: 
          {  return symbol(typecheck(yytext()), yytext());  }
        case 236: break;
        case 199: 
          {  return symbol(EXTERN,yytext());  }
        case 237: break;
        case 205: 
          {  return symbol(SWITCH,yytext());  }
        case 238: break;
        case 174: 
          {  return symbol(VOID,yytext());  }
        case 239: break;
        case 64: 
          {  return symbol(MUL_ASSIGN,"*=");  }
        case 240: break;
        case 54: 
          {  return symbol(SUB_ASSIGN,"-=");  }
        case 241: break;
        case 202: 
          {  return symbol(STRUCT,yytext());  }
        case 242: break;
        case 201: 
          {  return symbol(STATIC,yytext());  }
        case 243: break;
        case 215: 
          {  return symbol(UNSIGNED,yytext());  }
        case 244: break;
        case 46: 
          {  return symbol(SQUAREDR,"]");  }
        case 245: break;
        case 45: 
          {  return symbol(SQUAREDL,"[");  }
        case 246: break;
        case 92: 
          {  return symbol(RIGHT_OP,">>");  }
        case 247: break;
        case 103: 
          {  return symbol(OR_ASSIGN,"|=");  }
        case 248: break;
        case 179: 
          {  return symbol(BREAK,yytext());  }
        case 249: break;
        case 210: 
          {  return symbol(TYPEDEF,yytext());  }
        case 250: break;
        case 206: 
          {  return symbol(DOUBLE,yytext());  }
        case 251: break;
        case 99: 
          {  return symbol(MOD_ASSIGN,"%=");  }
        case 252: break;
        case 102: 
          {  return symbol(XOR_ASSIGN,"^=");  }
        case 253: break;
        case 184: 
          {  return symbol(CONST,yytext());  }
        case 254: break;
        case 217: 
          {  return symbol(CONTINUE,yytext());  }
        case 255: break;
        case 51: 
        case 108: 
          {  return symbol(CONSTANT,yytext());  }
        case 256: break;
        case 2: 
        case 25: 
        case 50: 
          {  return symbol(CONSTANT,yytext());  }
        case 257: break;
        case 100: 
          {  return symbol(AND_ASSIGN,"&=");  }
        case 258: break;
        case 106: 
          {  return symbol(CONSTANT,yytext());  }
        case 259: break;
        case 142: 
          {  return symbol(CONSTANT,yytext());  }
        case 260: break;
        case 177: 
          {  return symbol(UNION,yytext());  }
        case 261: break;
        case 218: 
          {  return symbol(VOLATILE,yytext());  }
        case 262: break;
        case 96: 
          {  return symbol(LEFT_OP,"<<");  }
        case 263: break;
        case 143: 
          {  return symbol(ELLIPSIS,"...");  }
        case 264: break;
        case 147: 
          {  return symbol(LONG,yytext());  }
        case 265: break;
        case 175: 
          {  return symbol(FLOAT,yytext());  }
        case 266: break;
        case 204: 
          {  return symbol(SIZEOF,yytext());  }
        case 267: break;
        case 203: 
          {  return symbol(SIGNED,yytext());  }
        case 268: break;
        case 63: 
          {  return symbol(DIV_ASSIGN,"/=");  }
        case 269: break;
        case 135: 
          {  return symbol(INT,yytext());  }
        case 270: break;
        case 193: 
          {  return symbol(WHILE,yytext());  }
        case 271: break;
        case 187: 
          {  return symbol(SHORT,yytext());  }
        case 272: break;
        case 144: 
          {  return symbol(RIGHT_ASSIGN,">>=");  }
        case 273: break;
        case 216: 
          {  return symbol(REGISTER,yytext());  }
        case 274: break;
        case 91: 
          {  return symbol(STRING_LITERAL,yytext());  }
        case 275: break;
        case 171: 
          {  return symbol(GOTO,yytext());  }
        case 276: break;
        case 213: 
          {  return symbol(DEFAULT,yytext());  }
        case 277: break;
        case 110: 
          {  return symbol(FOR,yytext());  }
        case 278: break;
        case 145: 
          {  return symbol(LEFT_ASSIGN,"<<=");  }
        case 279: break;
        case 197: 
          {  return symbol(RETURN,yytext());  }
        case 280: break;
        case 156: 
          {  return symbol(ELSE,yytext());  }
        case 281: break;
        case 157: 
          {  return symbol(ENUM,yytext());  }
        case 282: break;
        case 97: 
          {  return symbol(ADD_ASSIGN,"+=");  }
        case 283: break;
        case 159: 
          {  return symbol(CASE,yytext());  }
        case 284: break;
        case 162: 
          {  return symbol(CHAR,yytext());  }
        case 285: break;
        case 151: 
          {  return symbol(AUTO,yytext());  }
        case 286: break;
        case 79: 
          {  return symbol(IF,yytext());  }
        case 287: break;
        case 53: 
          {  return symbol(PTR_OP,"->");  }
        case 288: break;
        case 52: 
          {  return symbol(DEC_OP,"--");  }
        case 289: break;
        case 40: 
          {  return symbol(CURLYR,"}");  }
        case 290: break;
        case 39: 
          {  return symbol(CURLYL,"{");  }
        case 291: break;
        case 9: 
          {  return symbol(DIVIDE,"/");  }
        case 292: break;
        case 29: 
          {  return symbol(GREATER,">");  }
        case 293: break;
        case 30: 
          {  return symbol(ASSIGN,"=");  }
        case 294: break;
        case 33: 
          {  return symbol(MODULUS,"%");  }
        case 295: break;
        case 34: 
          {  return symbol(ADRESS,"&");  }
        case 296: break;
        case 81: 
          {  return symbol(DO,yytext());  }
        case 297: break;
        case 93: 
          {  return symbol(GE_OP,">=");  }
        case 298: break;
        case 94: 
          {  return symbol(EQ_OP,"==");  }
        case 299: break;
        case 95: 
          {  return symbol(LE_OP,"<=");  }
        case 300: break;
        case 98: 
          {  return symbol(INC_OP,"++");  }
        case 301: break;
        case 101: 
          {  return symbol(AND_OP,"&&");  }
        case 302: break;
        case 104: 
          {  return symbol(OR_OP,"||");  }
        case 303: break;
        case 105: 
          {  return symbol(NE_OP,"!=");  }
        case 304: break;
        case 11: 
        case 12: 
          {  /* ignore bad characters */  }
        case 305: break;
        case 114: 
        case 115: 
          {   }
        case 306: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            yy_do_eof();
              {      return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,yycolumn+1,yychar), new Location(yyline+1,yycolumn+1,yychar+1));
 }
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
