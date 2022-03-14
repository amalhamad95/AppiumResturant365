package tests;

import org.junit.Test;

import ui.login.LoginActions;
import ui.login.LoginAssertions;

public class LoginTest extends BaseTest {

	LoginActions loginActions = new LoginActions();
	LoginAssertions loginAssertions = new LoginAssertions();

	@Test
	public void loginToApp() throws InterruptedException {
		loginActions.typeInUserName("tester1").clickNextButton().typeInPassword("123").clickLoginButton();

		System.out.println("Login Successfully");

		loginAssertions.verifyDashboard();
		System.out.println("Assertion Successfully");
	}

}
