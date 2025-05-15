package com.selenium_testng.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class LeaveEntitlements<WebElements> {
    WebDriver driver;
    commonMethods common;

    public LeaveEntitlements(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title=\"Assign Leave\"]")
    WebElement AssignLeave;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameTxtbx;

    // @FindBys (xpath = "//div[@role='listbox']", value = { @FindBy })
    // WebElements employeeNameList;

    @FindBy(xpath = "//div[@role='option']")
    List<WebElement> empNameList;

    public void clickonAssignLeave() {
        common.waitAndClick(AssignLeave);

    }

    public void enterEmployeeName(String name) {
        employeeNameTxtbx.sendKeys(name);
    }

    public void selectEmpName(String name) throws InterruptedException {
        common.WaitTillSearchDisappeared(empNameList);

        for (WebElement empName : empNameList) {
            if (empName.getText().replaceAll("\\s", " ").equals(name)) {
                System.out.println("finding = " + name);
                System.out.println("found = " + empName.getText());
                empName.click();
                break;
            }

        }
    }
}
