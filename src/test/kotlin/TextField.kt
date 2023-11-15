import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class TextField(var driver: WebDriver, var locator: String) : Field(driver, locator) {

    fun getValue(): String? {
        return field.getAttribute("value")
    }

    fun checkValue(expectedValue: String) {
        assertEquals(expectedValue, getValue())
    }

    fun setValue(value: String) {
        val jsDriver: JavascriptExecutor = (driver as JavascriptExecutor?)!!
        jsDriver.executeScript("document.getElementsById('projectName').setAttribute('value', 'TEST')")
    }
}