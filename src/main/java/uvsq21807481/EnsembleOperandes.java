package uvsq21807481;

public class EnsembleOperandes implements Command{

    private MoteurRPN mrpn;

    public EnsembleOperandes(MoteurRPN mrpn) {
        this.mrpn = mrpn;
    }

    @Override
    public void apply() {
        this.mrpn.getStack();
    }
}
