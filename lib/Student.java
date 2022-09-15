public class Student extends Person implements Comparable<Student> {

  private String enrollmentState;
  private double selectiveProcessGrade;
  private int totalAttendances = 0;
  private int id = 0;

  Student(
    String name,
    String CPF,
    String enrollmentState,
    double selectiveProcessGrade,
    int id
  ) {
    super(name, CPF, id++);
    this.enrollmentState = enrollmentState;
    this.selectiveProcessGrade = selectiveProcessGrade;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEnrollmentState() {
    return enrollmentState;
  }

  public void setEnrollmentState(String enrollmentState) {
    this.enrollmentState = enrollmentState;
  }

  public double getSelectiveProcessGrade() {
    return selectiveProcessGrade;
  }

  public void setSelectiveProcessGrade(double selectiveProcessGrade) {
    this.selectiveProcessGrade = selectiveProcessGrade;
  }

  public int getTotalAttendances() {
    return this.totalAttendances;
  }

  public void setTotalAttendances(int totalAttendances) {
    this.totalAttendances = totalAttendances;
  }

  @Override
  public int compareTo(Student obj1) {
    Student that = (Student) obj1;
    Integer p1 = this.getTotalAttendances();
    Integer p2 = that.getTotalAttendances();

    if (p1 > p2) {
      return 1;
    } else if (p1 < p2) {
      return -1;
    } else return 0;
  }
}
