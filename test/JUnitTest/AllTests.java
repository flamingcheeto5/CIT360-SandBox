/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author DBanks
 */
@RunWith(Suite.class)
@SuiteClasses({ AddTest.class, MultiplyTest.class })
public class AllTests {

}