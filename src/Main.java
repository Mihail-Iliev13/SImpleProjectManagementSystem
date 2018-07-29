import commands.base.CommandParser;

import services.base.ProjectManagementSystem;
import commands.CommandParserImpl;
import services.ProjectManagementSystemImpl;


public class Main {
    public static void main(String[] args) {
        CommandParser parser = new CommandParserImpl();
        ProjectManagementSystem system = new ProjectManagementSystemImpl();
        Application app = new Application(parser, system);
        app.run();

    }
}