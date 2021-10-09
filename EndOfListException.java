/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Throws If The End Of A Linked List Is Reached
public class EndOfListException extends Exception{
    /**
     * initData constructor
     * @param message
     */
    public EndOfListException(String message){
        super(message);
    }
}