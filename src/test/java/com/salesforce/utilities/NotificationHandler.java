package com.salesforce.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationHandler {
    WebDriver driver;
    WebDriverWait wait;

    public NotificationHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void dismissNotificationIfPresent() {
        try {
            // Adjust the selector based on the actual notification element
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notification-banner")));
            WebElement dismissButton = notification.findElement(By.cssSelector(".dismiss-button"));
            dismissButton.click();
        } catch (Exception e) {
            // No notification found
            System.out.println("No notification to dismiss.");
        }
    }
}
