package contactService;

import java.util.*;
import java.util.ArrayList;
import java.util.UUID;
import java.security.SecureRandom;

public class ContactService{
	//set array so other methods can access it
	public ArrayList<Contact> contactList;
	
	
	//contact service constructor
	public ContactService() {
		//create an arraylist of contacts
		contactList = new ArrayList<Contact>();
	}
	
	
	//generate a random uuid and take a random substring
	public String createID() {
		//create uuid
		String uuid = UUID.randomUUID().toString();
		//remove dashes
		uuid.replace("-", "");
		
		//generate random 10 length substring start point in 32 char uuid
		SecureRandom randomInt = new SecureRandom();
		int upperBound = 21;
		int stringStart = randomInt.nextInt(upperBound);
		
		uuid = uuid.substring(stringStart, stringStart + 10);
		return uuid;
	}
	
	//creates a new contact and adds it to the contact list
	public void newContact(String firstName, String lastName, String phone, String address) {
		//generate ID
		String newID = createID();
		//construct contact object
		Contact newContact = new Contact(newID, firstName, lastName, phone, address);
		//add the contact object to the arraylist
		contactList.add(newContact);
	}
	
	//deletes a contact with the given contact id
	 public void delContact(String contactID) {
		 ListIterator<Contact> iterator = contactList.listIterator();
		 while(iterator.hasNext()) {
			 if(iterator.next().getContactID().equals(contactID)) {
				 iterator.remove();
			 }
		 }
	 }
	 
	
	//updates a contacts first name 
	public void updateFirstName(String contactID, String first) {
		for(Contact con : contactList) {
			if (con.getContactID().equals(contactID)){
				con.setFirstName(first);
			}
		}
	}
	
	//updates a contacts last name 
	public void updateLastName(String contactID, String last) {
		for(Contact con : contactList) {
			if (con.getContactID().equals(contactID)){
				con.setLastName(last);
			}
		}
	}
	
	//updates a contacts phone number 
	public void updatePhone(String contactID, String phone) {
		for(Contact con : contactList) {
			if (con.getContactID().equals(contactID)){
				con.setPhoneNumber(phone);
			}
		}
	}
	
	//updates a contacts phone number 
	public void updateAddress(String contactID, String address) {
		for(Contact con : contactList) {
			if (con.getContactID().equals(contactID)){
				con.setAddress(address);
			}
		}
	}
	
	//returns contact list size
	public int listSize() {
		return contactList.size();
	}	



	
		
}