package page.fields

import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class TextField(driver: WebDriver, locator: String) {
    val field = driver.findElement(By.id(locator))

    fun getValue(): String? {
        return field.getAttribute("value")
    }

    fun checkValue(expectedValue: String) {
        assertEquals(expectedValue, getValue())
    }

    fun setValue() {
//        val jsDriver: JavascriptExecutor = (driver as JavascriptExecutor?)!!
//        jsDriver.executeScript("document.getElementsById('projectName').setAttribute('value', 'TEST')")
    }
}