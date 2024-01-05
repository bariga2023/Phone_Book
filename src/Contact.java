public class Contact {

    String name;
    String phoneNumber;
    String address;
    Contact nextContact;

    public Contact( String n, String pn, String a){

        name = n;
        phoneNumber = pn;
        address = a;
        nextContact = null;

    }

    public Contact addLink(Contact c){

        if(this.nextContact == null){

            this.nextContact = c;
        }
        else{

            this.nextContact = this.nextContact.addLink(c);
        }

        return this;
    }

}
