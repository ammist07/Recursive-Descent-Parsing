import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main{
    private static int index = 0;
    private static int len = 0;
    public static void main(String[] args) {

        File in = new File("input.txt");
        File out = new File("output.txt");

        try (Scanner scan = new Scanner(in);
             PrintWriter pw = new PrintWriter(new FileWriter(out, true))) {

            while (scan.hasNext()) {
                String line = scan.nextLine();
                line = line.trim();
                len = line.length();
                index = 0;
                if(A(line)){
                    pw.println("The string \"" + line + "\" is in the language.");
                }else{
                    pw.println("The string \"" + line + "\" is not in the language.");
                }            
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }
    //A -> I = E
    private static boolean A(String l){
        if( index < len && I(l)){
            if( index < len && l.charAt(index++)=='='){
                if( index < len && E(l)){
                    return true;
                }
                
            }
        }
        return false;
    }
    //E -> P O P | P
    private static boolean E(String l){
        if(P(l)){
            if(O(l)){
                if(P(l)){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
    //O -> + | - | * | / | **
    private static boolean O(String l){
        if( (index < len && ( (l.charAt(index)=='+')) || (index < len && (l.charAt(index)=='-'))  || (index < len && (l.charAt(index)=='/')) ) ){
            index++;
            return true;
        }
        if(index < len && l.charAt(index)=='*'){
            index++;
            if(index < len && l.charAt(index)=='*'){
                index++;
                return true;
            }
            return true;
        }
        return false;
    }
    //P -> I | L | UI | UL | (E)
    private static boolean P(String l){
        if(I(l)){
            return true;
        }
        if(L(l)){
            return true;
        }
        if(U(l)){
            if(I(l)){
                return true;
            }
            if(L(l)){
                return true;
            }
            return false;
        }
        if(index < len && (l.charAt(index)=='(')){
            index++;
            if(E(l)){
                if(index < len && (l.charAt(index)==')')){
                    index++;
                    return true;
                }
            }
        }
        return false;
    }
    //U -> + | - | !
    private static boolean U(String l){
        if(index < len){
            if(l.charAt(index)=='+' || (l.charAt(index)=='-') || (l.charAt(index)=='!')){
                index++;
                return true;
            }
        }
        return false;
    }
    //I -> C | CI
    private static boolean I(String l){
        if(index < len && C(l)){
            if(index < len && I(l)){
                return true;
            }
            return true;
        }
        return false;
    }
    //C -> a | b | ... | y | z
    private static boolean C(String l){
        if(index < len ){
            if(l.charAt(index)>='a' && l.charAt(index)<='z'){
                index++;
                return true;
            }
        }
        return false;
    }
    //L -> D | DL
    private static boolean L(String l){
        if(index < len && D(l)){
            if(index < len && L(l)){
                return true;
            }
            return true;
        }
        return false;
    }
    //D -> 0 | 1 | ... | 8 | 9
    private static boolean D(String l){
        if(index < len){
            if(l.charAt(index)>='0'&&l.charAt(index)<='9'){
                index++;
                return true;
            }
        }
        return false;
    }
}

//<A> ::= <I> "=" <E>
//<E> ::= <P> <O> <P> | <P>
//<O> ::= "+" | "-" | "*" | "/" | "**"
//<P> ::= <I> | <L> | <U> <I> | <U> <L> | "(" <E> ")"
//<U> ::= "+" | "-" | "!"
//<I> ::= <C> | <C> <I>
//<C> ::=  "a" | "b" | "c" | "d" | "e" | "f" | "g" | "h" | "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z"
//<L> ::= <D> | <D> <L>
//<D> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"