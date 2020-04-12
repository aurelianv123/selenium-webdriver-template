import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FirstTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void TestOne() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        //noinspection SpellCheckingInspection
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String title = driver.findElement(By.cssSelector(".example h2")).getText();;
        assertThat(title, is("Secure Area"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
