package by.intexsoft.command;

public class Add implements Command{
    @Override
    public String execute(String par) {
        return "Выполняется команда " + par;
    }
}
