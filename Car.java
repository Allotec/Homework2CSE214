/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Car Class That Stores The Car Type and The Name of The Owner
public class Car{
    private Make make; //Enum Constant for Car Make
    private String owner; //Name of Car Owner

    /**
     * Car Constructor
     * @param make
     * @param owner
     */
    public Car(Make make, String owner){
        this.make = make;
        this.owner = owner;
    }

    /**
     * Getter for Car Make
     * @return Make of Car
     */
    public Make getMake() {
        return make;
    }

    /**
     * Getter for Owner Name
     * @return The Name of The Owner As a String
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter For the Make of The Car
     * @param make 
     */
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     * Setter For The Name of The Owner
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * toString Method For Car Class
     * @return String Containing The Make and Owner of The Car
     */
    public String toString() {
        return("Make- " + make + ", Owner- " + owner);
    }
}