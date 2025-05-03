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
        this.driver =driver;
        this.common =common;
        PageFactory.initElements(driver,this);    
    }

    @FindBy (xpath = "//button[@title=\"Assign Leave\"]")
    WebElement AssignLeave;

    @FindBy (xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameTxtbx;

    // @FindBys (xpath = "//div[@role='listbox']", value = { @FindBy })
    // WebElements employeeNameList;    

    @FindBy (xpath = "//div[@role='listbox']")
    List <WebElement> empNameList;


public void clickonAssignLeave(String name){
    AssignLeave.click();
    employeeNameTxtbx.sendKeys(name);
}

public void getEmpName() throws InterruptedException{
for(WebElement empName : empNameList){
    
        common.invisibilityOfText(empName);
        System.out.println("get..."+empName.getText().trim());
        if(empName.getText().equals("AAA BBB")){
            System.out.println("cought..."+empName+" "+empName.getText());
            empName.click();
            break;
        }
    
    
}
}

}
