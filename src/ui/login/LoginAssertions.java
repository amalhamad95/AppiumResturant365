package ui.login;


import org.junit.Assert;
import org.junit.Test;

import tests.BaseTest;

public class LoginAssertions {

	Login page = new Login();

	@Test
	public LoginAssertions verifyDashboard() {
		BaseTest.waitVisibilityOf(page.dashboardText);
		Assert.assertTrue(page.dashboardText.isDisplayed());
		return this;
	}

}
