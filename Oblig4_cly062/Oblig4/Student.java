
/**
 * Klassen Student er en subklasse av klassen Person og arver alle felt og metoder i Person-klassen. 
 * Klassen har ansvar for brukernavn. 
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
public class Student extends Person
{
    private String userName;
    
    /**
     * Konstruktør for Student.
     * Arver name fra Person-klassen
     */
    public Student(String name, String UserName){
        super(name);
        this.userName = userName;
    }
    
    /**
     * Overstyrer toString-metoden
     * @return studentens navn og rolle.
     */
    @Override
    public String toString(){
        return "Navn: " + getName() + ", rolle: Student.";
    }
    
    public String getUserName(){
        return userName;
    }
}
