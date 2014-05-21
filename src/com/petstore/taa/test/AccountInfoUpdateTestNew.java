package com.petstore.taa.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.PageFactory;

import com.petstore.taa.page.AccountsPage;
import com.petstore.taa.page.UpdateAccountPage;
import com.petstore.taa.page.WelcomePage;
import com.petstore.taa.task.SignInTask;
import com.petstore.taa.test.suite.SlowTests;

/**
 * Step 4. 
 * In this class following approach/technique/patterns will be presented:
 * 	- presenting another way to use PageObjects pattern with a usage of
 * 	  PageFactory and FindBy annotations
 * 	- usage of previously created task object
 * 	- harmcrest verification
 *  - launching test on a SauceLabs + SauceLabs configuration
 * 
 * @author michalkoz
 * 
 */
@Category(SlowTests.class)
public class AccountInfoUpdateTestNew extends BaseTest {

	private WelcomePage welcomePage;
	private SignInTask signInTask;

	@Before
	public void setUp() {
		welcomePage = new WelcomePage(webDriver);
		signInTask = new SignInTask(webDriver);
	}

	@Test
	public void testAccountInfoUpdate() throws Exception {
		signInTask
			.signInAs("user", "user");

		welcomePage
			.navigateToAccountsPage();
		
		AccountsPage accountsPage = PageFactory.initElements(webDriver, AccountsPage.class);
		accountsPage
			.clickEditYourAccountInformation();
		
		String namePrefix = "Michal";
		String firstNameNewValue = namePrefix+new Date().getTime();
		UpdateAccountPage updateAccountPage = PageFactory.initElements(webDriver, UpdateAccountPage.class);
		updateAccountPage
			.enterFirstName(firstNameNewValue)
			.submit();
		
		assertThat(accountsPage.getAlertMessage(), is("Your account has been updated"));
		assertThat(accountsPage.getFirstName(), is(firstNameNewValue));
		assertThat(accountsPage.getFirstName(), containsString(namePrefix));
		
	}

}
