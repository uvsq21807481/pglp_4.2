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
        return cf;
    }
}
