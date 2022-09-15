public class Pedagogue extends Person {

  private int totalAttendances = 0;
  private int id = 0;

  Pedagogue(String name, String CPF, int id) {
    super(name, CPF, id++);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTotalAttendances() {
    return totalAttendances;
  }

  public void setTotalAttendances(int totalAttendances) {
    this.totalAttendances = totalAttendances;
  }
}
