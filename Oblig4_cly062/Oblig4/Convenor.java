import java.util.ArrayList;
/**
 * Klassen Convenor er en subklasse av Person-klassen og arver alle felt og metoder i Person-klassen.
 * Implimenterer Administrator interface, arver default-mentoden suspend() og arver getName() fra Person-klassen. Må implimentere getRole() i klassen.
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
public class Convenor extends Person implements Administrator
{
    private String competance;
    /**
     * Konstruktør for Convenor-klassen. Navn er arvet fra Person-klassen.
     */
    public Convenor(String name, String copetance){
        super(name);
        this.competance = competance;
    }
    /**
     * Overstyrer toString-metoden
     * @return convenors navn og rolle.
     */
    @Override
    public String toString(){
        return "Navn: " + getName() + ", rolle: " + getRole();
    }
    
    public String getCompetance(){
        return competance;
    }
    
        public String getRole(){
        return "Convenor";
    }
    
    /**
     * 
     * Skriver ut navn på studenter i arraylisten coursMembers og kungjøringer.
     */
    public void announce(ArrayList<Student> courseMembers, String announcement){
        for (Student student : courseMembers){
            System.out.println("Navn: " + student.getName());
            System.out.println("Kungjøring: " + announcement);
        }
    }
    

}
