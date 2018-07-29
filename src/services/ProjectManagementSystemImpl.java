package services;

import com.sun.xml.internal.bind.v2.TODO;
import models.Task;
import models.Ticket;
import models.Todo;
import services.base.ProjectManagementSystem;
import models.enums.TicketPriority;
import models.enums.TodoState;
import models.base.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {
  private static ArrayList<Item> all;
  private static ArrayList<Task> tasks;
  private static ArrayList<Ticket> tickets;
  private static ArrayList<Todo> todos;

  static {
    all = new ArrayList<>();
    tasks = new ArrayList<>();
    tickets = new ArrayList<>();
    todos = new ArrayList<>();
  }

  @Override
  public void addTicket(String title, String description, LocalDate dueDate,
                        TicketPriority ticketPriority, String sender, String owner) {
    Ticket ticket = new Ticket(title, description, dueDate, ticketPriority, sender, owner);
    tickets.add(ticket);
    all.add(ticket);
  }

  @Override
  public void addTodo(String title, String description, TodoState state) {
    Todo todo = new Todo(title, description, state);
    todos.add(todo);
    all.add(todo);
  }

  @Override
  public void addTask(String title, String description, LocalDate dueDate, TicketPriority ticketPriority,
                      LocalDate plannedTime, String assignee) {
    Task task = new Task(title, description, dueDate, ticketPriority, plannedTime, assignee);
    tasks.add(task);
    all.add(task);
  }

  @Override
  public List<Item> listAll() {
    return new ArrayList<>(all);
  }

  @Override
  public List<Item> listTickets() {
    return new ArrayList<>(tickets);
  }

  @Override
  public List<Item> listTodos() {
    return todos.stream().sorted(Comparator.comparing(Item::getTitle)).collect(Collectors.toList());
  }

  @Override
  public List<Item> listTodos(TodoState state) {
    return new ArrayList<>(todos);
  }

  @Override
  public List<Item> listTasks() {
    return new ArrayList<>(tasks);
  }

  @Override
  public List<Item> searchByTitleOrDescription(String pattern) {
   return all.stream().filter(x -> x.getTitle().equals(pattern)
           || x.getDescription().equals(pattern))
            .sorted(Comparator.comparing(Item::getTitle))
            .collect(Collectors.toList());
  }

  @Override
  public void changeTodoState(String title, TodoState state) {

    for (Todo todo : todos) {

      if(todo.getTitle().equals(title)){
        todo.setState(state);
      }
    }
  }
}
