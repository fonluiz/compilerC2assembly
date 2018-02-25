import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

public class Driver {

	public static void main(String[] args) {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/";

        String sourcecode = rootPath + subPath + "input.c";
        
        Lexer p = null;
        
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

        try {
            p = new Lexer(new BufferedReader(new FileReader(sourcecode)), symbolFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		Parser parser = new Parser(p, symbolFactory);
		
		Symbol s = null;
		try {
			s = parser.parse();
			System.out.println("The compilation process was successfully finished!");
		} catch (Exception e) {
			System.out.println("Compilation failed");
			System.out.println(e.getMessage());
		}
    }

}