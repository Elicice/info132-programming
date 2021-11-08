
/**
 * Klassen Rector er en subklasse av Person-klassen og arver alle felt og metoder i Person-klassen.
 * Implimenterer Administrator interface, arver default-mentoden suspend() og arver getName() fra Person-klassen. Må implimentere getRole() i klassen.
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
public class Rector extends Person implements Administrator
{
    private String electionPromise;
    
    /**
     * Konstruktør for klassen Rector. Arver name fra Personklassen.
     */
    public Rector(String name, String electionPromise){
        super(name);
        this.electionPromise = electionPromise;
    }
    
    /**
     * Overstyrer toString-metoden
     * @return rektors navn og rolle.
     */
    @Override
    public String toString(){
        return "Navn: " + getName() + ", rolle: " + getRole();
    }
    
    public String getElectionPromise(){
        return electionPromise;
    }
    
        public String getRole(){
        return "Rector";
    }
    
    /**
     * 
     * Rektor er avsender og convenor er mottaker. 
     * Noe uklar oppgavetekst her, men slik jeg tolker det.
     * @param lecturer
     * @param commendation
     */
    public void commend(Convenor lecturer, String commendation){
        System.out.println("mottaker: " + lecturer.getName());
        System.out.println("Melding: " + commendation);
    }
}
