
/**
 * Klassen Person har variablene String name og boolean isOnline.
 * Klassen har en reciveMessage metode som henter navnet på sender og mottaker, online-status på avsender,
 * og printer ut:
 * From: [avsenders navn] (online-status)
 * To: [mottakers navn]
 * Message: 
 * [beskjed]
 *
 * @author Cecilie Lyshoel
 * @version 12.09.2017
 */
public class Person
{
    /**Felt hvor variablene String name og boolean isOnline er deklarert.
    *Variablene her er privat for denne klassen 
    */
    private String name;
    private boolean isOnline;
    
    
    /*konstruktøren initialiserer variablene, har ingen returverdi*/
    public Person(String name){
        this.name = name;
        isOnline = false;//Dette er standard for boonean, men oppgaven presiserer å sette til false
    }
    /* Returnerer name når metoden er blir kalt. Metoden er tilgengelig for andre klasser*/
    public String getName(){
        return name;
    }
    /*Denne metoden gjør det mulig å sette online-status*/
    public void setIsOnline(boolean isOnline){
        this.isOnline = isOnline;
    }
    /*Denne metoden gjør det mulig å returnere online-status*/
    public boolean getIsOnline(){
        return isOnline;
    }
    
    /**Denne metoden henter navnet på sender og mottaker, online-status på avsender,
     * og printer ut:
     * From: [avsenders navn] (online-status)
     * To: [mottakers navn]
     * Message: 
     * [beskjed]
    */
    public void receiveMessage(Message message){
        System.out.print("From: " + message.getSender().getName());//print,ikke ny linje her
        if(message.getSender().getIsOnline()){
            System.out.println(" (Online)");
        }else{
            System.out.println(" (Offline)");
        }
        System.out.println("To: " + this.getName());
        System.out.println("Message: ");
        System.out.println(message.getMessageBody());
        
    }
   
    }
