package org.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Utils{
    private WebDriver driver;

    // Locators
    private By acceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private By bookingButton=By.xpath("//a[@class='f-btn f-btn-tertiary f-btn--no-shadow']//span[@class='f-visible-large-xlarge text'][normalize-space()='Book an appointment']");


    // Page Methods//Actions
    public void NavigateToBookingPage() {
        WebElement cookies = driver.findElement(acceptCookies);
        cookies.click();

        WebElement booking = driver.findElement(bookingButton);
        booking.click();
    }
}
