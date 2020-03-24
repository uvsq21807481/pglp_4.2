package uvsq21807481;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {

    public MoteurRPN() {
        super();
    }

    public void enregistrement(double operande) {
        pile.push(operande);
    }

    public void calcul(Operation o) {
        double resultat;
        if(pile.size() > 1) {
            resultat = o.eval(pile.pop(), pile.pop());
            pile.push(resultat);
        }
    }

    public Stack<Double> getStack() {
        return this.pile;
    }
}
