package JUnitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	   public void test_Monthly() {
	      System.out.println("Test if pricePerMonth is correct...") ;
	      JUnitExample S = new JUnitExample(200,2) ;
	      assertTrue(S.simpleDivision() == 100) ;
	   }

	   @Test
	   public void test_monthlytwo() {
	      System.out.println("Testing again...") ;
	      JUnitExample S = new JUnitExample(200,4) ;
	      assertTrue(S.simpleDivision() == 50) ;
	   }

	   @Test
		public void testConcatenate() {
		   System.out.println("Testing word concatenation...") ;
			JUnitString test = new JUnitString();
			String fullWord = test.concatenate("Hello", "World");
			assertEquals("HelloWorld", fullWord);
			System.out.println();
		}
	   
	   @Test
	   public void test_multiplication() {
	      System.out.println("Testing multiplication...") ;
	      JUnitExample multiply = new JUnitExample(200,4) ;
	      assertTrue(multiply.simpleMultiplication() == 800) ;
	   }
	   
	   @Test
	   public void test_addition() {
	      System.out.println("Testing addition...") ;
	      JUnitExample addition = new JUnitExample(200,4) ;
	      assertTrue(addition.simpleAddition() == 204) ;
	   }
	   
	   @Test
	   public void test_subtraction() {
	      System.out.println("Testing subtraction...") ;
	      JUnitExample subtraction = new JUnitExample(200,4) ;
	      assertTrue(subtraction.simpleSubtraction() == 196) ;
	   }
	   
}
