package toggle;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TodoListPage {
	static WebDriver driver;
	

	@Before
	
	public void init(){
		//setup for system property
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(co);
		//delete cookies
		driver.manage().deleteAllCookies();
		//go to website
		driver.get("http://techfios.com/test/101/");
		
		driver.manage().window().maximize();}
	
	
	
	@Test
	public void testToggleAllCheckbox() {
	    // Identify the toggle all checkbox and the list of checkboxes for the list items.
	    WebElement toggleAllCheckbox = driver.findElement(By.name("allbox"));
	    List<WebElement> listItemCheckboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\" i]"));
	    
	    // Simulate a user interaction by programmatically clicking the toggle all checkbox to check it.
	    toggleAllCheckbox.click();
	    
	    // Verify that all the checkboxes for the list items are also checked on.
	    for (WebElement listItemCheckbox : listItemCheckboxes) {
	        assertTrue(listItemCheckbox.isSelected());
	    }
	}
	
	@Test
	public void testRemoveSingleListItem() {
	    // Identify the list item, checkbox, and remove button.
	    WebElement listItem = driver.findElement(By.cssSelector("#todos-content > form > ul"));
	    WebElement checkbox = listItem.findElement(By.tagName("li"));
	    WebElement removeButton = listItem.findElement(By.tagName("input"));
	    
	    // Simulate a user interaction by programmatically clicking on the checkbox to select it.
	    checkbox.click();
	    
	    // Simulate a user interaction by programmatically clicking on the remove button.
	    removeButton.click();
	    
	    // Verify that the list item has been removed from the list.
	   List<WebElement> listItems = driver.findElements(By.cssSelector("form"));
	    assertFalse(listItems.contains(listItem));
	}
	
	@Test
	public void removeeAllCheckbox() {
		
		testToggleAllCheckbox();
		
		
		
	};
	



}
