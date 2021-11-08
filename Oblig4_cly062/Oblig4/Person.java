import java.util.ArrayList;

/**
 * Abstrakt klasse Person er superklasse for for alle klasser som utvider Person-klassen.
 * Klassen har ansvar for alle personobjektene og koblinger mellom dem (venner).
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
abstract public class Person
{
    // the person's name
    private String name;
    
    // a list of this person's connections
    private ArrayList<Person> connections;
    
    /**
     * Constructor for objects of class Person. When the object
     * is created, the person's list of connections is empty.
     */
    public Person(String name)
    {
        // initialise instance variables
        this.name = name;
        connections = new ArrayList<>();
    }
  
    /**
     *Sammenligner to objekt(Person) for å se om de er lik (oppgave 4c)
     *Overstyrer equals-metoden
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
         return false;
       }
        if (obj instanceof Person) {
         Person other = (Person) obj;
         return (this.name .equals(other.name));
       }
       return false;
    }

    /**
     * Method getName returns the person's name.
     *
     * @return The person's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method getFriends returns an ArraList of Person-objects 
     * containing the person's conections. 
     *
     * @return The list of the person's connections
     */
    public ArrayList<Person> getConnections() {
        return connections;
    }
    
    /**
     * Method addConnections adds the given Person-object to this
     * person's connections list. 
     *
     * @param friend A new connection (added to the list of connections)
     */
    public void addConnection(Person connection) {
        //connections.add(connection);
        if(connections.contains(connection) == false){ //hvis ikke ArrayList connections inneholder denne forbindelsen
        connections.add(connection);//legg til forbindelsen i connections
    }
    }
    
    /**
     * Returns a hash code value for the object. (See 11.8 (p. 377) for explanation of this
     * and justification for why we do not discuss it further.)
     *
     * @see Object#hashCode()
     * @return The return value
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
