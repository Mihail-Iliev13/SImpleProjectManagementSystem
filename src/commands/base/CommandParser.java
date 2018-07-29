package commands.base;

import commands.Command;

public interface CommandParser {
    Command parseCommand(String commandString);
}
