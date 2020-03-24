package uvsq21807481;

public class Calcul implements Command{

    private MoteurRPN mrpn;
    private Operation op;

    public Calcul(MoteurRPN mrpn, Operation op) {
        this.mrpn = mrpn;
        this.op = op;
    }

    public void selectOperation(Operation op) {
        this.op = op;
    }

    @Override
    public void apply() {
        double resultat = 0;
        if(this.mrpn.pile.size() > 1) {
            resultat = op.eval(this.mrpn.pile.pop(), this.mrpn.pile.pop());
            this.mrpn.enregistrement(resultat);
        }
    }
}
