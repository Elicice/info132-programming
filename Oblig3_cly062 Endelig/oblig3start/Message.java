
/**
 * Class Message where variables and objects for messages are declared and created and where the message is printed
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.23
 */
public class Message
{
    // instance variables - replace the example below with your own
    private Person sender;
    private Person recipient;
    private String messageBody;

    /**
     * Constructor for objects of class Message
     */
    public Message(Person sender, Person recipient, String messageBody)
    {
        // initialise instance variables
        this.sender = sender; 
        this.recipient = recipient;
        this.messageBody = messageBody;
    }
    
    public Person getSender() {
        return sender;
    }
    
    public Person getRecipient() {
        return recipient;
    }
   
    public String getMessageBody() {
        return messageBody;
    }
    
    /**
     * Prints a users messages
     */
    public void printMessage(){
        System.out.print("From: " + getSender().getName());
        System.out.println("To: " + getRecipient().getName());
        System.out.println("Message: ");
        System.out.println(getMessageBody());
        
    }
}
