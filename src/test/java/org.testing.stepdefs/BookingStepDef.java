package org.testing.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.pages.BookingPage;
import org.testing.pages.HomePage;
import org.testng.Assert;

import java.time.Duration;

public class BookingStepDef {
    private WebDriver driver;
    HomePage homePage;
    BookingPage bookingPage;
    String dateValue = "Thursday, 28 September 2023";

    @Before
    public void setup()
    {
        // if (Browser = "Chrome") {
        driver = new ChromeDriver();
        // } else if (Browser - "Firefox") {
        // driver = new FirefoxDriver();
        //}
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.circlehealthgroup.co.uk/");
    }

    @Given("I am on the booking appoinment page")
    public void iAmOnTheBookingAppoinmentPage() {
        homePage.NavigateToBookingPage();
    }

    @Given("I am a patient wanting a knee replacement")
    public void iAmAPatientWantingAKneeReplacement() {
        bookingPage.FindAppoinment();
    }

    @When("I put in my location and date of leave {string}")
    public void iPutInMyLocationAndDateOfLeave(String arg0, String arg1) {
        bookingPage.DatePick(driver,dateValue);
    }


    @Then("I can get a {string} and {string} availability provided to make my decision")
    public void iCanGetAAndAvailabilityProvidedToMakeMyDecision(String arg0, String arg1, String arg2, String arg3) {
        // Assert.assertTrue(driver.findElement(By.id("consultant-list")).isDisplayed());


    }
}
