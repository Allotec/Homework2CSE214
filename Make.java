/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

//Enum For Make Of Cars
public enum Make{
    FORD, GMC, CHEVY,  JEEP, 
    DODGE, CHRYSLER, LINCOLN;

    /**
     * Checks If The Argument Is In The enum List
     * @param make String To Check
     * @return True If The String Is in The List
     */
    public boolean makeCheck(String make){
        for(Make m : Make.values()){
            if(m.name().equals(make)){
                return(true);
            }
        }
        
        return(false);
    }
}
