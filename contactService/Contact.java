package contactService;

public class Contact {
	public final String contactID; 
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	//constructor with only ID
	public Contact(String ID) {
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		this.contactID = ID;
	}
	
	//constructor with params
	public Contact(String ID, String first, String last, String phone, String address){
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		if(first == null || first.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		if(last == null || last.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		this.contactID = ID;
		this.firstName = first;
		this.lastName = last;
		this.phoneNumber = phone;
		this.address = address;
	}
	
	//value getters and mutators
	public void setFirstName(String first) {
		if(first == null || first.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		this.firstName = first;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	
	public void setLastName(String last) {
		if(last == null || last.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		this.lastName = last;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhoneNumber(String phone) {
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		this.phoneNumber = phone;
	}
	
	public String getPhoneNum() {
		return this.phoneNumber;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
}