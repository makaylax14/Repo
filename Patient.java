/*
 * This class holds the attributes a Patient
 * object should have and the operations that
 * can be performed on the object. It represents
 * a patient and their information.
 */
public class Patient {
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactNum;
	/*
	 * The special method below is
	 * a no-arg constructor. It automatically initializes
	 * the instance variables with default values.
	 */
	public Patient() {}
	/*
	 * The method below is a constructor that accepts
	 * three arguments for the instance variables firstName,
	 * middleName, and lastName. It initializes the variables
	 * with the provided arguments.
	 */
	public Patient(String patientsFirstName, String patientsMiddleName, String patientsLastName) {
		firstName=patientsFirstName;
		middleName=patientsMiddleName;
		lastName=patientsLastName;
	}
	/*
	 * The method below is a
	 * constructor that accepts
	 * values for every instance
	 * variable. It assigns the parameter
	 * values to the respective instance variables.
	 */
	public Patient(String patientsFirstName, String patientsMiddleName, String patientsLastName, String street, String cityName, String stateName, int zipCode, String phoneNumber, String emergencyContactName, String emergencyContactNum) {
		firstName=patientsFirstName;
		middleName=patientsMiddleName;
		lastName=patientsLastName;
		streetAddress=street;
		city=cityName;
		state=stateName;
		this.zipCode=zipCode;
		this.phoneNumber=phoneNumber;
		this.emergencyContactName=emergencyContactName;
		this.emergencyContactNum=emergencyContactNum;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable middleName.
	 */
	public String getMiddleName() {
		return middleName;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable streetAddress.
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable city.
	 */
	public String getCity() {
		return city;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable state.
	 */
	public String getState() {
		return state;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable zipCode.
	 */
	public int getZipCode() {
		return zipCode;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable phoneNumber.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable emergencyContactName.
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/*
	 * The method below is an
	 * accessor method that returns the
	 * value of the instance variable emergencyContactNum.
	 */
	public String getEmergencyContactNum() {
		return emergencyContactNum;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable firstName.
	 */
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable middleName.
	 */
	public void setMiddleName(String middleName) {
		this.middleName=middleName;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable streetAddress.
	 */
	public void setStreetAddress(String street) {
		streetAddress=street;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable city.
	 */
	public void setCity(String city) {
		this.city=city;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable state.
	 */
	public void setState(String state) {
		this.state=state;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable zipCode.
	 */
	public void setZipCode(int zipCode) {
		this.zipCode=zipCode;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable phoneNumber.
	 */
	public void setPhoneNumber(String number) {
		phoneNumber=number;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable emergencyContactName.
	 */
	public void setEmergencyContactName(String name) {
		emergencyContactName=name;
	}
	/*
	 * The method below is an
	 * mutator method that assigns
	 * the parameter value to the instance variable emergencyContactNum.
	 */
	public void setEmergencyContactNum(String num) {
		emergencyContactNum=num;
	}
	/*
	 * The method below, buildFullName, returns
	 * a String that contains the values
	 * for firstName, middleName, and lastName.
	 */
	public String buildFullName() {
		return (firstName + " " + middleName + " " + lastName);
	}
	/*
	 * The method below, buildAddress, returns
	 * a String that contains the values
	 * for streetAddress, city, state, and zipCode.
	 */
	public String buildAddress() {
		return (streetAddress + " " + city + " " + state + " " + zipCode);
	}
	/*
	 * The method below, buildEmergencyContact, returns
	 * a String that contains the values
	 * for emergencyContactName and emergencyContactNum.
	 */
	public String buildEmergencyContact() {
		return (emergencyContactName + " " + emergencyContactNum);
	}
	/*
	 * The method below overrides the
	 * Java-provided toString method and
	 * instead has it return a String with
	 * the values for all the instance variables.
	 * It uses buildFullName(), buildAddress(), and
	 * buildEmergencyContact() to access the variables
	 * and concatenate them into Strings.
	 */
	@Override
	public String toString() {
		return ("\tName: " + buildFullName() + "\n\tAddress: " + buildAddress() + "\n\tEmergencyContact: " + buildEmergencyContact());
	}
}
