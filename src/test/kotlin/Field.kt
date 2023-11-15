import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

open class Field(driver: WebDriver, locator: String) {
    val field = driver.findElement(By.id(locator))
}