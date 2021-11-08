

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TestMessageDatabase.
 * Tests to se if number of messages increase with one when adding a message. 
 *
 * @author  Cecilie Lyshoel
 * @version 2017.10.23
 */
public class TestMessageDatabase
{
    /**
     * Default constructor for test class TestMessageDatabase
     */
    public TestMessageDatabase()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * 
     * Deletes all messages and test if database is empty
     * 
     */
    @Test
    public void testReset(){
        ArrayList<Message> empty = new ArrayList<>();
        MessageDatabase.setMessages(empty);
        assertEquals(0, MessageDatabase.getMessages().size());
    }
   
    
    /**
     * 
     * Tests if number number of messages increase with one when a message is added. 
     */
    @Test
    public void testIncrement(){
        int messageBefore = MessageDatabase.getMessages().size(); //counts messages before adding amessage
        Person sender= new Person("testSender");
        Person recipient = new Person("testResipient");
        String messageBody = new String("test");
        Message message = new Message(sender, recipient, messageBody);
        MessageDatabase.addMessage(message); //adds test message to database
        int messageAfter = MessageDatabase.getMessages().size(); //cuonts message after adding message
        assertEquals(messageBefore +1,messageAfter); //tests if messages before adding message pluss one equals the number of messages after adding a message
        
        
        
    }
}
