package by.intexsoft.command;

public class Find implements Command {
    @Override
    public String execute(String par) {
        return "Выполняется команда " + par;
    }
}
