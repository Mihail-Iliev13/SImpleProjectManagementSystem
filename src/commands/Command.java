package commands;


public class Command {
    private String[] params;
    private CommandType commandType;

    public Command(CommandType type, String[] params) {
        setCommandType(type);
        setParams(params);
    }

    public CommandType getCommandType() {
        return commandType;
    }

    private void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public String[] getParams() {
        return params;
    }

    private void setParams(String[] params) {
        this.params = params;
    }
}
