/*
 * This is an abstract class called Person
 * that is the superclass for Acrobatic and
 * Clerk. It has the attributes name, age, and yearsWorked.
 */
public abstract class Person {
    private String name;
    private int age;
    private int yearsWorked;

    /**
     * This method assigns the values passed in to the corresponding attributes.
     * @param name The name
     * @param age The age
     * @param yearsWorked The yeares worked
     */
    public Person(String name, int age, int yearsWorked) {
        this.name = name;
        this.age = age;
        this.yearsWorked = yearsWorked;
     }

    /**
     * This method returns name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns age.
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * This method returns yearsWorked.
     * @return yearsWorked
     */
    public int getYearsWorked() {
        return yearsWorked;
    }

}