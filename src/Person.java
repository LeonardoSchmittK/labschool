abstract class Person {

  private String name;
  private String CPF;
  private int id;

  Person(String name, String CPF, int incrementedId) {
    this.name = name;
    this.CPF = CPF;
    this.id = incrementedId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

 
}
