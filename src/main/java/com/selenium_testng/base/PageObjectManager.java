package com.selenium_testng.base;

import org.openqa.selenium.WebDriver;

import com.selenium_testng.pages.Admin;
import com.selenium_testng.pages.Buzz;
import com.selenium_testng.pages.Claim;
import com.selenium_testng.pages.Dashboard;
import com.selenium_testng.pages.Directory;
import com.selenium_testng.pages.Leave;
import com.selenium_testng.pages.LeaveEntitlements;
import com.selenium_testng.pages.Login;
import com.selenium_testng.pages.Maintenance;
import com.selenium_testng.pages.Myinfo;
import com.selenium_testng.pages.PIM;
import com.selenium_testng.pages.Performance;
import com.selenium_testng.pages.Recruitment;
import com.selenium_testng.pages.Time;
import com.selenium_testng.utils.commonMethods;
import com.selenium_testng.utils.screenshotListener;

public class PageObjectManager {
    WebDriver driver;
    screenshotListener capture;
    commonMethods common;
    Login login;
    Dashboard dashboard;
    LeaveEntitlements leaveentitlements;
    Admin admin;
    PIM pim;
    Leave leave;
    Maintenance maintanance;
    Recruitment recruitment;
    Myinfo myinfo;
    Performance performance;
    Time time;
    Directory directory;
    Claim claim;
    Buzz buzz;

    public PageObjectManager(WebDriver driver, commonMethods common) {

        this.driver = driver;
        this.common = common;
    }

    public screenshotListener getScreenshotObject() {
        if (capture == null) {
            capture = new screenshotListener(driver);
        }
        return capture;

    }

    public Login getLoginPageObject() {
        if (login == null) {
            login = new Login(driver, common);
        }
        return login;
    }

    public Dashboard getDashboardPageObject() {
        if (dashboard == null) {
            dashboard = new Dashboard(driver, common);
        }
        return dashboard;
    }

    public LeaveEntitlements getleaveentitlementsPageObject() {
        if (leaveentitlements == null) {
            leaveentitlements = new LeaveEntitlements(driver, common);
        }
        return leaveentitlements;
    }

    public Admin getAdminPageObject() {
        if (admin == null) {
            admin = new Admin(driver, common);
        }
        return admin;
    }

    public Maintenance getMaintenancePageObject() {
        if (maintanance == null) {
            maintanance = new Maintenance(driver, common);
        }
        return maintanance;
    }

    public PIM getPIMPageObject() {
        if (pim == null) {
            pim = new PIM(driver, common);
        }
        return pim;
    }

    public Leave getLeavePageObject() {
        if (leave == null) {
            leave = new Leave(driver, common);
        }
        return leave;
    }

    public Time getTimePageObject() {
        if (time == null) {
            time = new Time(driver, common);
        }
        return time;
    }

    public Recruitment getRecruitmentPageObject() {
        if (recruitment == null) {
            recruitment = new Recruitment(driver, common);
        }
        return recruitment;
    }

    public Myinfo getMyInfoPageObject() {
        if (myinfo == null) {
            myinfo = new Myinfo(driver, common);
        }
        return myinfo;
    }

    public Performance getPerformancePageObject() {
        if (performance == null) {
            performance = new Performance(driver, common);
        }
        return performance;
    }

    public Directory getDirectoryPageObject() {
        if (directory == null) {
            directory = new Directory(driver, common);
        }
        return directory;
    }

    public Claim getClaimPageObject() {
        if (claim == null) {
            claim = new Claim(driver, common);
        }
        return claim;
    }

    public Buzz getBuzzPageObject() {
        if (buzz == null) {
            buzz = new Buzz(driver, common);
        }
        return buzz;
    }
}
