/*
 * This class, Procedure, contains the attributes a
 * Procedure object should have and the operations
 * that can be performed on it. It acts as a blueprint
 * for Procedure objects. It represents a procedure
 * the patient will have.
 */
public class Procedure {
	private String procedureName;
	private String date;
	private String practitionerName;
	private double cost;
	/*
	 * The constructor below is a
	 * no-arg constructor that automatically assigns default variables
	 * to all the fields of procedure.
	 */
	public Procedure() {}
	/*
	 * The constructor below is constructor that takes in two parameters
	 * that represent data to be assigned to procedureName and date. These
	 * values are assigned to their respective instance variables.
	 */
	public Procedure(String operationName, String date) {
		procedureName=operationName;
		this.date=date;
	}
	/*
	 * The constructor below takes in four parameters for the fields procedureName,
	 * date, practitionerName, and cost. The parameters are assigned to their respective
	 * instance variables.
	 */
	public Procedure(String operationName, String date, String name, double charge) {
		procedureName=operationName;
		this.date=date;
		practitionerName=name;
		cost=charge;
	}
	/*
	 * The method below is an accessor for the instance variable procedureName. It returns
	 * the value of procedureName.
	 */
	public String getProcedureName() {
		return procedureName;
	}
	/*
	 * The method below is an accessor for the instance variable date. It returns
	 * the value of date.
	 */
	public String getDate() {
		return date;
	}
	/*
	 * The method below is an accessor for the instance variable practitionerName. It returns
	 * the value of practitionerName.
	 */
	public String getPractitionerName() {
		return practitionerName;
	}
	/*
	 * The method below is an accessor for the instance variable cost. It returns
	 * the value of cost.
	 */
	public double getCost() {
		return cost;
	}
	/*
	 * The method below is a mutator for the instance variable procedureName. It takes
	 * in an argument that is assigned to procedureName.
	 */
	public void setProcedureName(String name) {
		procedureName=name;
	}
	/*
	 * The method below is a mutator for the instance variable date. It takes
	 * in an argument that is assigned to date.
	 */
	public void setDate(String date) {
		this.date=date;
	}
	/*
	 * The method below is a mutator for the instance variable practitionerName. It takes
	 * in an argument that is assigned to practitionerName.
	 */
	public void setPractitionerName(String name) {
		practitionerName=name;
	}
	/*
	 * The method below is a mutator for the instance variable cost. It takes
	 * in an argument that is assigned to cost.
	 */
	public void setCost(double charge) {
		cost=charge;
	}
	/*
	 * The method below overrides the
	 * toString method provided by Java and has
	 * it return a String that contains data about
	 * the Procedure instance.
	 */
	@Override
	public String toString() {
		return ("\t\tProcedure: " + procedureName + "\n\t\tProcedureDate=" + date + "\n\t\tPractitioner=" + practitionerName + "\n\t\tCharge=" + cost);
	}
}
