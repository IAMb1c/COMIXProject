import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface SystemViews {
    public void view();
    public String readDatabase( String filename );


    default void printInfo() {
        System.out.println("""
            "COMIX" - go to the COMIX database view \n
            "VIEW" - go to the personal collection view \n
            "EXIT - exit the program
                """);
    }

    default String getUserInput() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
          return input.readLine();
        }
        catch (Exception e) {
          System.out.println("Something went wrong!");
          return null;
        }
    }
}
