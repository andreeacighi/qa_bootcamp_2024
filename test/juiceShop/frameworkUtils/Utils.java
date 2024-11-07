package juiceShop.frameworkUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Utils {
    private static final String configFile = "config.properties";
    public static String getConfigProperty(String property) {
        Properties configProps = new Properties();
        String configItem = "";
        try {
            configProps.load(new FileInputStream(configFile));
            configItem = configProps.getProperty(property).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configItem;
    }
    public static WebDriver getDriver() {
        WebDriver driver;
        String browser = getConfigProperty("browser");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:6969");

        //Properties configProps = new Properties();

        /*try {
            configProps.load(new FileReader(configFile));
            // System.out.println(System.getenv("AUTO_BROWSER"));
           browser = configProps.getProperty("browser").toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
       switch (browser){
           case "chrome":{
               ChromeOptions options = new ChromeOptions();
              // Map<String, Object> prefs = new HashMap<String,Object>();
              // prefs.put()
               if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                   options.addArguments("--start-maximized");
               }
               if (Boolean.parseBoolean(getConfigProperty("headless"))){
                   options.addArguments("--headless");
               }
               //chromeOptions.addArguments("args","[start-maximized,headless]");
               //options.setCapability("proxy",proxy);
               driver = new ChromeDriver(options);
               break;
           }
           case "firefox":{

               FirefoxOptions options = new FirefoxOptions();
               FirefoxProfile profile = new FirefoxProfile();
               if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                   options.addArguments("--start-maximized");
                   //driver.manage().window().maximize();
               }
               profile.setPreference("browser.download.dir","."); //salveaza in folderul curent ca sa putem verifica cu assert

               options.setProfile(profile);
               //options.setCapability("proxy",proxy);
               driver = new FirefoxDriver(options);

               if (Boolean.parseBoolean(getConfigProperty("headless"))){
                   options.addArguments("--headless");
               }


               break;
           }
           case "edge":{
               EdgeOptions options= new EdgeOptions();
               if (Boolean.parseBoolean(getConfigProperty("maximized"))){
                   options.addArguments("--start-maximized");
                   //driver.manage().window().maximize();
               }
               if (Boolean.parseBoolean(getConfigProperty("headless"))){
                   options.addArguments("--headless");
               }
               //options.setCapability("proxy",proxy);
               driver = new EdgeDriver(options);
               break;
           }
           default:{
               driver = new ChromeDriver();
           }
       }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    // metoda generica pentru orice element din pagina

    public static WebElement waitForElement(WebDriver driver, long seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public static boolean waitToDisappear(WebDriver driver, long seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
       return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");
    }

    public static void scrollToElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public static void printCookies(WebDriver driver){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies){
            System.out.println(c.toJson());
        }
    }


}
