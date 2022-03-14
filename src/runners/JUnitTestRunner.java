package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.InventoryCountTests;
import tests.LoginTest;

@RunWith(Suite.class)
@SuiteClasses({ LoginTest.class, InventoryCountTests.class })

public class JUnitTestRunner {

}
