package models;

import models.base.ItemsWithDeadline;
import models.enums.TicketPriority;

import java.time.LocalDate;

public class Ticket extends ItemsWithDeadline {
  private String sender;
  private String owner;

  public Ticket(String title, String description, LocalDate dueDate, TicketPriority priority,
                String sender, String owner) {
    super(title, description, dueDate, priority);
    setSender(sender);
    setOwner(owner);
  }

  public String getSender() {
    return sender;
  }

  private void setSender(String sender) {
    this.sender = sender;
  }

  public String getOwner() {
    return owner;
  }

  private void setOwner(String owner) {
    this.owner = owner;
  }
}
