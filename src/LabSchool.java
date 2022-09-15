import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LabSchool {

  int studentCounter = 0;
  int professorCounter = 0;
  int pedagogueCounter = 0;
  String logo = "L A B  S C H O O L";
  String terminalValue;
  Student actualStudent;
  Navigation navigation = new Navigation();
  ArrayList<Student> students = new ArrayList<Student>();
  ArrayList<Professor> professors = new ArrayList<Professor>();
  ArrayList<Pedagogue> pedagogues = new ArrayList<Pedagogue>();

  enum devExperience {
    FRONT_END,
    BACK_END,
    FULL_STACK,
  }

  // initial menu
  MenuOption[] initialMenuOptions = new MenuOption[] {
    new MenuOption(
      "CADASTRO",
      "1",
      "register a new professor, student or pedagogue"
    ),
    new MenuOption("RELATORIO", "2", "access a bunch of reports"),
    new MenuOption("ALTERACAO DE CADASTRO", "3", "change a registration value"),
  };
  Menu initialMenu = new Menu("O QUE DESEJA ACESSAR?", initialMenuOptions);

  // register menu
  MenuOption[] registerMenuOptions = new MenuOption[] {
    new MenuOption("ALUNO", "1", "register a new student"),
    new MenuOption("PROFESSOR", "2", "register a new professor"),
    new MenuOption("PEDAGOGO", "3", "register a new pedagogue"),
    new MenuOption("ATENDIMENTO PEDAGOGICO", "4", "register a new attendance"),
    new MenuOption("VOLTAR A PAGINA INICIAL", "<", "go back to initial page"),
  };
  Menu registerMenu = new Menu("O QUE DESEJA CADASTRAR?", registerMenuOptions);

  // new value registration student

  MenuOption[] changeRegistrationValueOptions = new MenuOption[] {
    new MenuOption("ALUNO", "1", "change a student registration value"),
    new MenuOption("VOLTAR A PAGINA INICIAL", "<", "go back to initial page"),
  };
  Menu changeRegistrationValueMenu = new Menu(
    "O QUE DESEJA MUDAR?",
    changeRegistrationValueOptions
  );

  // register student menus

  MenuOption[] registerStudentNameOptions = new MenuOption[] {
    new MenuOption("", "", "get name of student"),
  };
  Menu registerStudentNameMenu = new Menu(
    "DIGITE O NOME DO ALUNO:",
    registerStudentNameOptions,
    ""
  );

  MenuOption[] registerStudentEnrollOptions = new MenuOption[] {
    new MenuOption("ATIVO", "1", "get the enrollment situation of student"),
    new MenuOption("IRREGULAR", "2", "get the enrollment situation of student"),
    new MenuOption(
      "ATENDIMENTO PEDAGOGICO",
      "3",
      "get the enrollment situation of student"
    ),
    new MenuOption("INATIVO", "4", "get the enrollment situation of student"),
    new GoBackOption("<"),
  };
  Menu registerStudentEnrollmentMenu = new Menu(
    "SELECIONE O ESTADO DE MATRICULA DO ALUNO:",
    registerStudentEnrollOptions
  );

  MenuOption[] registerStudentGradeOptions = new MenuOption[] {
    new MenuOption("", "", "get the grade of student"),
  };
  Menu registerStudentGradeMenu = new Menu(
    "DIGITE A NOTA DO ALUNO DE 0 A 10:",
    registerStudentGradeOptions,
    ""
  );

  // register professor
  MenuOption[] registerProfessorNameOptions = new MenuOption[] {
    new MenuOption("", "", "get name of professor"),
  };
  Menu registerProfessorNameMenu = new Menu(
    "DIGITE O NOME DO PROFESSOR:",
    registerProfessorNameOptions,
    ""
  );

  MenuOption[] registerProfessorAcademicOptions = new MenuOption[] {
    new MenuOption(
      "GRADUACAO INCOMPLETA",
      "1",
      "get academic situation of professor"
    ),
    new MenuOption(
      "GRADUACAO COMPLETA",
      "2",
      "get academic situation of professor"
    ),
    new MenuOption("MESTRADO", "3", "get academic situation of professor"),
    new MenuOption("DOUTORADO", "4", "get academic situation of professor"),
    new GoBackOption("<"),
  };
  Menu registerProfessorAcademicMenu = new Menu(
    "SELECIONE O NIVEL DE FORMACAO DO PROFESSOR:",
    registerProfessorAcademicOptions
  );

  MenuOption[] registerProfessorDevXpOptions = new MenuOption[] {
    new MenuOption(
      devExperience.FRONT_END + "",
      "1",
      "get the dev experience of professor"
    ),
    new MenuOption(
      devExperience.BACK_END + "",
      "2",
      "get the dev experience of professor"
    ),
    new MenuOption(
      devExperience.FULL_STACK + "",
      "3",
      "get the dev experience of professor"
    ),
    new GoBackOption("<"),
  };
  Menu registerProfessorDevXpMenu = new Menu(
    "SELECIONE A EXPERIENCIA EM DESENVOLVIMENTO DO PROFESSOR:",
    registerProfessorDevXpOptions,
    ""
  );

  MenuOption[] registerProfessorActivitypOptions = new MenuOption[] {
    new MenuOption("ATIVO", "1", "get the activity situation of professor"),
    new MenuOption("INATIVO", "2", "get the activity situation of professor"),
    new GoBackOption("<"),
  };
  Menu registerProfessorActivityMenu = new Menu(
    "SELECIONE A ATIVIDADE DO PROFESSOR:",
    registerProfessorActivitypOptions,
    ""
  );

  // pedagogues menu

  MenuOption[] registerPedagogueNameOptions = new MenuOption[] {
    new MenuOption("", "", "get the name of pedagogue"),
  };
  Menu registerPedagogueNameMenu = new Menu(
    "QUAL O NOME DO PEDAGOGO:",
    registerPedagogueNameOptions,
    ""
  );

  // experience level menu
  MenuOption[] accessExperienceDevMenuOptions = new MenuOption[] {
    new MenuOption(
      devExperience.FRONT_END + "",
      "1",
      "get the front-end professors"
    ),
    new MenuOption(
      devExperience.BACK_END + "",
      "2",
      "get the back-end professors"
    ),
    new MenuOption(
      devExperience.FULL_STACK + "",
      "3",
      "get the full-stack professors"
    ),
    new GoBackOption("<"),
  };
  Menu accessExperienceDevMenu = new Menu(
    "QUAL CATEGORIA DE EXPERIENCIA FILTRAR:",
    accessExperienceDevMenuOptions,
    ""
  );

  // listing attendances

  MenuOption[] accessAttendancesListingOptions = new MenuOption[] {
    new MenuOption(
      "ALUNOS COM MAIS ATENDIMENTOS",
      "1",
      "get the students with most attendances"
    ),
    new MenuOption(
      "PEDAGOGOS COM MAIS ATENDIMENTOS",
      "2",
      "get the pedagogues with most attendances"
    ),
    new GoBackOption("<"),
  };
  Menu accessAttendancesListingMenu = new Menu(
    "QUAL LISTAGEM DESEJA ACESSAR?",
    accessAttendancesListingOptions,
    ""
  );

  // reports menu

  MenuOption[] reportsMenuOptions = new MenuOption[] {
    new MenuOption("LISTAR ALUNOS", "1", "access students listing menu"),
    new MenuOption(
      "NOMES DOS PROFESSORES CADASTRADOS",
      "2",
      "print all professors names"
    ),
    new MenuOption(
      "NOMES DOS PEDAGOGOS CADASTRADOS",
      "3",
      "print all pedagogues names"
    ),
    new MenuOption(
      "NOMES DOS PROFESSORES POR EXPERIENCIA DEV",
      "4",
      "access menu of filter professors experience"
    ),
    new MenuOption(
      "LISTAR POR ATENDIMENTOS PEDAGOGICOS",
      "5",
      "access attendances listing menu"
    ),
    new MenuOption("VOLTAR A PAGINA INICIAL", "6", "go back to initial page"),
  };
  Menu reportsMenu = new Menu(
    "QUAL RELATORIO DESEJA ACESSAR:",
    reportsMenuOptions
  );

  // get id of student and pedagogue for register new attendance

  MenuOption[] registerNewAttendanceStudentIdOptions = new MenuOption[] {
    new MenuOption("", "", "get student id for register attendance"),
  };

  Menu registerNewAttendanceStudentIdMenu = new Menu(
    "QUAL O ID DO ALUNO?: ",
    registerNewAttendanceStudentIdOptions,
    ""
  );

  MenuOption[] registerNewAttendancePedagogueIdOptions = new MenuOption[] {
    new MenuOption("", "", "get pedagogue id for register attendance"),
  };

  Menu registerNewAttendancePedagogueIdMenu = new Menu(
    "QUAL O ID DO PEDAGOGO?: ",
    registerNewAttendancePedagogueIdOptions,
    ""
  );

  // students listing

  MenuOption[] getStudentsByCategoryOptions = new MenuOption[] {
    new MenuOption("NOME", "1", "print all students names"),
    new MenuOption("CPF", "2", "print all students cpf"),
    new GoBackOption("<"),
  };
  Menu getStudentsByCategoryMenu = new Menu(
    "QUAL CATEGORIA LISTAR OS ALUNOS:",
    getStudentsByCategoryOptions
  );

  //   register student CPF

  MenuOption[] registerStudentCPFMenuOptions = new MenuOption[] {
    new MenuOption("", "", "register student CPF"),
  };
  Menu registerStudentCPFMenu = new Menu(
    "QUAL O CPF DO ALUNO:",
    registerStudentCPFMenuOptions,
    ""
  );

  //   register professor CPF

  MenuOption[] registerProfessorCPFMenuOptions = new MenuOption[] {
    new MenuOption("", "", "register professor CPF"),
  };
  Menu registerProfessorCPFMenu = new Menu(
    "QUAL O CPF DO PROFESSOR:",
    registerProfessorCPFMenuOptions,
    ""
  );

  //   register pedagogue CPF

  MenuOption[] registerPedagogueCPFMenuOptions = new MenuOption[] {
    new MenuOption("", "", "register pedagogue CPF"),
  };
  Menu registerPedagogueCPFMenu = new Menu(
    "QUAL O CPF DO PEDAGOGO:",
    registerPedagogueCPFMenuOptions,
    ""
  );

  // get student id menu

  MenuOption[] getStudentIdMenuOptions = new MenuOption[] {
    new MenuOption("", "", "get student id"),
  };
  Menu getStudentIdMenu = new Menu(
    "QUAL O ID DO ALUNO:",
    getStudentIdMenuOptions,
    ""
  );

  // accept or deny attendance registration menu

  MenuOption[] acceptAttendanceRegistrationOptions = new MenuOption[] {
    new MenuOption("SIM", "1", "accept attendance registration"),
    new MenuOption("NAO", "2", "return to the initial page"),
  };
  Menu acceptAttendanceRegistrationMenu = new Menu(
    "",
    acceptAttendanceRegistrationOptions
  );

  // press ok to follow ahead menu

  MenuOption[] pressOkMenuOptions = new MenuOption[] {
    new MenuOption("Ok", "1", "return to the initial page"),
  };
  Menu pressOkMenu = new Menu("RETORNAR A PAGINA INICIAL", pressOkMenuOptions);

  // methods

  public void initSession() throws InterruptedException {
    this.printLoading();
    this.printSalute();
    this.printMenuAndAwaitForScannerResponse(this.initialMenu);
  }

  public void printSalute() {
    System.out.println("SEJA BEM-VINDO(A) AO TERMINAL DA LABSCHOOL !!");
  }

  public String printMenuAndAwaitForScannerResponse(Menu menu) {
    menu.printMenu();
    return this.awaitForScannerResponse(menu, new Scanner(System.in));
  }

  private String printMenuAndAwaitForScannerWhateverResponse(Menu menu) {
    menu.printMenu();
    return awaitForScannerWhateverResponse(menu, new Scanner(System.in));
  }

  private double printMenuAndAwaitForScannerWhateverDoubleTypeResponse(
    Menu menu
  ) {
    menu.printMenu();
    return awaitForScannerWhateverDoubleResponse(menu, new Scanner(System.in));
  }

  public double awaitForScannerWhateverDoubleResponse(
    Menu menu,
    Scanner scanner
  ) {
    while (scanner.hasNextDouble()) {
      double response = scanner.nextDouble();

      if (!String.valueOf(response).isEmpty()) {
        return response;
      }

      Utils.clearTerminal();
      System.out.println("Digite um numero correto");
      printMenuAndAwaitForScannerWhateverDoubleTypeResponse(menu);
    }
    Utils.clearTerminal();
    System.out.println("Digite um numero correto");
    awaitForScannerResponse(menu, scanner);

    printMenuAndAwaitForScannerWhateverDoubleTypeResponse(menu);

    return 0;
  }

  public String awaitForScannerResponse(Menu menu, Scanner scanner) {
    while (scanner.hasNextLine()) {
      String response = scanner.nextLine();
      for (MenuOption option : menu.options) {
        if (option.optionAcesser.equals(response)) {
          Utils.clearTerminal();
          checkFunctionalityChosenInMenu(menu, option);
          return option.optionName; // do not follow ahead if the accesser exists in menu
        }
      }
      Utils.clearTerminal();
      System.out.println("Escolha uma opcao correta");
      printMenuAndAwaitForScannerResponse(menu);
    }
    awaitForScannerResponse(menu, scanner);

    return "";
  }

  public String awaitForScannerWhateverResponse(Menu menu, Scanner scanner) {
    while (scanner.hasNextLine()) {
      String response = scanner.nextLine();
      if (!response.isEmpty()) {
        terminalValue = response;
        System.out.println("RESPOSTA: " + response);
        Utils.clearTerminal();

        return response;
      }

      Utils.clearTerminal();
      this.returnToPreviousMenu();
    }
    Utils.clearTerminal();
    this.returnToPreviousMenu();

    return "";
  }

  public void checkFunctionalityChosenInMenu(Menu menu, MenuOption option) {
    navigation.addMenu(menu);
    String optionDescription = option.description;

    switch (optionDescription) {
      case "change enrollment situation":
        this.changeStudentEnrollmentSituation();
      case "go back to initial page":
        this.goToInitialPage();
      case "change a student registration value":
        this.changeStudentRegistrationValue();
      case "change a registration value":
        this.changeRegistrationValue();
      case "get the students with most attendances":
        this.getStudentsWithMostAttendances();
      case "get the pedagogues with most attendances":
        this.getPedagoguesWithMostAttendances();
      case "access attendances listing menu":
        this.accessAttendancesListingMenu();
      case "register a new attendance":
        this.registerNewAttendance();
      case "access students listing menu":
        this.accessStudentsListingMenu();
      case "register a new professor, student or pedagogue":
        this.registerNewEntity();
      case "register a new student":
        this.registerNewStudent();
      case "register a new professor":
        this.registerNewProfessor();
      case "register a new pedagogue":
        this.registerNewPedagogue();
      case "access a bunch of reports":
        this.accessReportsMenu();
      case "print all students names":
        this.printAllStudentsName();
      case "access menu of filter professors experience":
        this.accessExperienceDevMenu();
      case "get the full-stack professors":
        this.getProfessorByExperience(devExperience.FULL_STACK);
      case "get the front-end professors":
        this.getProfessorByExperience(devExperience.FRONT_END);
      case "get the back-end professors":
        this.getProfessorByExperience(devExperience.BACK_END);
      case "print all professors names":
        this.printAllProfessorsName();
      case "print all pedagogues names":
        this.printAllPedagoguesName();
      case "print all students cpf":
        this.printAllStudentsCPF();
      case "print all professors cpf":
        this.printAllProfessorsCPF();
      case "print all pedagogues cpf":
        this.printAllPedagoguesCPF();
      case "return to the previous menu":
        this.returnToPreviousMenu();
      default:
        System.out.printf("");
    }
  }

  public void changeStudentEnrollmentSituation() {
    String situation =
      this.printMenuAndAwaitForScannerResponse(
          this.registerStudentEnrollmentMenu
        );
    System.out.println(situation);
    this.students.get(this.actualStudent.getId() - 1)
      .setEnrollmentState(situation);
    for (Student student : this.students) {
      System.out.println(
        student.getName() + "    " + student.getEnrollmentState()
      );
    }
    Utils.printWarningMessage("NOVO VALOR REGISTRADO COM SUCESSO", "*");

    this.finishProgressStep();
  }

  public void goToInitialPage() {
    navigation.reset();
    this.printMenuAndAwaitForScannerResponse(this.initialMenu);
  }

  public void changeStudentRegistrationValue() {
    double idStudentDouble =
      this.printMenuAndAwaitForScannerWhateverDoubleTypeResponse(
          this.getStudentIdMenu
        );
    int idStudentInt = (int) idStudentDouble;

    if (this.students.size() == 0) {
      Utils.printWarningMessage("NAO HA ESTUDANTES CADASTRADO", "=");
      this.finishProgressStep();
    }
    Student givenStudent = this.students.get(0); // default
    int counter = 0;

    for (Student student : this.students) {
      if (student.getId() == idStudentInt) {
        givenStudent = student;
        this.actualStudent = student;
        counter++;
      }
    }

    if (counter == 0) {
      Utils.printWarningMessage("NAO HA ESTUDANTE CADASTRADO COM ESSE ID", "=");
      this.finishProgressStep();
    }
    final String title =
      "O QUE DESEJA MUDAR NO ALUNO: " + givenStudent.getName();

    MenuOption[] getStudentsWantedChangeOptions = new MenuOption[] {
      new MenuOption(
        "SITUACAO DE MATRICULA",
        "1",
        "change enrollment situation"
      ),
      new GoBackOption("<"),
    };
    Menu getStudentsWantedChangeMenu = new Menu(
      title,
      getStudentsWantedChangeOptions
    );

    this.printMenuAndAwaitForScannerResponse(getStudentsWantedChangeMenu);
  }

  public void changeRegistrationValue() {
    this.printMenuAndAwaitForScannerResponse(this.changeRegistrationValueMenu);
  }

  public void getStudentsWithMostAttendances() {
    if (this.students.size() < 1) {
      Utils.printWarningMessage("NAO HA ESTUDANTES", "=");
      this.printMenuAndAwaitForScannerResponse(this.pressOkMenu);
      navigation.reset();
      this.printMenuAndAwaitForScannerResponse(this.initialMenu);
    }
    System.out.println("ESTUDANTES COM MAIS ENCONTROS PEDAGOGICOS");

    ArrayList<Student> studentsListUnsorted = this.students;

    Collections.sort(
      studentsListUnsorted,
      (a, b) ->
        a.getTotalAttendances() > b.getTotalAttendances()
          ? -1
          : a.getTotalAttendances() == b.getTotalAttendances() ? 1 : 0
    );

    for (Student student : studentsListUnsorted) {
      System.out.println(
        "NOME: " +
        student.getName() +
        " ATENDIMENTOS: " +
        student.getTotalAttendances()
      );
    }

    this.finishProgressStep();
  }

  public void getPedagoguesWithMostAttendances() {
    if (this.pedagogues.size() < 1) {
      Utils.printWarningMessage("NAO HA PEDAGOGOS", "=");
      this.finishProgressStep();
    }
    System.out.println("PEDAGOGOS COM MAIS ENCONTROS PEDAGOGICOS");

    ArrayList<Pedagogue> pedagoguesListUnsorted = this.pedagogues;

    Collections.sort(
      pedagoguesListUnsorted,
      (a, b) ->
        a.getTotalAttendances() > b.getTotalAttendances()
          ? -1
          : a.getTotalAttendances() == b.getTotalAttendances() ? 1 : 0
    );

    for (Pedagogue student : pedagoguesListUnsorted) {
      System.out.println(
        "NOME: " +
        student.getName() +
        " ATENDIMENTOS: " +
        student.getTotalAttendances()
      );
    }

    this.finishProgressStep();
  }

  public void accessAttendancesListingMenu() {
    this.printMenuAndAwaitForScannerResponse(this.accessAttendancesListingMenu);
  }

  public void registerNewAttendance() {
    double idStudentDouble =
      this.printMenuAndAwaitForScannerWhateverDoubleTypeResponse(
          this.registerNewAttendanceStudentIdMenu
        );
    int idStudentInt = (int) idStudentDouble;
    Utils.clearTerminal();

    double idPedagogueDouble =
      this.printMenuAndAwaitForScannerWhateverDoubleTypeResponse(
          this.registerNewAttendancePedagogueIdMenu
        );
    int idPedagogueInt = (int) idPedagogueDouble;

    Utils.clearTerminal();

    String studentNameWithGivenId = "";
    String pedagogueNameWithGivenId = "";
    Pedagogue pedagogueWithGivenId;
    Student studentWithGivenId;
    for (Student student : this.students) {
      if (student.getId() == idStudentInt) {
        studentNameWithGivenId = student.getName();
        studentWithGivenId = student;
      }
    }
    for (Pedagogue pedagogue : this.pedagogues) {
      if (pedagogue.getId() == idPedagogueInt) {
        pedagogueNameWithGivenId = pedagogue.getName();
        pedagogueWithGivenId = pedagogue;
      }
    }

    if (
      !pedagogueNameWithGivenId.isEmpty() && !studentNameWithGivenId.isEmpty()
    ) {
      System.out.println(
        "DESEJA CADASTRAR O ATENDIMENTO ENTRE O ALUNO " +
        studentNameWithGivenId +
        " E O PEDAGOGO " +
        pedagogueNameWithGivenId +
        "?"
      );
      String userAnswerToAccept =
        this.printMenuAndAwaitForScannerResponse(
            acceptAttendanceRegistrationMenu
          );

      if (userAnswerToAccept.equals("SIM")) {
        for (Pedagogue pedagogue : this.pedagogues) {
          if (pedagogue.getId() == idPedagogueInt) {
            pedagogue.setTotalAttendances(pedagogue.getTotalAttendances() + 1);
          }
        }
        for (Student student : this.students) {
          if (student.getId() == idStudentInt) {
            student.setTotalAttendances(student.getTotalAttendances() + 1);
          }
        }
        this.finishProgressStep();
      } else {
        this.finishProgressStep();
      }
    } else {
      this.finishProgressStep();
    }
  }

  public void accessStudentsListingMenu() {
    this.printMenuAndAwaitForScannerResponse(this.getStudentsByCategoryMenu);
  }

  public void registerNewEntity() {
    this.printMenuAndAwaitForScannerResponse(this.registerMenu);
  }

  public void registerNewStudent() {
    String studentName =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerStudentNameMenu
        );
    Utils.clearTerminal();

    String studentCPF =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerStudentCPFMenu
        );
    Utils.clearTerminal();

    String studentEnrollmentState =
      this.printMenuAndAwaitForScannerResponse(
          this.registerStudentEnrollmentMenu
        );
    Utils.clearTerminal();

    double studentGrade = printMenuAndAwaitForScannerWhateverDoubleTypeResponse(
      this.registerStudentGradeMenu
    );

    this.studentCounter++;
    Student student = new Student(
      studentName,
      studentCPF,
      studentEnrollmentState,
      studentGrade,
      this.students.size()
    );
    this.students.add(student);
    Utils.clearTerminal();
    System.out.println("ALUNO CADASTRADO COM SUCESSO!");

    this.finishProgressStep();
  }

  public void registerNewProfessor() {
    String professorName =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerProfessorNameMenu
        );
    Utils.clearTerminal();

    String professorCpf =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerProfessorCPFMenu
        );
    Utils.clearTerminal();

    String professorAcademicSituation =
      this.printMenuAndAwaitForScannerResponse(
          this.registerProfessorAcademicMenu
        );
    Utils.clearTerminal();

    String professorDevExperienceSituation =
      this.printMenuAndAwaitForScannerResponse(this.registerProfessorDevXpMenu);
    Utils.clearTerminal();

    String professorActivitySituation =
      this.printMenuAndAwaitForScannerResponse(
          this.registerProfessorActivityMenu
        );
    boolean isActive;
    if (professorActivitySituation.equals("ATIVO")) {
      isActive = true;
    } else {
      isActive = false;
    }
    this.professorCounter++;
    Professor professor = new Professor(
      professorName,
      professorCpf,
      professorAcademicSituation,
      professorDevExperienceSituation,
      isActive,
      this.professors.size()
    );
    this.professors.add(professor);
    Utils.clearTerminal();
    System.out.println("PROFESSOR CADASTRADO COM SUCESSO!");
    this.finishProgressStep();
  }

  public void accessReportsMenu() {
    this.printMenuAndAwaitForScannerResponse(this.reportsMenu);
  }

  public void accessExperienceDevMenu() {
    this.printMenuAndAwaitForScannerResponse(this.accessExperienceDevMenu);
  }

  public void getProfessorByExperience(devExperience experience) {
    int counter = 0;
    for (Professor professor : this.professors) {
      if (professor.getDevExperience().equals(experience + "")) {
        System.out.println(professor.getName());
        counter++;
      }
    }
    if (counter == 0) {
      Utils.printWarningMessage(
        "NAO HA PROFESSORES COM EXPERIENCIA " + experience + "" + "...",
        "="
      );
    }
    this.finishProgressStep();
  }

  public void registerNewPedagogue() {
    String pedagogueName =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerPedagogueNameMenu
        );

    Utils.clearTerminal();

    String pedagogueCPF =
      this.printMenuAndAwaitForScannerWhateverResponse(
          this.registerPedagogueCPFMenu
        );

    Utils.clearTerminal();

    this.pedagogueCounter++;

    Pedagogue pedagogue = new Pedagogue(
      pedagogueName,
      pedagogueCPF,
      this.pedagogues.size()
    );
    this.pedagogues.add(pedagogue);
    Utils.clearTerminal();
    System.out.println("PEDAGOGO CADASTRADO COM SUCESSO!");
    this.finishProgressStep();
  }

  public void returnToPreviousMenu() {
    this.printMenuAndAwaitForScannerResponse(navigation.getPreviousMenu());
  }

  public void printAllStudentsName() {
    if (this.students.size() < 1) {
      Utils.printWarningMessage("Nao ha estudantes cadastrados", "=");
    }
    for (Student student : this.students) {
      System.out.println(
        "NOME DO ALUNO: " +
        student.getName() +
        " ID: " +
        student.getId() +
        " MATRICULA:" +
        student.getEnrollmentState()
      );
    }
    this.finishProgressStep();
  }

  public void printAllProfessorsName() {
    if (this.professors.size() < 1) {
      Utils.printWarningMessage("Nao ha professores cadastrados", "=");
    }
    for (Professor professor : this.professors) {
      System.out.println(
        "NOME DO PROFESSOR: " +
        professor.getName() +
        " ID: " +
        professor.getId()
      );
    }
    this.finishProgressStep();
  }

  public void printAllPedagoguesName() {
    if (this.pedagogues.size() < 1) {
      Utils.printWarningMessage("Nao ha pedagogos cadastrados", "=");
    }
    for (Pedagogue pedagogue : this.pedagogues) {
      System.out.println(
        "NOME DO PEDAGOGO: " + pedagogue.getName() + " ID:" + pedagogue.getId()
      );
    }
    this.finishProgressStep();
  }

  public void printAllStudentsCPF() {
    for (Student student : this.students) {
      System.out.println(
        "CPF: " + student.getCPF() + " ID: " + student.getId()
      );
    }
    this.finishProgressStep();
  }

  public void printAllProfessorsCPF() {
    for (Professor professor : this.professors) {
      System.out.println(
        "CPF: " + professor.getCPF() + " ID:" + professor.getId()
      );
    }
    this.finishProgressStep();
  }

  public void printAllPedagoguesCPF() {
    for (Pedagogue pedagogue : this.pedagogues) {
      System.out.println(
        "CPF: " + pedagogue.getCPF() + " ID: " + pedagogue.getId()
      );
    }
    this.finishProgressStep();
  }

  public void finishProgressStep() {
    this.printMenuAndAwaitForScannerResponse(this.pressOkMenu);
    navigation.reset();
    this.printMenuAndAwaitForScannerResponse(this.initialMenu);
  }

  public void printSchoolName() {
    System.out.println(this.logo);
  }


  public void printLoading() throws InterruptedException {
    String schoolName = this.logo;
    for (int i = 0; i < schoolName.length(); ++i) {
      try {
        Thread.sleep(20);
        System.out.printf("" + schoolName.charAt(i));
      } catch (Exception InterruptedException) {
        System.out.println(InterruptedException);
      }
    }
    System.out.println("\n");
  }
}
