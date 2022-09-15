public class Professor extends Person {

  private String academicEducation;
  private String devExperience;
  private boolean isActive = true;
  private int id = 0;

  Professor(
    String name,
    String CPF,
    String academicEducation,
    String devExperience,
    boolean isActive,
    int id
  ) {
    super(name, CPF, id++);
    this.academicEducation = academicEducation;
    this.devExperience = devExperience;
    this.isActive = isActive;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAcademicEducation() {
    return academicEducation;
  }

  public void setAcademicEducation(String academicEducation) {
    this.academicEducation = academicEducation;
  }

  public String getDevExperience() {
    return devExperience;
  }

  public void setDevExperience(String devExperience) {
    this.devExperience = devExperience;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }
}
