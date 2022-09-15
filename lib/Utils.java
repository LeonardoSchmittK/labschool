public class Utils {
    static public void clearTerminal(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    
  static public void printWarningMessage(String message, String pattern) {
    String resultToPrint = "";
    for (int i = 0; i <= 5; ++i) {
      resultToPrint += pattern;
    }
    resultToPrint += " " + message + " ";

    for (int i = 0; i <= 5; ++i) {
      resultToPrint += pattern;
    }

    System.out.println(resultToPrint);
   
  }
}
