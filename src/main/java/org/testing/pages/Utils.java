package org.testing.pages;

import org.openqa.selenium.*;

import java.util.List;

public class Utils extends BasePage {


        static String year = "2023";
        static String month = "September";// div[class='vc-pane row-from-end-2 column-from-end-1'] div[class='vc-title']"))
        //String month ="Octomber";//div[class='vc-pane row-from-end-2 column-from-end-1'] div[class='vc-title']
        static String day = "28";

    public Utils(WebDriver driver) {
        super(driver);
    }

    public static void DatePicker() {

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

        public static void SelectDateByJS(WebDriver driver,WebElement element,String date){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('.', '"+date+"');", element);

        }
    }
