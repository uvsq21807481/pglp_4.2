package uvsq21807481;

public class Enregistrement implements Command{

    private MoteurRPN mrpn;
    private double val;

    public Enregistrement(MoteurRPN mrpn, double val) {
        this.mrpn = mrpn;
        this.val = val;
    }

    public void enregistrerVal(double val) {
        this.val = val;
    }

    @Override
    public void apply() {
        this.mrpn.pile.push(val);
    }
}
