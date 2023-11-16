package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Button(var driver: WebDriver, locator: String) {

    val button = driver.findElement(By.id(locator))

    fun checkIsDisabled() {
        assertTrue(button.getAttribute("class").contains("disabled"))
    }

    fun checkIsEnabled() {
        assertFalse(button.getAttribute("class").contains("disabled"))
    }
}