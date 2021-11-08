import java.util.ArrayList;

/**
 *  Klasse Person har variablene String name og ArrayList<Person> friends.
 *  Klassen har en metode addFriend() som legger til et venneobjekt til en persons venneliste.
 *  Klassen har en metode printFriends() som printer ut navn på venner.
 *  Klassen har en metode printFriendsStream() som printer ut navn på venner ved hjelp av strømmer.
 *  Klassen har en metode mostConnectedFriend() som returnerer den vennen med flest venner.
 * @author Cecilie Lyshoel
 * @version 03.10.2017
 */
public class Person
{
    // the person's name
    private String name;

    // a list of this person's friends
    private ArrayList<Person> friends;
    
    /**
     * Constructor for objects of class Person. When the object
     * is created, the person's list of friends is empty.
     */
    public Person(String name)
    {
        // initialise instance variables
        this.name = name;
        friends = new ArrayList<>();
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
     * containing the person's friends. 
     *
     * @return The list of the person's friends
     */
    public ArrayList<Person> getFriends() {
        return friends;
    }
    
    /**
     * Method addFriend adds the given friend-object to this
     * person's friend list. 
     *
     * @param friend A new friend (added to the list of friends)
     */
    public void addFriend(Person friend) {
        friends.add(friend);
    }
    
    /**
     * Metoden printFreinds skal printe ut en persons venner
     */
    public void printFriends(){
        for(Person friend : friends){
        System.out.println(friend.getName());
        }
    }   
       
    /**
     * Metode printFriendsStream skal skrive ut navn på en parsons venner ved hjelp av strømmer
     * bruke map for å lage egen liste med venner for den personen
     */
    public void printFreindsStream(){
        friends.stream()
            .map(friend -> friend.getName())//map for å få en egen liste med navn på venner
            .forEach(friend -> System.out.println(friend));//skrive ut navn på venner
        }
    
    /**
     * Metode mostConnectedFriend vil returnere den vennen som selv har flest venner
     * @param largestNetwork variabel for største nettverksstørrelse.
     * @param friendWithLargestNetwork variabel for venn med størst nettverk
     * @return friendWithLargestNetwork returnerer friend-objektet med flest antall venner.
     */
    public Person mostConnectedFriend(){//
        int largestNetwork = 0;//Lager en variabel som gir nettverksstørrelse
        Person friendWithLargestNetwork = null;//lager variabel for venn med strørst vettverk
            for(Person friend : friends){//for hvert friend-objekt i listen freind
                friend.friends.size();//henter antall venner friend-objektet har
                    if (friend.friends.size() > largestNetwork ){//hvis friendobjektet har flere venner enn variabelen largestNetwork har verdi
                        largestNetwork = friend.friends.size();//Bytter ut verdien i largestNetvork med size-verdien for venner av friendobjektet.
                        friendWithLargestNetwork = friend;//Bytter ut verdien til friendsWithLargestNetwork med verdien til friend
                    }
            }
        return friendWithLargestNetwork;
    }
    }

