package models.base;

public class Item {
  private String title;
  private String description;
  private static final int TITLE_MIN_LENGHT = 1;
  private static final int TITLE_MAX_LENGHT = 30;
  private static final int DESCRIPTION_MIN_LENGHT = 1;
  private static final int DESCRIPTION_MAX_LENGHT = 40;

  public Item(String title, String description){
  setTitle(title);
  setDescription(description);

  }

  public String getTitle() {
    return title;
  }

  private void setTitle(String title) {

    if (title.length() < TITLE_MIN_LENGHT || title.length() > TITLE_MAX_LENGHT){
      System.out.println("Invalid title");
    } else {
      this.title = title;
    }
  }

  public String getDescription() {
    return description;
  }

  private void setDescription(String description) {
    if (description.length() < DESCRIPTION_MIN_LENGHT || description.length() > DESCRIPTION_MAX_LENGHT){
      System.out.println("Invalid description");
    } else {
      this.description = description;
    }
  }
}
