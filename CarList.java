/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Doubly Linked List Containing Car Nodes
public class CarList {
    private CarListNode head; //Pointer to Head
    private CarListNode tail; //Pointer to Tail
    private CarListNode cursor; //Points to Node In List
    private int carCount; //Holds the Amount of Nodes In The List

    //Constructor for Car List
    public CarList(){};

    /**
     * Returns The Amount of Nodes In The List
     * @return carCount
     */
    public int numCars(){
        return(carCount);
    }

    /**
     * Gets The Car The Cursor Is Pointing To
     * @return Cursor Car
     */
    public Car getCursorCar(){
        return(cursor.getData());
    }

    //Points The Cursor to The Head
    public void resetCursorToHead(){
        cursor = head;
    }

    //Points The Cursor To The Head
    public void resetCursorToTail(){
        cursor = tail;
    }

    /**
     * Moves The Cursor Forward On The List
     * @throws EndOfListException Throws If The Cursor Is At The End Of The List
     */
    public void cursorForward() throws EndOfListException{
        if(cursor == tail){
            throw new EndOfListException("Cursor cannot move forward");
        }
        else{
            cursor = cursor.getNext();
        }
    }

    /**
     * Moves The Cursor Backward On The List
     * @throws EndOfListException Throws If The Cursor Is At The Beginning Of The List
     */
    public void cursorBackward() throws EndOfListException{
        if(cursor == head){
            throw new EndOfListException("Cursor Cannot Move Backward");
        }
        else{
            cursor = cursor.getPrev();
        }
    }

    /**
     * Inserts A Node Before The Node The Cursor Points To
     * @param newCar Data For New Node
     * @throws initData Throws If newCar Data Is Null
     */
    public void insertBeforeCursor(Car newCar) throws initData{
        CarListNode c1;

        if(newCar == null){
            throw new initData("Car Data in Uninitialized");
        }
        else if(cursor == null && head == null && tail == null){
            c1 = new CarListNode(newCar);
            head = c1;
            tail = c1;
            carCount++;
        }
        else if(cursor == head){
            c1 = new CarListNode(newCar);
            c1.setNext(head);
            head.setPrev(c1);
            head = c1;
            carCount++;
        }
        else{
            c1 = new CarListNode(newCar);
            c1.setNext(cursor);
            c1.setPrev(cursor.getPrev());
            cursor.getPrev().setNext(c1);
            cursor.setPrev(c1);
            carCount++;
        }
    }

    /**
     * Appends A Node To The End Of The List
     * @param newCar Data For New Node
     * @throws initData Throws If newCar Data Is Null
     */
    public void appendToTail(Car newCar) throws initData{
        CarListNode c1;

        if(newCar == null){
            throw new initData("Car Data in Uninitialized");
        }
        else if(cursor == null && head == null && tail == null){
            c1 = new CarListNode(newCar);
            head = c1;
            tail = c1;
            cursor = c1;
            carCount++;
        }
        else{
            c1 = new CarListNode(newCar);
            c1.setPrev(tail);
            tail.setNext(c1);
            tail = c1;
            carCount++;
        }
    }

    /**
     * Removes The Car From The List That The Cursor Points To
     * @return Returns That Value Of The Removed Node
     * @throws EndOfListException Throws If Cursor Isn't Pointing To A Node
     */
    public Car removeCursor() throws EndOfListException{
        Car c1;
        CarListNode temp;

        if(cursor == null){
            throw new EndOfListException("Cursor is a Null Pointer Cannot Delete Element");
        }
        else if(cursor == head){
            c1 = cursor.getData();

            head = cursor.getNext();
            head.setPrev(null);
            cursor = head;
            carCount--;

            return(c1);
        }
        else if(cursor == tail){
            c1 = cursor.getData();

            tail = cursor.getPrev();
            tail.setNext(null);
            cursor = tail;
            carCount--;

            return(c1);
        }
        else{
            c1 = cursor.getData();
            temp = cursor.getPrev();

            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor.setNext(null);
            cursor.setPrev(null);

            cursor = temp;
            carCount--;

            return(c1);
        }
    }

    /**
     * Sorts The List By Name
     * @throws EndOfListException Throws If The List Is Empty
     */
    public void sortList() throws EndOfListException{
        if(head == null){
            throw new EndOfListException("List is Empty");
        }
        else{
            CarListNode ptr1 = head, ptr2 = head;

            for(int i = 0; i < carCount; i++){
                for(int j = 0; j < carCount; j++){
                    if(ptr1.getData().getOwner().compareTo(ptr2.getData().getOwner()) < 0){
                        swap(ptr1.getData(), ptr2.getData());
                    }
                    ptr2 = ptr2.getNext();
                }
                ptr1 = ptr1.getNext();
                ptr2 = head;
                
                if(i == carCount - 1){
                    break;
                }
            }

        }
    }

    /**
     * Swaps The Data Of Two Nodes
     * @param car1 Data To Swap
     * @param car2 Data To Swap
     */
    private void swap(Car car1, Car car2){
        CarListNode ptr = head;

        for(int i = 0; i < carCount; i++){
            if(ptr.getData() == car1){
                ptr.setData(car2);
            }
            else if(ptr.getData() == car2){
                ptr.setData(car1);
            }
            ptr = ptr.getNext();
            
            if(i == carCount - 1){
               break;
            }
        }
    }

    //Prints The Nodes On The List
    public void Print(){
        CarListNode temp;
        
        if(head == null){
            System.out.println("Empty List");
        }
        else{
            temp = head;

            while(temp != null){
                if(temp == cursor){
                    System.out.println("->" + temp.getData().toString() + "\n");
                    temp = temp.getNext();
                }
                else{
                    System.out.println(temp.getData().toString() + "\n");
                    temp = temp.getNext();
                }
            }
        }
        System.out.println("\n");
    }
}
