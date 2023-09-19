package org.testing.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;


    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
