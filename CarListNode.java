/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Node For Doubly Linked List With Car Data
public class CarListNode {
    private Car data; //Holds Car Data
    private CarListNode next; //Pointer To Next Node
    private CarListNode prev; //Pointer To Previous Node

    /**
     * Constructor For Car List Node
     * @param newCar Car Object to Insert Into Node Data
     * @throws initData Throws if Car Object Arguement is null
     */
    public CarListNode(Car newCar) throws initData{
        if(newCar == null){
            throw new initData("Car Data is null cannot construct CarListNode");
        }
        else{
            this.data = newCar;    
        }
    }

    /**
     * Getter for Data
     * @return carListNode Data
     */
    public Car getData() {
        return data;
    }

    /**
     * Getter for Next Node
     * @return The Next Node
     */
    public CarListNode getNext() {
        return next;
    }

    /**
     * Getter for Previous Node
     * @return The Previous Node
     */
    public CarListNode getPrev() {
        return prev;
    }

    /**
     * Setter For Data 
     * @param data New Data To Put Into Node
     */
    public void setData(Car data) {
        this.data = data;
    }

    /**
     * Setter For Next Node
     * @param next Sets The Next Node
     */
    public void setNext(CarListNode next) {
        this.next = next;
    }

    /**
     * Setter For Previous Node
     * @param prev Sets The Previous Node
     */
    public void setPrev(CarListNode prev) {
        this.prev = prev;
    }

    /**
     * toString Method For Car Class
     * @return String Containing The Make and Owner of The Car And The Next And Previous Node
     */
    public String toString() {
        return("Current- " + super.toString() + ", Next- " + getNext().toString() + ", Previous- " + getPrev().toString());
    }
}
