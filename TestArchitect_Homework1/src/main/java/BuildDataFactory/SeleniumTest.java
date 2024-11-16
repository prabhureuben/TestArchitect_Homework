package BuildDataFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        // Example: Fetch data from Faker
        TestDataProvider dataProvider = DataProviderFactory.getDataProvider(DataSourceType.FAKER);

        String username = (String) dataProvider.getTestData("Username");
        String email = (String) dataProvider.getTestData("Password");

        // Example Selenium Test
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/");
        
        driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(email);

Thread.sleep(10000);
        driver.quit();
    }
}
