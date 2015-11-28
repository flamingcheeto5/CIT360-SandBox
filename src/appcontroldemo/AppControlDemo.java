/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcontroldemo;

import java.util.Scanner;

/**
 *
 * @author christianray
 */
public class AppControlDemo
{
  public static void main( String[] args )
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Please type Peanuts, Creed, or Spectre to go to the appropriate Review.");
    AppController app = new AppController();
    app.dispatchRequest(input.next());
      
  }
}