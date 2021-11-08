import java.util.Scanner;
/**
 * Class UserInput reads the input from users
 *
 * @author Cecilie Lyshoel
 * @version version 1 (2017.10.20.)
 */
public class UserInput
{
    private Scanner reader;
    
    /**
     * Constructor for object of class UserInput
     */
    public UserInput(){
        reader = new Scanner(System.in);
    }
    
    public String getInput()
    {
        return getInput("> ");
    }
    
    /**
     * One line input
     */
    public String getInput(String prompt) {
        System.out.print(prompt);                // print prompt
        String inputLine = reader.nextLine();
        return inputLine;
    }
    
    /**
     * Makes it possible to write more than one line
     * 
     */
    public String getMultilineInput(String prompt) {
        System.out.println(prompt);
        
        String result = "";
        while(true) {
            String inputLine = reader.nextLine();
            if(inputLine.equals("")) {
                return result;
            } else {
                result += inputLine + "\n";
            }
        }
    }
}
