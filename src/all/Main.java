package all;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

public class Main {

	public static void main(String[] args) {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/";

        String sourcecode = rootPath + subPath + "src/all/" + "input.c";
        
        Lexer p = null;
        
        SymbolFactory symbolFactory = new ComplexSymbolFactory();

        try {
            p = new Lexer(new BufferedReader(new FileReader(sourcecode)), (ComplexSymbolFactory) symbolFactory);

            System.out.println("Compilacao concluida com sucesso...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		Parser parser1 = new Parser(p, symbolFactory);
		
		Symbol s = null;
		Symbol s2 = null;
		try {
			s = parser1.parse();
			System.out.println("The compilation process was successfully finished!");
		} catch (Exception e) {
			System.out.println("flopou");
			System.out.println(e.getMessage());
		}
    }

}
