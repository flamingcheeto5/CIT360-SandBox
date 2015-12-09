package cit360.sandbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class Menu
{
    public final static BackEndMenu BackEndMenu = new BackEndMenu();

    
public final static String [][] Selection = {
        {"C", "HTTP Connection Test"},
        {"I", "I/O SMTP example"},
        {"M", "Show Movie Times"},
        {"L", "Movie Theatre List"},
        {"P", "Movie Ticket Prices"},
        {"X", "Exit Program"}
    };      
    public final static void mainMenu() throws Exception{

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do{
            CIT360SandBox.App.display();
                
                command = inFile.nextLine();
                command = command.trim().toUpperCase(); //changes input to always be uppercase, in case someone inputs a lowercase letter. 
                
                switch (command){
                                    
                   case "C":
                   CIT360SandBox.Sql_Connect.urltest(); 
                   break; 
                       
                   case "I":
                   CIT360SandBox.Sql_Connect.smtpExample();
                   break; 
                       
                   case "M":
                   CIT360SandBox.Sql_Connect.connect(); 
                   break;      
                       
                   case "L": 
                    CIT360SandBox.Sql_Connect.purchaseTicketsCompanyList();
                    break;
                    
                case "P": 
                    CIT360SandBox.Sql_Connect.ticketPrices();
                    break;    
                
                case "X":  //breaks from the options menu. 
                        break;
                    default:
                        System.out.println("Invalid Choice. Please select another option.");  //pints out an error when one of the above listed options is not selected. 
                    }
                }
                
            while (!command.equals("X")); //continues to run the main menu until X is selected to end it. 
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

