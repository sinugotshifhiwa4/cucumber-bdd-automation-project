package com.orangehrm.stepDefinitions;

import com.orangehrm.reusableComponents.ConfigProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.picocontainer.annotations.Inject;

public class OrangehrmStepDefinitions {

    private final BaseStepDef baseDef;

    public OrangehrmStepDefinitions(BaseStepDef baseDef) {
        this.baseDef = baseDef;
    }

    @Given("User is on the OrangeHRM login page")
    public void userIsOnTheOrangeHRMLoginPage() {
        baseDef.wait.until(ExpectedConditions.visibilityOf(baseDef.loginPage.getOrangehrmLogoElement()));
        baseDef.loginPage.verifyOrangehrmLogoIsVisible();
    }

    @When("User enters username and password and clicks the login button")
    public void userEntersUsernameAndPasswordAndClicksTheLoginButton() {
        baseDef.loginPage.loginToOrangehrm(ConfigProperties.getPropertyByKey("username"), ConfigProperties.getPropertyByKey("password"));
    }

    @Then("User is navigated to the OrangeHRM dashboard")
    public void userIsNavigatedToTheOrangeHRMDashboard() {
        baseDef.wait.until(ExpectedConditions.visibilityOf(baseDef.loginPage.getDashboardTabElement()));
        baseDef.loginPage.verifyDashboardTabIsVisible();
    }

    @Given("User is on the OrangeHRM dashboard")
    public void userIsOnTheOrangeHRMDashboard() {
        baseDef.wait.until(ExpectedConditions.visibilityOf(baseDef.loginPage.getDashboardTabElement()));
        baseDef.loginPage.verifyDashboardTabIsVisible();
    }

    @When("User navigates to the Admin tab")
    public void userNavigatesToTheAdminTab() {
    }

    @And("User clicks the Add button")
    public void userClicksTheAddButton() {
    }

    @And("User fills in all required fields")
    public void userFillsInAllRequiredFields() {
    }

    @And("User clicks the Save button")
    public void userClicksTheSaveButton() {
    }

    @Then("User should see a confirmation message indicating the user has been added successfully")
    public void userShouldSeeAConfirmationMessageIndicatingTheUserHasBeenAddedSuccessfully() {
    }
}
