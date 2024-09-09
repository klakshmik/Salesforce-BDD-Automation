package com.salesforce.stepdefinitions;

import com.salesforce.utilities.BrowserUtils;
import com.salesforce.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "pre" and "post" condition
for ALL the SCENARIOS and even STEPS.
 */

public class Hooks {



        //import the @Before coming from io.cucumber.java
      //  @Before will be executed automatically before EVERY scenario in the project.

        @Before(order = 1)
        public void setupMethod(){
            System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");

            Driver.getDriver();
        }


        public void login_scenario_before(){
            System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
        }

        /*
        @After will be executed automatically after EVERY scenario in the project.
         */
        @After
        public void tearDownMethod(Scenario scenario){

            if (scenario.isFailed()) {

                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());

            }

            System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");

            BrowserUtils.sleep(2);
            Driver.closeDriver();

        }

        //@BeforeStep
        public void setupStep(){
            System.out.println("-----> @BeforeSTEP : Running before each step!");
        }

        //@AfterStep
        public void tearDownStep(){
            System.out.println("-----> @AfterSTEP : Running after each step!");
        }




}
