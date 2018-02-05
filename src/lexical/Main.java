package lexical;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            parser p = new parser(new Lexer(new FileReader(argv[0])));
            Object result = p.parse().value;
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
