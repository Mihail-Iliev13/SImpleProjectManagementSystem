package models.enums;

public enum TicketPriority {
  HIGH_PRIORITY, LOW_PRIORITY;

  private static final String HIGH = "High";
  private static final String LOW = "Low";

  public static TicketPriority fromName(String name) {
    switch (name) {
      case HIGH:
        return HIGH_PRIORITY;
      case LOW:
        return LOW_PRIORITY;
      default:
        return null;
    }
  }
}
