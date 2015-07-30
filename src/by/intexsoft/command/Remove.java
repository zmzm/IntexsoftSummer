package by.intexsoft.command;

public class Remove implements Command {
    @Override
    public String execute(String par) {
        return "Выполняется команда " + par;
    }
}
