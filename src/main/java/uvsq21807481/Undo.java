package uvsq21807481;

public class Undo implements Command{
    private Interpreteur itp;

    public Undo(Interpreteur itp) {
        this.itp = itp;
    }

    @Override
    public void apply() {
        this.itp.undo();
    }
}
