package uvsq21807481;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {

    private final Map<String, Command> commands;

    private Interpreteur() {
        this.commands = new HashMap<>();
    }

    public void addCommand(String name, Command command) {
        this.commands.put(name, command);
    }

    public void executeCommand(String name) {
        if(this.commands.containsKey(name)) {
            this.commands.get(name).apply();
        }
    }

    public static Interpreteur init() {
        Interpreteur i = new Interpreteur();
        //Command list

        return i;
    }

}
