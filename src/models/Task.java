package models;

import models.base.ItemsWithDeadline;
import models.enums.TicketPriority;

import java.time.LocalDate;

public class Task extends ItemsWithDeadline {

  private String assignee;
  private LocalDate plannedTime;

  public Task(String title, String description, LocalDate dueDate, TicketPriority priority,
              LocalDate plannedTime, String assignee) {

    super(title, description, dueDate, priority);
    setAssignee(assignee);
    setPlannedTime(plannedTime);
  }

  public LocalDate getPlannedTime() {
    return plannedTime;
  }

  private void setPlannedTime(LocalDate plannedTime) {
    LocalDate currentDate = LocalDate.now();
    if(plannedTime.isBefore(currentDate)){
      System.out.println("This date is in the past");
    } else {
      this.plannedTime = plannedTime;
    }
  }

  public String getAssignee() {
    return assignee;
  }

  private void setAssignee(String assignee) {
    this.assignee = assignee;
  }
}
