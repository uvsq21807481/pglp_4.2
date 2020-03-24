package uvsq21807481;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SaisieRPN {

    private CommandFactory cf;
    private Scanner scan;
    private MoteurRPN mrpn;

    public SaisieRPN(MoteurRPN mrpn) {
        this.cf = new CommandFactory();
        cf = CommandFactory.init(mrpn);
        this.scan = new Scanner(System.in);
        this.mrpn = mrpn;
    }

    public void saisie() {
        String texte = new String();
        texte = this.scan.next();

        final String Digits     = "(\\p{Digit}+)";
        final String HexDigits  = "(\\p{XDigit}+)";
        // an exponent is 'e' or 'E' followed by an optionally
        // signed decimal integer.
        final String Exp        = "[eE][+-]?"+Digits;
        final String fpRegex    =
                ("[\\x00-\\x20]*"+ // Optional leading "whitespace"
                "[+-]?(" +         // Optional sign character
                "NaN|" +           // "NaN" string
                "Infinity|" +      // "Infinity" string

                // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
                "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

                // . Digits ExponentPart_opt FloatTypeSuffix_opt
                "(\\.("+Digits+")("+Exp+")?)|"+

                // Hexadecimal strings
                "((" +
               // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
                "(0[xX]" + HexDigits + "(\\.)?)|" +

                // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
                "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

                ")[pP][+-]?" + Digits + "))" +
                "[fFdD]?))" +
                "[\\x00-\\x20]*");// Optional trailing "whitespace"
        if(Pattern.matches(fpRegex, texte)) {
            this.cf.setVal(Double.parseDouble(texte));
            this.cf.execute("save");
        }
        else {
            boolean isOperation = false;
            for(Operation op : Operation.values()) {
                if(op.name().equals(texte)) {
                    isOperation = true;
                }
            }
            if(isOperation) {
                if(texte.equals("+")) {
                    this.cf.setOperation(Operation.PLUS);
                }
                else if(texte.equals("-")) {
                    this.cf.setOperation(Operation.MOINS);
                }
                else if(texte.equals("*")) {
                    this.cf.setOperation(Operation.MULT);
                }
                else {
                    this.cf.setOperation(Operation.DIV);
                }
                this.cf.execute("calcul");
            }
            else this.cf.execute(texte);
        }
    }
}
