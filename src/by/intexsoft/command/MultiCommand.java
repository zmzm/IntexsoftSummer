package by.intexsoft.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultiCommand implements Command {
    private Map map = new HashMap<String, Object>();
    private String command;

    MultiCommand (Map map, String command){
        this.map = map;
        this.command = command;
    }

    public String getCommand() {
        String com = "";
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry<String, Object> pair : entrySet) {
            if (command.equals(pair.getKey())) {
                com = pair.getKey();
            }
        }
        return com;
    }

    @Override
    public String execute(String par) {
        if(par.equals("add"))
            return (new Add().execute(par));
        else if (par.equals("find"))
            return (new Find().execute(par));
        else
            return (new Remove().execute(par));
    }
}
