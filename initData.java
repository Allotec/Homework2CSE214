/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Throws If Data Is Uninitialized For An Object
public class initData extends Exception{
    /**
     * initData constructor
     * @param message
     */
    public initData(String message){
        super(message);
    }
}