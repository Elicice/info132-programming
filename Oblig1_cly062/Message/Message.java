
/**
 * Klassen Massage har varablene Person sender og Strig MessageBody.
 * Klassen muliggjør at andre klasser kan hente ut verdiene for disse variablene
 *
 * @author Cecilie Lyshoel
 * @version 12.09.2017
 */
public class Message
{  /**Feltet deklarere variablene Person sender og String messageBody.
   *Variablene er privat for denne klassen
   *variabelen Person sender er avhengig av klassen Person.
   */
   private Person sender;
   private String messageBody;
  
   /*Konstruktør initialiserer variablene, har ingen returverdi*/
    public Message(Person sender, String messageBody){
        this.sender = sender;
        this.messageBody = messageBody;
   }
   /*Denne metoden gjør det mulig å returnere sender når den er kalt*/
    public Person getSender(){
      return sender;
    } 
   /*Denne metoden gjør det mulig å returnere messageBody når den blir kalt*/
    public String getMessageBody(){
      return messageBody;
    }
}
