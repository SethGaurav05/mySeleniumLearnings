package com.facebookRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookRegistrationPage {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		wd.get("https://en-gb.facebook.com/");
		wd.manage().window().maximize();

		// Create Button Locator
		By createAccountButtonLocator = By.xpath("//a[@data-testid=\"open-registration-form-button\"]");
		WebElement createAccountButton = wd.findElement(createAccountButtonLocator);
		createAccountButton.click();
		Thread.sleep(5000);

		// Verification of SignUp form
		By signUpFormVerificationLocator = By.xpath("//div[@class=\"_n3\"]");
		WebElement signUpForm = wd.findElement(signUpFormVerificationLocator);
		Boolean flag = signUpForm.isDisplayed();
		if (flag)
			System.out.println("Signup form displayed");
		else
			System.out.println("Signup form not displayed");

		// Filling First Name
		By firstNameTextBoxLocator = By.xpath("//input[@name=\"firstname\"]");
		WebElement firstNameTextBox = wd.findElement(firstNameTextBoxLocator);
		firstNameTextBox.sendKeys("Gaurav");

		// Filling Last Name
		By lastNameTextBoxLocator = By.xpath("//input[@name=\"lastname\"]");
		WebElement lastNameTextBox = wd.findElement(lastNameTextBoxLocator);
		lastNameTextBox.sendKeys("Seth");

		// Filling Registered Email
		By regEmailTextBoxLocator = By.xpath("//input[@name=\"reg_email__\"]");
		WebElement regEmailTextBox = wd.findElement(regEmailTextBoxLocator);
		regEmailTextBox.sendKeys("gaurav_0005@gmail.com");

		// Filling Registered Email
		By confirmEmailTextBoxLocator = By.xpath("//input[@name=\"reg_email_confirmation__\"]");
		WebElement confirmEmailTextBox = wd.findElement(confirmEmailTextBoxLocator);
		confirmEmailTextBox.sendKeys("gaurav_0005@gmail.com");

		// Filling password
		By regPasswordTextBoxLocator = By.xpath("//input[@name=\"reg_passwd__\"]");
		WebElement regPasswordTextBox = wd.findElement(regPasswordTextBoxLocator);
		regPasswordTextBox.sendKeys("Gaurav@005");

		// Select Date of Birth
		By daySelectLocator = By.xpath("//select[@id=\"day\"]");
		WebElement daySelectDropDown = wd.findElement(daySelectLocator);
		Select daySelect = new Select(daySelectDropDown);
		daySelect.selectByIndex(5);

		// Select Month of Birth
		By monthSelectLocator = By.xpath("//select[@id=\"month\"]");
		WebElement monthSelectDropDown = wd.findElement(monthSelectLocator);
		Select monthSelect = new Select(monthSelectDropDown);
		monthSelect.selectByVisibleText("Oct");

		// Select Year of Birth
		By yearSelectLocator = By.xpath("//select[@id=\"year\"]");
		WebElement yearSelectDropDown = wd.findElement(yearSelectLocator);
		Select yearSelect = new Select(yearSelectDropDown);
		yearSelect.selectByValue("2000");

		// Select Gender
		By maleRadioButtonLocator = By.xpath("//label[text()=\"Male\"]");
		WebElement maleRadioButton = wd.findElement(maleRadioButtonLocator);
		maleRadioButton.click();

		// Click submit on SignUp form
		By signUpButtonLocator = By.xpath("//button[@name=\"websubmit\"]");
		WebElement signUpButton = wd.findElement(signUpButtonLocator);
		signUpButton.click();
		Thread.sleep(5000);
		
		// Verification of Alert message
		By registrationErrorAlertLocator = By.xpath("//div[@id=\"reg_error_inner\" ]");
		WebElement registrationErrorAlert = wd.findElement(registrationErrorAlertLocator);
		flag = registrationErrorAlert.isDisplayed();
		if (flag)
			System.out.println("Registration error displayed");
		else
			System.out.println("Registration error not displayed");
		Thread.sleep(5000);
		 wd.quit();
	}
}
