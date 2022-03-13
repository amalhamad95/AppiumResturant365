package tests;

import org.junit.Test;

import ui.InventoryCount.InventoryCountActions;
import ui.InventoryCount.InventoryCountAssertions;
import ui.login.LoginActions;
import ui.login.LoginAssertions;

public class LoginTest extends BaseTest {

	LoginActions loginActions = new LoginActions();
	LoginAssertions loginAssertions = new LoginAssertions();

	InventoryCountActions actions = new InventoryCountActions();
	InventoryCountAssertions assertions = new InventoryCountAssertions();

	@Test
	public void loginToApp() throws InterruptedException {
		loginActions.typeInUserName("m.naji13")//
				.clickNextButton()//
				.typeInPassword("123")//
				.clickLoginButton();

		System.out.println("Login Successfully");

		loginAssertions//
				.verifyDashboard();
		System.out.println("Assertion Successfully");

		actions.openNavigationMenu()//
				.navigateToInventoryCount();
	}

}
