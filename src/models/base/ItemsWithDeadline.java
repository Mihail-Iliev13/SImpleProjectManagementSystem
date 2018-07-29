package models.base;


import models.enums.TicketPriority;

import java.time.LocalDate;

public class ItemsWithDeadline extends Item{

  private LocalDate dueDate;
  private TicketPriority priority;


  public ItemsWithDeadline(String title, String description, LocalDate dueDate, TicketPriority priority) {
    super(title, description);
    setDueDate(dueDate);
    setPriority(priority);
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  private void setDueDate(LocalDate dueDate) {

    LocalDate currentDate = LocalDate.now();
    if(dueDate.isBefore(currentDate)){
      System.out.println("This date is in the past");
    } else {
      this.dueDate = dueDate;
    }
  }

  public TicketPriority getPriority() {
    return priority;
  }

  private void setPriority(TicketPriority priority) {
    this.priority = priority;
  }
}
