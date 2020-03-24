package uvsq21807481;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
    }

    public void add(String name, Command cmd) {
        this.commands.put(name, cmd);
    }

    public void execute(String name) {
        if(this.commands.containsKey(name)) {
            this.commands.get(name).apply();
        }
    }

    public static CommandFactory init(MoteurRPN mrpn) {
        CommandFactory cf = new CommandFactory();
        cf.add("undo", new Undo(mrpn));
        cf.add("exit", new Exit(mrpn));
        cf.add("save", new Enregistrement(mrpn, 0));
        cf.add("compute", new Calcul(mrpn, Operation.PLUS));
        cf.add("list", new EnsembleOperandes(mrpn));
        return cf;
    }

    public void setVal(double val) {
        Enregistrement save;
        if(this.commands.containsKey("save")) {
            save = (Enregistrement)this.commands.get("save");
            save.enregistrerVal(val);
        }
    }

    public void setOperation(Operation op) {
        Calcul calcul;
        if(this.commands.containsKey("compute")) {
            calcul = (Calcul)this.commands.get("compute");
            calcul.selectOperation(op);
        }
    }
}
