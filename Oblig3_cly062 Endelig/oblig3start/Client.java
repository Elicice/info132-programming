
/**
 * Client functions as an interface between a user and the network. The 
 * user interacts with the client by typing commands. The user can send messages 
 * to other users.
 * 
 * @author     Cecilie Lyshoel
 * @version    2.0 (2017.10.20.)
 */
public class Client
{
    private Network network;
    private Person user;

    
    public Client()
    {
        network = Network.getNetwork();
    }
    
    /**
     * Method start runs the client-program. It consists of two main
     * phases: login and working. 
     * 
     * During the login-phase the user will be asked to identify herself. 
     * The username given must match an existing person exactly. 
     * 
     * During the working-phase the user will send commands to the client. 
     * The client can send messages (initiated by the command "message"), give instruction for how to use the program (initiated by the command "help"),
     * print a users messages from friends (initiated by the command "read" and quit (initiated by the command "bye"). 
     *
     * 
     */
    public void start() {
        boolean loggedIn = false;
        UserInput userInput = new UserInput();
        
        while(!loggedIn) {//Have to be loged in to use the program
            String username = userInput.getInput("Username: ");
            user = network.lookupPerson(username);
            loggedIn = user != null;
        }
        
        printWelcome();
        
        boolean finished = false;
        while(!finished) {
            String userCommand = userInput.getInput();
            
            if(userCommand.equals("bye")) {//Ends session if 'bye' is entered
                finished = true;
            } else if(userCommand.equals("message")) {//makes it possible to send messages
                String recipientName = userInput.getInput("To: ");//Have to enter name to recipient to write message
                Person recipient = network.lookupPerson(recipientName);
                if (recipient != null) {
                    String messageBody = userInput.getMultilineInput("Message: ");
                    Message message = new Message(user, recipient, messageBody);
                    MessageDatabase.addMessage(message);
            }
            }else if(userCommand.equals("read")){//prints messages from users friends
                printMessages(user);
            } else if(userCommand.equals("help")){//prints instructions
                printHelp();
            }
            
        }
        printGoodbye();
    }
    
    /**
     * prints welcome message
     * 
     */
    private void printWelcome() {
        System.out.println("Welcome to the messaging client, " 
            + user.getName() + ".");
        System.out.println("Type 'help' to get instructions.");
    }
    
    /**
     * Prints a 'good bye' message
     * 
     */
    private void printGoodbye() {
        System.out.println("Good bye, " + user.getName() + "!");
    }

    /**
     *Prints messages the user have recived from friends
     * @Param user 
     */
    private void printMessages(Person user){
        MessageDatabase.getMessagesFromFriendsTo(user).stream().forEach(message -> message.printMessage());
    }
    
    /**
     * prints instructions for how to use the program
     */
    private void printHelp(){
        System.out.println("Type 'message' to wirte who to send message to");
        System.out.println("After entering who to send to, you can write the message. End message by sending an empty line.");
        System.out.println("Enter 'read' to read all recived messages from your friends.");
        System.out.println("End session by typing 'bye'.");
    }
    
    /**
     * main method that creates a Client object and calls the start method
     */
    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
    
}
