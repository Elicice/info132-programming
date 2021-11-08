import java.util.ArrayList;

/**
 * Klasse Network har parameter Arraylist<Person> Persons.
 * 
 * Klassen har en metode loadNetwork() for å laste opp alle vennene til en person.
 * Klassen har en metode lookupPerson(String personName) som undersøker om navnet samsvarer med et objekt i Arraylisten persons
 *  -metoden returnerer null hvis navnet ikke samsvarer eller returnerer personobjektet hvis navnet samsvarer
 * Klassen har en metode friends() som returnerer en persons venner
 * Klassen har en metode printNetwork() som printer ut navnene til alle personene og vennene til hver enklet like under deres eget navn.
 *
 * @author Cecilie Lyshoel
 * @version 03.10.2017
 */
public class Network
{
    // this variable is instantiated and set by the constructor
    private ArrayList<Person> persons;
    
    /**
     * Constructor for objects of class Network
     */
    public Network()
    {
        // initialise instance variables
        persons = new ArrayList<>();
        persons.add(new Person("Aage"));
        persons.add(new Person("Bård"));
        persons.add(new Person("Christian"));
        persons.add(new Person("Dag"));
        persons.add(new Person("Even"));
        persons.add(new Person("Fridtjof"));
        persons.add(new Person("Gerda"));
        persons.add(new Person("Hulda"));
        persons.add(new Person("Ingrid"));
        persons.add(new Person("Jorunn"));
        persons.add(new Person("Kerstin"));
        persons.add(new Person("Liv"));
    }

    /**
     * Method loadNetwork loads every agents' list of friend. (1.b)
     *  @param friendName navnet på venn til en person
     */
    public void loadNetwork() {
        for (Person person : persons) {//går gjennom listen med personer
            System.out.println("Finding friends of " + person.getName());//Navn på personen
            ArrayList<String> friendNames = friends(person.getName());//Lager ny arraylist med friendNames med venner av personen. SKal være en Person.addFriend her
            for (String friendName : friendNames) {//for hver venn i listen friendNames
                Person friend = lookupPerson (friendName);//henter ut personobjekt ved hjelp av navn. Ny variabel friend.
                if(friend != null){//hvis variabel friend ikke er null
                    person.addFriend(friend);//ligger friend til objektet til personen
                }
                System.out.println(" * " + friendName);
            }
        }
    }
    
    /**
     * Method lookupPerson searches through our collection of agents
     * and returns the agent which has the same name as the given parameter.
     * Part of exercise (1.a).
     *
     * @param personName The name of the agent we are searching for
     * @return The agent we searched for, or null if none is found
     * 
     */
    public Person lookupPerson(String personName) {
        for (Person person : persons) {//klassen Person, objekt person fra listen Persons
           if(personName.equals(person.getName())){//hvis navnet på en person samsvarer med navnet på et objekt
               return person;//returnerer objektet som samsvarer med navnet
            }
        }
    return null; // should return null if and only if no person is found
    }
    
    /**
     * Method friends returns a list of a given person's friends.
     *
     * @param personName A name of the person whose friends you want to find
     * @return A list containing the names of the given person's friends
     */
    public ArrayList<String> friends(String personName) {
        ArrayList<String> result = new ArrayList<>();
        if (personName.equals("Aage")) {
            result.add("Bård");
            result.add("Dag");
        } else if (personName.equals("Bård")) {
            result.add("Aage");
            result.add("Christian");
        } else if (personName.equals("Christian")) {
            result.add("Bård");
            result.add("Dag");
            result.add("Even");
        } else if (personName.equals("Dag")) {
            result.add("Aage");
            result.add("Christian");
            result.add("Liv");
        } else if (personName.equals("Even")) {
            result.add("Christian");
            result.add("Fridtjof");
            result.add("Gerda");
            result.add("Hulda");
            result.add("Ingrid");
            result.add("Jorunn");
        } else if (personName.equals("Fridtjof")) {
            result.add("Even");
            result.add("Gerda");
            result.add("Hulda");
        } else if (personName.equals("Gerda")) {
            result.add("Even");
            result.add("Jorunn");
            result.add("Ingrid");
        } else if (personName.equals("Hulda")) {
            result.add("Even");
            result.add("Fridtjof");
        } else if (personName.equals("Gerda")) {
            result.add("Even");
            result.add("Jorunn");
            result.add("Ingrid");
        } else if (personName.equals("Ingrid")) {
            result.add("Even");
            result.add("Gerda");
            result.add("Jorunn");
            result.add("Kerstin");
            result.add("Liv");
        } else if (personName.equals("Jorunn")) {
            result.add("Even");
            result.add("Gerda");
            result.add("Ingrid");
        } else if (personName.equals("Kerstin")) {
            result.add("Ingrid");
            result.add("Liv");
        } else if (personName.equals("Liv")) {
            result.add("Dag");
            result.add("Ingrid");
            result.add("Kerstin");
        }
        return result;
    }
    
    /**
     * Method printNetwork prints the network. It prints the name of every person
     * where each name is immediately preceded by the names of their friends.
     */
    public void printNetwork() {//metoden avhengig av loadNetwork-metoden
        for (Person person : persons) {
            ArrayList<Person> friends = person.getFriends();
            
            System.out.println(person.getName() + " has " + friends.size() + " friends:");
            for (Person friend : friends) {
                System.out.println(" * " + friend.getName());
            }
        }
    }
}
