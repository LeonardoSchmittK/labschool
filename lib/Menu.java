public class Menu {

  private String title;
  private String subtitle;
  MenuOption[] options;
  String accesserDetail = ".";

  Menu(String title, MenuOption[] options) {
    this.title = title;
    this.options = options;
  }

  Menu(String title, String subtitle, MenuOption[] options) {
    this.title = title;
    this.options = options;
    this.subtitle = subtitle;
  }

  Menu(String title, MenuOption[] options, String accesserDetail) {
    this.accesserDetail = accesserDetail;
    this.title = title;
    this.options = options;
  }

  public void printOptions() {
    for (MenuOption option : this.options) {
      System.out.println(
        option.optionAcesser + this.accesserDetail + " " + option.optionName
      );
    }
  }

  public void printTitle(boolean withSubtitle) {
    System.out.println(this.title + "\n" + this.subtitle);
  }

  public void printTitle() {
    System.out.println(this.title);
  }

  public void printMenu() {
    this.printTitle();
    this.printOptions();
  }
}
