package org.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BookingPage extends Utils {

    // Locators
    By treatmentBox = By.xpath("//input[@id='treatment']");
    By locationBox = By.cssSelector("#location");
    By DateEle=By.xpath("(//span[@aria-label='Thursday, 28 September 2023'][normalize-space()='28'])[2]");
    By bookingDetail=By.xpath("//p[@class=\"consultant-costs--date\"]");
    // Page Methods//Actions

    public void FindAppoinment() {

        WebElement treatment = driver.findElement(treatmentBox);

        // Use JavascriptExecutor to set the autocomplete attribute to "off"
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('autocomplete', 'off');", treatment);

        // Now, you can interact with the treatment field without autocomplete
        treatment.sendKeys("Knee replacement surgery");

        WebElement location = driver.findElement(locationBox);
        jsExecutor.executeScript("arguments[0].setAttribute('autocomplete', 'off');", location);
        location.sendKeys("Harrow, UK ");
    }

    public void DatePick(WebDriver driver, String date) {
        WebElement element = driver.findElement(DateEle);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('.', '" + date + "');", element);

    }

    public void DateSelect() {
        // Month and year
        while (true) {
            String monthYear = driver.findElement(By.cssSelector("div[class='vc-pane row-from-end-2 column-from-end-1'] div[class='vc-title']")).getText();
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else
                driver.findElement(By.xpath("//button[normalize-space()='Show more appointments']")).click();
        }

        //(//span[@aria-label='Thursday, 28 September 2023'][normalize-space()='28'])[1]
        //Date selection
        List<WebElement> allDate = driver.findElements(By.xpath("(//span[@aria-label='Thursday, 28 September 2023'][normalize-space()='28'])[1]"));
        for (WebElement ele : allDate) {
            String dt = ele.getText();

            if (dt.equalsIgnoreCase(day)) {
                ele.click();
                break;
            }
        }
    }

    public void verify(){
        WebElement booking= driver.findElement(bookingDetail);
        String BookingInfo =booking.getText();
        Assert.assertTrue(BookingInfo.contains("Mr Satyajit Naique"));
        Assert.assertTrue(BookingInfo.contains("12:10"));

    }
}


