import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
class RegressionTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Still before all tests");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Tag("Regression")
    @Tag("Sii")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"Sign in to your account"})
    public void webpageSii(String expectedTitle) {
        driver.get("https://siiportal.sii.pl/Poznan/SitePages/Home.aspx#/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat("Title is not corrected", actualTitle, equalTo(expectedTitle));
    }

    @Tag("Regression")
    @Tag("Onet.pl")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    public void webpageOnet(String expectedTitle) {
        driver.get("https://www.onet.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat("Title is not corrected", actualTitle, equalTo(expectedTitle));
    }

    @Tag("Regression")
    @Tag("Kotuszkowo")
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    public void webpageKotuszkowo(String expectedTitle) {
        driver.get("http://kotuszkowo.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat("Title is not corrected", actualTitle, equalTo(expectedTitle));
    }

    @Tag("Regression")
    @Tag("Filmweb")
    @Order(4)
    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    public void webpageFilmweb(String expectedTitle) {
        driver.get("https://www.filmweb.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat("Title is not corrected", actualTitle, equalTo(expectedTitle));
    }

    @Tag("Regression")
    @Tag("Selenium documentation")
    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    public void webpageSelenium(String expectedTitle) {
        driver.get("https://www.selenium.dev/documentation/en/webdriver/ ");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat("Title is not corrected", actualTitle, equalTo(expectedTitle));
    }
}