package services.base;

import models.enums.TicketPriority;
import models.enums.TodoState;
import models.base.Item;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProjectManagementSystem {

    void addTicket(String title, String description, LocalDate dueDate, TicketPriority ticketPriority, String sender, String owner);

    void addTodo(String title, String description, TodoState state);

    void addTask(String title, String description, LocalDate dueDate, TicketPriority ticketPriority, LocalDate plannedTime, String assignee);

    List<Item> listAll();

    List<Item> listTickets();

    List<Item> listTodos();

    List<Item> listTodos(TodoState state);

    List<Item> listTasks();

    List<Item> searchByTitleOrDescription(String pattern);

    void changeTodoState(String title, TodoState state);
}
