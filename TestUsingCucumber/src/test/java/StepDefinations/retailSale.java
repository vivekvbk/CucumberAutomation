package StepDefinations;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class retailSale {
	WebDriver wd;
	
	@Given("^User is on login Page$")
	public void user_is_on_login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
		
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wd.get("http://demo.educarecentre.in/");
		wd.manage().window().maximize();
			   
	}

	@When("^Credential are correct$")
	public void credential_are_correct() throws Throwable {
		//username
				wd.findElement(By.name("uname")).sendKeys("vivek@10001");
				//password
				wd.findElement(By.name("passwd")).sendKeys("Softcon@123");
				//Click on Login
				wd.findElement(By.id("idbtnUserLogin")).click();
				//wait
				Thread.sleep(2000); // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^Counter is selected$")
	public void counter_is_selected() throws Throwable {
		//Counter Dropdown

		wd.findElement(By.id("slct")).click();

		WebElement ele = wd.findElement(By.xpath("//Select[@id='slct']"));
		Select sel =new Select (ele);
		sel.selectByIndex(2);

		wd.findElement(By.xpath("//*[@id=\"CounterModal\"]/div/div/div/app-common-counter-type/form/div[3]/button")).click();
		Thread.sleep(5000);	   
	}

	@Then("^Company Location is Selected$")
	public void company_Location_is_Selected() throws Throwable {
		//location Change
		wd.findElement(By.xpath("//a[@id='noDownArrow']/img[@class='img-circle']")).click();
		wd.findElement(By.xpath("//div[@id='bs-example-navbar-collapse-1']/ul//ul[@class='dropdown-menu dropdown-menu-right show']/div[2]/div[2]/li\r\n"+ "")).click();
		WebElement Loc= wd.findElement(By.xpath("//select[@id='slct']"));
		Loc.click();
		Select location =new Select (Loc);
		location.selectByVisibleText("Testing");
		Loc.click();
		Thread.sleep(2000);
		//Loc.sendKeys(Keys.TAB);
		//Loc.sendKeys(Keys.TAB);
		//Loc.sendKeys(Keys.ENTER);
		wd.findElement(By.xpath("//button[normalize-space()='OK']")).click();

	}

	@Then("^Finanical year is selected$")
	public void finanical_year_is_selected() throws Throwable {
		//Financial Year Selection
		Select Fy=new Select(wd.findElement(By.xpath("/html//select[@id='slct']")));
		Fy.selectByVisibleText("2021-2022");
		wd.findElement(By.xpath("//button[normalize-space()='OK']")).click();	  
	}

	@Then("^Search for \"(.*)\" Master form$")
	public void search_for_FormName_Master_form(String FormName) throws Throwable {
		//Search Master

		wd.findElement(By.xpath("//input[@id='idMenu2']")).sendKeys(FormName);
		Thread.sleep(2000);
		WebElement Search= wd.findElement(By.xpath("//input[@id='idMenu2']"));
		Search.sendKeys(Keys.ENTER);	   
	}

	@Then("^if Draft Entries are present then click on Ignore$")
	public void if_Draft_Entries_are_present_then_click_on_Ignore() throws Throwable {
		//Select Salesman
		
		wd.findElement(By.xpath("//button[@class='btn btn-default btn-sm ng-star-inserted']")).click();
		if (wd.findElement(By.id("SalesOrderdraftignore")) != null)
		{
			wd.findElement(By.id("SalesOrderdraftignore")).click();
		}
		else{	
			wd.findElement(By.xpath("//input[@id='SalesPersonID']")).click();
			Thread.sleep(2000);
		}
}

	@Then("^Enter \"(.*)\" name$")
	public void enter_SalesPerson_name(String SalesPerson) throws Throwable {
		wd.findElement(By.xpath("//input[@id='SalesPersonID']")).sendKeys(SalesPerson);
		wd.findElement(By.xpath("//input[@id='SalesPersonID']")).sendKeys(Keys.ENTER);
		//wd.findElement(By.xpath("//div[@id='mat-autocomplete-16']")).click();    
	}

	@Then("^Enter \"(.*)\" Code$")
	public void enter_SKU_Code(String SKU) throws Throwable {
		//Enter SKU

		WebElement SKUEle= wd.findElement(By.xpath("//input[@id='sku']"));
		SKUEle.sendKeys(SKU);
		SKUEle.sendKeys(Keys.ENTER);

	  
	}

	@Then("^Enter QTY$")
	public void enter_QTY() throws Throwable {
		//Enter Qty

		WebElement QTY = wd.findElement(By.xpath("//input[@id='DecimalQty-0-RetailSalesEntryTableCols_1']"));
		QTY.sendKeys("2");
		System.out.println(QTY);
		
	}
	
	@Then("^Enter Payment Amount$")
	public void enter_Payment_Amount() throws Throwable {
		//Card payment

		WebElement Card=wd.findElement(By.xpath("//input[@id='Card']"));
		Card.sendKeys("100");
	   
	}

	@Then("^Click on Save Button$")
	public void click_on_Save_Button() throws Throwable {
		// Click on Save Button
		wd.findElement(By.xpath("//app-root/app-home-layout[@class='ng-star-inserted']/app-navigation/mat-sidenav-container/mat-sidenav-content[@class='mat-drawer-content mat-sidenav-content']/div[@class='row']//app-retail-sales-entry[@class='ng-star-inserted']/div[@class='container-fluid removePadding']/div/div[@class='col-lg-6 col-md-8 col-sm-8']/div/div[2]/div/span[@class='input-group-append']/button[3]")).click();
	   
	}

	@Then("^Sales Saved Successfully message display$")
	public void sales_Saved_Successfully_message_display() throws Throwable {
		WebElement Toast= wd.findElement(By.xpath("//div[@id='toast-container']//div[@role='alertdialog']"));
		if(Toast != null) {
		String Msg =	Toast.getText();
		System.out.println(Msg);
	    
	}
}
	}
