import com.sun.media.sound.InvalidDataException;
import commands.base.CommandParser;
import models.Task;
import models.Ticket;
import models.Todo;
import models.base.Item;
import models.enums.TicketPriority;
import services.base.ProjectManagementSystem;
import commands.Command;
import commands.CommandType;
import models.enums.TodoState;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    private final CommandParser commandParser;
    private ProjectManagementSystem system;

    public Application(CommandParser commandParser, ProjectManagementSystem system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String commandString = in.nextLine();
        Command command = commandParser.parseCommand(commandString);

      while (!command.getCommandType().equals(CommandType.EXIT)) {

            switch (command.getCommandType()) {
                case ADD_TODO:
                  handleAddTodo(command);
                    break;
                case ADD_TASK:
                  handleAddTask(command);
                    break;
                case ADD_TICKET:
                    handleAddTicket(command);
                    break;
                case LIST_ALL:
                    handleListAll();
                    break;
                case LIST_TASKS:
                  handleListTasks();
                    break;
                case LIST_TODOS:
                    handleListTodo();
                    break;
                case UPDATE_TODO:
                    handleUpdateTodo(command);
                    break;
                case LIST_TICKETS:
                    handleListTickets();
                    break;
                case LIST_TODOS_NOT_DONE:
                    handleTodosNotDone();
                    break;
            }

        commandString = in.nextLine();
        command = commandParser.parseCommand(commandString);
        }
    }

  private void handleTodosNotDone() {
      Predicate<Todo> notDone = todo -> todo.getState().equals(TodoState.NOT_DONE);
      system.listTodos().stream()
              .map(item -> (Todo)item)
              .filter(notDone)
              .forEach(x -> System.out.printf("Title: %s\nDescription: %s\nState: %s\n\n",
                      x.getTitle(), x.getDescription(), x.getState()));
  }

  private void handleUpdateTodo(Command command) {
      String title = command.getParams()[0];
      TodoState state = TodoState.fromName(command.getParams()[1]);
      system.changeTodoState(title, state);
      System.out.printf("%s's state has been changed to %s!", title, state);
    }

  private void handleListTickets() {
      system.listTickets().stream()
              .sorted(Comparator.comparing(Item::getTitle))
              .map(x -> (Ticket) x)
              .forEach(x -> System.out.printf("Title: %s\nDescription: %s\nDue date: %s\nPriority: %s\nSender %s\nOwner %s\n\n",
                      x.getTitle(), x.getDescription(), x.getDueDate().toString(), x.getPriority().toString().toLowerCase(),
                      x.getSender(), x.getOwner()));
  }

  private void handleListTodo() {
    system.listTodos().stream()
            .sorted(Comparator.comparing(Item::getTitle))
            .map(x -> (Todo)x)
            .forEach(x -> System.out.printf("Title: %s\nDescription: %s\nState: %s\n\n",
                    x.getTitle(), x.getDescription(), x.getState()));
  }

  private void handleListTasks() {
      system.listTasks().stream()
              .sorted(Comparator.comparing(Item::getTitle))
              .map(x -> (Task)x)
              .forEach(x -> System.out.printf("Title: %s\nDescription: %s" +
                              "\nDue date: %s\nPriority: %s\nPlanned time: %s\nAssignee: %s\n\n",
                      x.getTitle(), x.getDescription(), x.getDueDate().toString(),
                      x.getPriority().toString().toLowerCase(), x.getPlannedTime().toString(), x.getAssignee()));
  }

  private void handleListAll() {
      system.listAll().stream()
              .sorted(Comparator.comparing(Item::getTitle))
              .forEach(x -> System.out.printf("Title: %s\nDescription: %s\n\n", x.getTitle(), x.getDescription()));
  }

  private void handleAddTicket(Command command) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    String title = command.getParams()[0];
    String description = command.getParams()[1];
    LocalDate dueDate = LocalDate.parse(command.getParams()[2], formatter);
    TicketPriority priority = TicketPriority.fromName(command.getParams()[3]);
    String sender = command.getParams()[4];
    String owner = command.getParams()[5];
    system.addTicket(title, description, dueDate, priority, sender, owner);
    System.out.printf("Ticket with title (%s) is added successfully!\n",title);
  }

  private void handleAddTask(Command command) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    String title = command.getParams()[0];
    String description = command.getParams()[1];
    LocalDate dueDate = LocalDate.parse(command.getParams()[2], formatter);
    TicketPriority priority = TicketPriority.fromName(command.getParams()[3]);
    LocalDate plannedTime = LocalDate.parse(command.getParams()[4], formatter);
    String assignee = command.getParams()[5];
    system.addTask(title, description, dueDate, priority, plannedTime, assignee);
    System.out.printf("Task with title (%s) is added successfully!\n",title);

  }

  private void handleAddTodo(Command command) {
    String title = command.getParams()[0];
    String description = command.getParams()[1];
    String name;
    if(command.getParams().length > 3){
      name = command.getParams()[2] + " " +  command.getParams()[3];
    } else {
      name = command.getParams()[2];
    }

    TodoState state = TodoState.fromName(name);
    system.addTodo(title, description, state);
    System.out.printf("Todo with title (%s) is added successfully!\n",title);
  }

}
