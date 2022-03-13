package ui.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tests.BaseTest;

public class Login extends BaseTest {

	@AndroidFindBy(id = "et_username")
	MobileElement usernameInput;

	@AndroidFindBy(id = "btn_next")
	MobileElement nextButton;

	@AndroidFindBy(id = "et_password")
	MobileElement passwordInput;

	@AndroidFindBy(id = "btn_login")
	MobileElement loginButton;

	@AndroidFindBy(xpath = "//*[contains(@text, 'OPEN REQUESTS')]")
	MobileElement dashboardText;
}
