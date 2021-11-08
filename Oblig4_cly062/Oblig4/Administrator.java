
/**
 * Administrator interface som gjør at alle klasser som implimenterer denne må implementere alle metodene (utenom default-metoden i dette tilfellet)
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
public interface Administrator
{
    public String getRole(); 
    public String getName();
    
    /**
     * Default metode som skriver ut hvilken student som er utestengt, hvem som har utført dette, hvilken rolle de har og begrunnelse for utestengelsen.
     * Default metode er ikke nødvendig for klasser som implimenterer interfacet å nevne i egen klasser.
     */
    default void suspend(Student student, String justification){
        System.out.println("Studentens navn: " + student.getName());
        System.out.print("Utestengelse utført av: : " + this.getName() +", ");
        System.out.println(this.getRole());
        System.out.println("Begrunnelse: " + justification);
    }
}
