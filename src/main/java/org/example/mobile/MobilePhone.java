package org.example.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts;
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name,phoneNumber);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (myContacts.contains(contact)) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact contact1, Contact contact2){
        if(myContacts.contains(contact1)){
            myContacts.remove(contact1);
            myContacts.add(contact2);
            return true;
        } else if(myContacts.contains(contact2)){
            myContacts.remove(contact2);
            myContacts.add(contact1);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        }else {
            return false;
        }
    }

    public int findContact(Contact contact){
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        } else {
            return -1;
        }
    }

    public int findContact(String nameOrNumber){
        int result = -1;
        for(Contact contact : myContacts){
            if(contact.getName().equals(nameOrNumber) || contact.getPhoneNumber().equals(nameOrNumber)){
                result = myContacts.indexOf(contact);
            }
        }
        return result;
    }

    public Contact queryContact(String query){
        Contact result = null;
        for(Contact contact : myContacts){
            if(contact.getName().equals(query) ){
                result = contact;
            }
        }
        return result;
    }

    public void printContact(){
        for(Contact contact : myContacts){
            System.out.println( myContacts.indexOf(contact)+1 + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return Objects.equals(myNumber, that.myNumber) && Objects.equals(myContacts, that.myContacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myNumber, myContacts);
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts=" + myContacts +
                '}';
    }
}
