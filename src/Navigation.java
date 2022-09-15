import java.util.ArrayList;

public class Navigation {

  ArrayList<Menu> menus = new ArrayList<Menu>();

  public void addMenu(Menu menu) {
    this.menus.add(menu);
  }

  public void printMenusTitles() {
    for (Menu menu : this.menus) {
      menu.printTitle();
    }
  }

  public Menu getPreviousMenu() {
    if (this.menus.size() <= 1) {
      return this.menus.get(0);
    }

    this.removeLastMenu();
    return this.menus.get(this.menus.size() - 1);
  }

  private void removeLastMenu() {
    this.menus.remove(this.menus.size() - 1);
  }

  public void reset() {
    this.menus.clear();
  }
}
