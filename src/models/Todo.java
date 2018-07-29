package models;

import models.base.Item;
import models.enums.TodoState;

public class Todo extends Item {

  private TodoState state;

  public Todo(String title, String description, TodoState state) {
    super(title, description);
    setState(state);
  }

  public TodoState getState() {
    return state;
  }

  public void setState(TodoState state) {
    this.state = state;
  }
}
