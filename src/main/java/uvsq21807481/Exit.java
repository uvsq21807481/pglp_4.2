package uvsq21807481;

public class Exit implements Command{

    private Interpreteur itp;

    public Exit(Interpreteur itp) {
        this.itp = itp;
    }

    @Override
    public void apply() {
        this.itp.exit();
    }
}
