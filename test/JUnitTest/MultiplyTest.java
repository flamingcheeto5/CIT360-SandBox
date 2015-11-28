/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public void testMultiply() {
		
		Junit test = new  Junit();
		int result = test.multiply(3, 4);
		assertEquals(12, result);
		
	}

}
