import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *  Klassen Nettwok har ansvar for nettverk mellom personobjektene. 
 *  Det er mulig å laste, legge til og slå opp personer eller koblingeer mellom personer, samt skrive ut nettverket. 
 *  Klassen har en statisk metode med en singleton nettverks-objekt.
 *
 * @author Cecilie Lyshoel
 * @version 2017.10.11
 */
public class Network
{
    public static final String USERS_FILE = "users.tsv";
    public static final String CONNECTIONS_FILE = "connections.tsv";
    
    // This is an implementation of a Singleton-class. We encountered this
    // in the first lecture (the figures-project). This static field
    // contains a reference to the only instance of a network.
    private static Network networkSingleton;

    private HashMap<String, Person> people;

    /**
     * Lager Nettwork-objektet hvis det ikke finnes et fra før
     * @return Singleton network-objektet
     */
    public static Network getNetwork() {
        if(networkSingleton == null) {
            networkSingleton = new Network();
        }
        return networkSingleton;
    }
    
    
    /**
     * Constructor for objects of class Network
     */
    private Network() {
        people = new HashMap<>();
        loadNetwork();
    }
    
    /**
     * Laster nettverk med navn og koblingene mellom den
     */
    private void loadNetwork() {
        // load the user names (nodes)
        loadNames();
        
        // load the network (edges)
        loadConnections();
    }
    
    /**
     * Metoden laster navn og legger til objekt med informasjon om rolle, navn og annen info.
     * Legger til personObject i HashMap people med navn som nøkkel
     * 
     */private void loadNames() {
        for(String[] record : TSVStorage.readTSVFile(USERS_FILE, 3)) {
            String name = record[0];
            String role = record[1];
            String info = record[2];
            Person personObject;
            if(role .equals("Student")){
                personObject = new Student(name, info);
            }
            else if(role .equals("Convenor")){
                personObject = new Convenor(name, info);
            }
            else if(role .equals("Rector")){
                personObject = new Rector (name, info);
            }
            else{ 
                continue;//hopper over hvis det man prøver å legge til ikke er en gyldig type.
            }
            people.put(name, personObject);//legger til objekt i HashMap people med nøkkel name
        }
    }
    
    /**
     * Metoden laster opp koblingene som er er mellom personer
     */
    private void loadConnections() {
        for(String[] names : TSVStorage.readTSVFile(CONNECTIONS_FILE, 2)) {
            Person user1 = lookupPerson(names[0]);
            Person user2 = lookupPerson(names[1]);
            user1.addConnection(user2);
            user2.addConnection(user1);
        }
    }
    
    /**
     * Metode som henter ut en person basert på navn.
     *
     * @param personName Navnet på personen vi slår opp
     * @return retunerer personen vi slår opp eller returnerer null.
     */
    public Person lookupPerson(String personName) {
        return people.get(personName);
    }
    
    /**
     * Method printNetwork prints the network. It prints the name of every person
     * where each name is immediately preceded by the names of their connections.
     */
    public void printNetwork() {
        for (Person person : people.values()) {//siden vi har endret til HashMap så bruker vi value-metoden fra HashMap-klassen
            ArrayList<Person> connections = person.getConnections();
            System.out.println(person.getName() + " has " + connections.size() + " connections:");
            for (Person friend : connections) {
                System.out.println(" * " + friend.getName());
            }
        }
    }
}
