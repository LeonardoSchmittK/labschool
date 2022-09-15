public class GoBackOption extends MenuOption {

  static String optionName = "Voltar";
  static String optionAcesser;
  static String description = "return to the previous menu";

  GoBackOption(String optionAccesserPassed) {
    super(optionName, optionAccesserPassed, description);
  }

  GoBackOption(String optionNamePassed, String optionAccesserPassed) {
    super(optionNamePassed, optionAccesserPassed, description);
  }

  GoBackOption(
    String optionNamePassed,
    String optionAccesserPassed,
    String descriptionPassed
  ) {
    super(optionNamePassed, optionAccesserPassed, descriptionPassed);
  }
}
