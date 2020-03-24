package uvsq21807481;

import java.util.Stack;

public class Interpreteur {
    private Stack<Double> pile;

    private Interpreteur() {
        this.pile = new Stack<Double>();
    }

    public void exit() {
        System.exit(0);
    }

    public void undo() {
        if(this.pile.size() > 0) {
            this.pile.pop();
        }
    }

}
