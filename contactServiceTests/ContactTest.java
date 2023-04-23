package contactServiceTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.*;
import contactService.Contact;



class ContactTest{
	
	@Test
	//creates a new contact and verifies the object values
	void testContactClass() {
		Contact contact = new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Way");
		assertTrue(contact.getContactID().equals("as32fe3r6y"));
		assertTrue(contact.getFirstName().equals("FirstName1"));
		assertTrue(contact.getLastName().equals("LastName12"));
		assertTrue(contact.getPhoneNum().equals("2813308004"));
		assertTrue(contact.getAddress().equals("1121 Willy Way"));
		
	}
	
	@Test
	//tests if the contact ID meets the necessary limitations
	void testContactID() {
		//assert the the contact ID cannot be changed
		Field[] fields = Contact.class.getFields();
		
		int mod = fields[0].getModifiers();
		boolean result = Modifier.isFinal(mod);
		assertTrue(result);
		
		//assert the illegal argument exception is thrown for contact IDs that are too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("this string is too long", "FirstName1", "LastName12","2813308004", "1121 Willy Way");});
		//assert the illegal argument exception is thrown for null contact IDs
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(null, "FirstName1", "LastName12","2813308004", "1121 Willy Way");});
	}
	
	

	
	@Test
	//test that the first name meets the necessary limitations
	void testFirstName() {
		//assert that the first name cannot be longer than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "this string is too long", "LastName12","2813308004", "1121 Willy Way");});
		
		//assert that the first name cannot be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", null, "LastName12","2813308004", "1121 Willy Way");});
		
		//changing the first name directly
		Contact contact = new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Way");
		contact.setFirstName("Frank");
		assertTrue(contact.getFirstName().equals("Frank"));
		
		//cannot change the first name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setFirstName(null);});
		
		//cannot change the first name to something too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setFirstName("LongFirstName");});
	}
	
	
	@Test
	//test that the last name meets the necessary limitations
	void testLastName() {
		//assert that the last name cannot be longer than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "this string is too long","2813308004", "1121 Willy Way");});
		
		//assert that the last name cannot be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", null,"2813308004", "1121 Willy Way");});
		
		//changing the last name directly
		Contact contact = new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Way");
		contact.setLastName("Johnson");
		assertTrue(contact.getLastName().equals("Johnson"));
		
		//cannot change the last name to null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setLastName(null);});
				
		//cannot change the last name to something too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setLastName("LongLastName");});
	}
	
	
	@Test
	//test that the phone number meets the necessary limitations
	void testPhoneNum() {
		//assert that the phone number cannot be longer than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "LastName12","this string is too long", "1121 Willy Way");});
		
		//assert that the phone number cannot be shorter than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "LastName12","too short", "1121 Willy Way");});
		
		//assert that the phone number cannot be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "LastName12", null, "1121 Willy Way");});
		
		//changing the phone number directly 
		Contact contact = new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Way");
		contact.setPhoneNumber("5554443333");
		assertTrue(contact.getPhoneNum().equals("5554443333"));
				
		//cannot change the phone number to null	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setPhoneNumber(null);});
						
		//cannot change the phone number to something too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setPhoneNumber("28133080044");});
	}
	
	@Test
	//test that the address meets the necessary limitations
	void testAddress() {
		//assert that the address cannot be longer than 30 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Waaaaaaaaaaaaaayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy too long of a string");});
				
		
		//assert that the address cannot be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("as32fe3r6y", "FirstName1", "LastName12" ,"2813308004", null);});
		
		//changing the address directly 
		Contact contact = new Contact("as32fe3r6y", "FirstName1", "LastName12","2813308004", "1121 Willy Way");
		contact.setAddress("222 Street Lane");
		assertTrue(contact.getAddress().equals("222 Street Lane"));
						
		//cannot change the address to null	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setAddress(null);});
								
		//cannot change the phone number to something too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setAddress("1121 Willy Waaaaaaaaaaaaaayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy too long of a string");});
	}
}