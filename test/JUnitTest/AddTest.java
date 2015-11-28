/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;
import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void testAdd () {
		Junit test = new  Junit();
		int result = test.add(3, 4);
		assertEquals(7, result);		
	}

}
