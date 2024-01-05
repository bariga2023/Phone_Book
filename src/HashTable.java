import java.util.Locale;

public class HashTable {

    Contact[] hashTable;

    public HashTable(){

        hashTable = new Contact[50];
    }

    public int getHashCode(Contact c){

        return Math.abs(c.name.toLowerCase().hashCode() % 50);
    }

    public void add(Contact c) {

        if (hashTable[getHashCode(c)] == null) {

            hashTable[getHashCode(c)] = c;

        } else {

            hashTable[getHashCode(c)] = hashTable[getHashCode(c)].addLink(c);
        }
    }


    public String search(String n) {

        int index = Math.abs(n.toLowerCase().hashCode() % 50);

        if (hashTable[index] == null) {

            return "No contact under that name was found";
        }
        else {

            String output;

            Contact currentContact = hashTable[index];

            while (true) {

                if ((currentContact.name.toLowerCase()).equals(n.toLowerCase())) {

                    return currentContact.name + "   |    " +
                            currentContact.phoneNumber + "   |   " + currentContact.address;
                }
                else if (currentContact.nextContact == null) {

                    return "No contact under that name was found";

                }
                else {

                    currentContact = currentContact.nextContact;
                }
            }
        }
    }

}
