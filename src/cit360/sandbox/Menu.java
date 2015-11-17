package cit360.sandbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;


public class Menu
{
    public final static Sql_Connect Sql_Connect = new Sql_Connect();
    public final static Http_Connection Http_Connection = new Http_Connection(); 
    
public final static String [][] Selection = {
        {"M", "Show Movie Times"},
        {"L", "Movie Theatre List"},
        {"P", "Movie Ticket Prices"},
        {"X", "Exit Program"}
    };      
    public final static void mainMenu(){

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do{
            CIT360SandBox.App.display();
                
                command = inFile.nextLine();
                command = command.trim().toUpperCase(); //changes input to always be uppercase, in case someone inputs a lowercase letter. 
                
                switch (command){
                   case "M":
                   CIT360SandBox.Sql_Connect.connect(); 
                   break;
                   
                   case "C":
                   CIT360SandBox.Http_Connection.connectiontest(); 
                   break;    
                 
                   case "L": 
                    Menu.purchaseTicketsCompanyList();
                    break;
                    
                case "P": 
                    Menu.ticketPrices();
                    break;    
                
                case "X":  //breaks from the options menu. 
                        break;
                    default:
                        System.out.println("Invalid Choice. Please select another option.");  //pints out an error when one of the above listed options is not selected. 
                    }
                }
                
            while (!command.equals("X")); //continues to run the main menu until X is selected to end it. 
    }
    
    public static void purchaseTicketsCompanyList(){
      List companyList = new ArrayList();  // A List contains instances of Object. Upcast ArrayList to List
      companyList.add("AMC Theatres");            // add() takes Object. String upcast to Object implicitly
      companyList.add("Cinemark Theatres");
      companyList.add("Megaplex Theatres");
      companyList.add("Regal Entertainment Theatres");
      companyList.add("Fandango");
      companyList.add("Moviefone");
      
      Iterator iter = companyList.iterator();
      while (iter.hasNext()) {      // any more element
         // Retrieve the next element, explicitly downcast from Object back to String
         String str = (String)iter.next();
         System.out.println(str);

      }
    }
    
    public static void ticketPrices() {
		TreeMap ageGroup = new TreeMap();
		
		// Add some ageGroup.
		ageGroup.put("Adult", 8.75);
		ageGroup.put("Child", 5.50);
		ageGroup.put("Senior Citizen", 5.25);
		ageGroup.put("Military Veteran", 5.00);
		
		// Iterate over all ageGroup, using the keySet method.
		for(Object key: ageGroup.keySet())
			System.out.println(key + " - $" + ageGroup.get(key));
		System.out.println();
		
		System.out.println("Highest key: " + ageGroup.lastKey());
		System.out.println("Lowest key: " + ageGroup.firstKey());
		
		System.out.println("\nPrinting all values: ");
		for(Object val: ageGroup.values())
			System.out.println("$" + val);
		System.out.println();
		
		// Clear all values.
		ageGroup.clear();
		
		// Equals to zero.
		System.out.println("After clear operation, size: " + ageGroup.size());
    }
    public final void display (){
        System.out.println("\n\t************************************************************"); //decoration. 
        System.out.println("\tEnter the letter for your selection from the main menu:"); //simple output message. 
        for (String[] mainMenuItem : Menu.Selection) {
            System.out.println("\t  " + mainMenuItem[0] + "\t" + mainMenuItem[1]);
        }
        System.out.println("\t************************************************************\n");
    }
   }       

