package org.testing.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test extends Utils {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        By acceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
        By bookingButton = By.xpath("//a[@class='f-btn f-btn-tertiary f-btn--no-shadow']//span[@class='f-visible-large-xlarge text'][normalize-space()='Book an appointment']");
        By treatmentBox = By.xpath("//input[@id='treatment']");
        By locationBox = By.cssSelector("#location");
        By hospitalBox =By.xpath("/label[@for=\"hospital\"]");
        By SearchButton = By.xpath("//button[@class=\"f-btn f-btn-xlarge f-btn-primary\"]");

        By kneeSelect =By.xpath("//div[@class=\"f-dropdown\"]//li[@data-value='Knee replacement surgery']");
        // Page Methods//Actions

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.circlehealthgroup.co.uk/");
        WebElement cookies = driver.findElement(acceptCookies);
        cookies.click();

        WebElement booking = driver.findElement(bookingButton);
        booking.click();

        WebElement treatment = driver.findElement(treatmentBox);

        //div[@class="f-dropdown"]//li[@data-value='Knee replacement surgery']
        //treatment.sendKeys("Knee replacement surgery");
        //WebElement knee = driver.findElement(kneeSelect);
        //knee.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Use JavascriptExecutor to set the autocomplete attribute to "off"
         jsExecutor.executeScript("arguments[0].setAttribute('autocomplete', 'off');", treatment);

        // Now, you can interact with the treatment field without autocomplete
        treatment.sendKeys("Knee replacement surgery");

        WebElement location = driver.findElement(locationBox);
        // jsExecutor.executeScript("arguments[0].setAttribute('autocomplete', 'off');", location);
        location.sendKeys("Hounslow TW6 1QG,UK");
        location.sendKeys(Keys.ENTER);

        WebElement search = driver.findElement(SearchButton);
        search.click();

        DatePicker();
        WebElement date = driver.findElement(By.xpath(""));
        String dateValue = "Thursday, 28 September 2023";
        SelectDateByJS(driver,date,dateValue);


    }
    }
