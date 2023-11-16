package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class Button(driver: WebDriver, locator: String) {

    val button = driver.findElement(By.id(locator))

}