/*
Matthew Champagne
ID- 112540003
Matthew.champagne@stonybrook.edu
Homework 2
CSE 214.R04
Recitation TA's- Balaji Jayasankar and Xincheng Chi
Grading TA's- Balaji Jayasankar and Saahil Kamat
*/

import java.util.Scanner;

//Interacts With CarList Class And Manages Oil Changes For Joe And Donny
public class OilChangeManager {
    public static void main(String args[]) throws initData{
        //CarList for Joe and Donny
        CarList joeList = new CarList();
        CarList donnyList = new CarList();
        CarList finishedList = new CarList();

        //Temporary Variables for inputs
        char c = ' '; //Character For Switch
        char currentList = ' '; //Holds Current List
        String name = " "; //Input For Name of Owner
        String mainMenu = "LlMmPpFfSsQq"; //Main Menu Options
        String SecondOptions = "AaFfHhTtBbIiXxVvRr"; //Secondary Menu Options
        String listPick = "JjDd"; //Options For people
        String makeStr = " "; //Holds String For Make Of Car
        Car car = null; //Holds Car For Cutting and Pasting Between Lists
        int carCount = 0; //Holds The Amount Of Cars In a List
        Make make = Make.CHEVY; //Temporary Make Variable

        while(true){
            //Prints out menu each loop
            System.out.println("Menu:");
            System.out.println("\tL) Edit Job Lists for Joe and Donny");
            System.out.println("\tM) Merge Job Lists");
            System.out.println("\tP) Print Job Lists");
            System.out.println("\tF) Paste car to end of finished car list");
            System.out.println("\tS) Sort Job Lists");
            System.out.println("\tQ) Quit");

            //Opens Scanner and asks for option to be chosen from menu
            Scanner keyboard = new Scanner(System.in);

            //Forces A Valid Option To Be Chosen For Main Menu
            while(true){
                System.out.println("Please select an option- ");
                c = keyboard.nextLine().charAt(0);
                
                if(!mainMenu.contains(String.valueOf(c))){
                    System.out.println("Please Select a valid List");
                }
                else{
                    break;
                }
            }

            switch(c){
                case 'L':
                case 'l':
                    //Edit Job list for Joe and Donny
                    try{
                        //Forces A Valid Option To Be Chosen Between Joe And Donny
                        while(true){
                            System.out.println("Please select a list - Joe (J) or Donny (D)- ");
                            currentList = keyboard.nextLine().charAt(0);

                            if(!listPick.contains(String.valueOf(currentList))){
                                System.out.println("Please Select a valid List");
                            }
                            else{
                                break;
                            }
                        }

                        //Secondary Menu
                        System.out.println("Options:");
                        System.out.println("\tA) Add a car to the end of the list");
                        System.out.println("\tF) Cursor Forward");
                        System.out.println("\tH) Cursor To Head");
                        System.out.println("\tT) Cursor To Tail");
                        System.out.println("\tB) Cursor Backward");
                        System.out.println("\tI) Insert Car Before Cursor");
                        System.out.println("\tX) Cut Car At Cursor");
                        System.out.println("\tV) Paste Before Cursor");
                        System.out.println("\tR) Remove Cursor");

                        //Forces A Valid Option To Be Chosen For Seconday Menu
                        while(true){
                            System.out.println("Please select an option- ");
                            c = keyboard.nextLine().charAt(0);

                            if(!SecondOptions.contains(String.valueOf(c))){
                                System.out.println("Please Select a valid List");
                            }
                            else{
                                break;
                            }
                        }

                        switch(c){
                            //Adds a car to the end of the list
                            case 'A':
                            case 'a':
                                try{
                                    //Forces A Valid Input On Enum List
                                    while(true){
                                        System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln)- ");
                                        makeStr = (keyboard.nextLine()).toUpperCase();

                                        if(!make.makeCheck(makeStr)){
                                            System.out.println("Please Select a Valid Vehicle Make We Don't Service" + makeStr);
                                        }
                                        else{
                                            make = Make.valueOf(makeStr.toUpperCase());
                                            break;
                                        }
                                    }

                                    //Inputs Owner's Name
                                    System.out.println("Please Enter the Owner's Name- ");
                                    name = keyboard.nextLine();

                                    //Switch Statement To Add Car To The Proper List
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.appendToTail(new Car(make, name));

                                            System.out.println(name + "'s " + make.name() + " been scheduled for an oil change with Joe and has been added to his list.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.appendToTail(new Car(make, name));

                                            System.out.println(name + "'s " + make.name() + " been scheduled for an oil change with Donny and has been added to his list.");
                                    }
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 'F':
                            case 'f':
                                //Moves Cursor foward on currentList
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.cursorForward();

                                            System.out.println("Cursor Moved Forward in Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.cursorForward();

                                            System.out.println("Cursor Moved Forward in Donny List.");
                                    }

                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }

                                break;
                            
                            case 'H':
                            case 'h':
                                //Moves Cursor to Head
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.resetCursorToHead();

                                            System.out.println("Cursor Moved To Head in Joe's List");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.resetCursorToHead();

                                            System.out.println("Cursor Moved To Head in Donny's List");
                                    }
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            
                            case 'T':
                            case 't':
                                //Moves Cursor to Tail
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.resetCursorToTail();

                                            System.out.println("Cursor Moved To Tail in Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.resetCursorToTail();

                                            System.out.println("Cursor Moved To Tail in Donny's List.");
                                    }
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 'B':
                            case 'b':
                                //Moves Cursor foward on currentList
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.cursorBackward();

                                            System.out.println("Cursor Moved Backward in Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.cursorBackward();

                                            System.out.println("Cursor Moved Backward in Donny List.");
                                    }

                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 'I':
                            case 'i':
                                //Inserts Car Before Cursor
                                try{
                                    //Forces Valid Input On enum List
                                    while(true){
                                        System.out.println("Please enter vehicle make (Ford, GMC, Chevy, Jeep, Dodge, Chrysler, and Lincoln)- ");
                                        makeStr = (keyboard.nextLine()).toUpperCase();

                                        if(!make.makeCheck(makeStr)){
                                            System.out.println("Please Select a Valid Vehicle Make");
                                        }
                                        else{
                                            make = Make.valueOf(makeStr.toUpperCase());
                                            break;
                                        }
                                    }

                                    System.out.println("Please Enter the Owner's Name- ");
                                    name = keyboard.nextLine();

                                    //Adds Car To Proper List
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.insertBeforeCursor(new Car(make, name));

                                            System.out.println(name + "'s " + make.name() + " been scheduled for an oil change with Joe and has been added to his list before the cursor.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.insertBeforeCursor(new Car(make, name));

                                            System.out.println(name + "'s " + make.name() + " been scheduled for an oil change with Donny and has been added to his list before the cursor.");
                                    }
                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 'X':
                            case 'x':
                                //Cut car at cursor
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            car = joeList.getCursorCar();
                                            joeList.removeCursor();

                                            System.out.println("Cursor Cut in Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            car = donnyList.getCursorCar();
                                            donnyList.removeCursor();

                                            System.out.println("Cursor Cut in Donny's List.");
                                    }

                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 'V':
                            case 'v':
                                //Paste car before cursor
                                try{
                                    if(car == null){
                                        System.out.println("Nothing to Paste.");
                                        break;
                                    }

                                    switch(currentList){
                                        case 'J':
                                        case 'j':

                                            joeList.insertBeforeCursor(car);
                                            car = null;

                                            System.out.println("Car Pasted in Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.insertBeforeCursor(car);
                                            car = null;

                                            System.out.println("Car Pasted in Donny's List");
                                    }

                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                                break;

                            case 'R':
                            case 'r':
                                //Remove Cursor from list
                                try{
                                    switch(currentList){
                                        case 'J':
                                        case 'j':
                                            joeList.removeCursor();

                                            System.out.println("Cursor Removeded from Joe's List.");
                                            break;
                                        
                                        case 'D':
                                        case 'd':
                                            donnyList.removeCursor();

                                            System.out.println("Cursor Removed from Donny's List.");
                                    }

                                }
                                catch(Exception e){
                                    System.out.println(e.getMessage());
                                }

                                break;
                            
                            default:
                            System.out.println("Not a Valid Menu Option");        
                        }


                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'M':
                case 'm':
                    //Merge Job Lists
                    try{
                        while(true){
                            System.out.println("Please select a Destination list - Joe (J) or Donny (D)- ");
                            currentList = keyboard.nextLine().charAt(0);

                            if(!listPick.contains(String.valueOf(currentList))){
                                System.out.println("Please Select a valid List");
                            }
                            else{
                                break;
                            }
                        }

                        switch(currentList){
                            case 'J':
                            case 'j':
                                //Remove From Donny and add to Joe
                                carCount = donnyList.numCars();

                                donnyList.resetCursorToHead();

                                System.out.println(carCount);

                                for(int i = 0; i < carCount; i++){
                                    joeList.appendToTail(donnyList.getCursorCar());
                                    if(i == carCount - 1){
                                        break;
                                    }
                                    donnyList.cursorForward();
                                }

                                donnyList = new CarList();

                                System.out.println("Donny's List Merged into Donny's");
                                break;

                            case 'D':
                            case 'd':
                                //Remove From Joe and add to Donny
                                carCount = joeList.numCars();

                                joeList.resetCursorToHead();

                                System.out.println(carCount);

                                for(int i = 0; i < carCount; i++){
                                    donnyList.appendToTail(joeList.getCursorCar());
                                    if(i == carCount - 1){
                                        break;
                                    }
                                    joeList.cursorForward();
                                }

                                joeList = new CarList();

                                System.out.println("Joe's List Merged into Donny's");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'P':
                case 'p':
                    //Prints out the list
                    try{
                        System.out.println("Joe's List-\n----------------------\n");
                        joeList.Print();

                        System.out.println("Donny's List\n----------------------\n");
                        donnyList.Print();

                        System.out.println("Finished List\n----------------------\n");
                        finishedList.Print();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'F':
                case 'f':
                    //Paste car to finished list
                    try{
                        if(car == null){
                            System.out.println("Nothing to Paste.");
                            break;
                        }

                        finishedList.appendToTail(car);
                        car = null;

                        System.out.println("Car Pasted in Finished List");
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'S':
                case 's':
                    //Sorts the list by name
                    try{
                        while(true){
                            System.out.println("Please select a list - Joe (J) or Donny (D)- ");
                            currentList = keyboard.nextLine().charAt(0);

                            if(!listPick.contains(String.valueOf(currentList))){
                                System.out.println("Please Select a valid List");
                            }
                            else{
                                break;
                            }
                        }

                        switch(currentList){
                            case 'J':
                            case 'j':
                                joeList.sortList();

                                System.out.println("Joe's List Has Been Sorted By Name.");;
                                break;
                            
                            case 'D':
                            case 'd':
                                donnyList.sortList();

                                System.out.println("Donny's List Has Been Sorted By Name.");
                        }
                        
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'Q':
                case 'q':
                    //Quits the program
                    keyboard.close();
                    System.out.print("Enjoy Your Retirement!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a Valid Menu Option");
                }
        }
    }
}
