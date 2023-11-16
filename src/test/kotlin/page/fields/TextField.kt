package page.fields

import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class TextField(val driver: WebDriver, val locator: String) {
    val field = driver.findElement(By.id(locator))

    fun getValue(): String? {
        return field.getAttribute("value")
    }

    fun checkValue(expectedValue: String) {
        assertEquals(expectedValue, getValue())
    }

    fun clearValue() {
        while (getValue()!!.isNotBlank()) {
            field.sendKeys(Keys.BACK_SPACE)
        }
    }

    fun setValue(value: String) {
        clearValue()
        field.sendKeys(value)
    }

    fun checkLabel(expectedLabel: String) {
        val actualLabel = driver.findElement(By.id("$locator-label")).text
        assertEquals(expectedLabel, actualLabel)
    }

    fun checkHelper(expectedHelper: String) {
        val actualHelper = driver.findElement(By.id("$locator-helper-text")).text
        assertEquals(expectedHelper, actualHelper)

    }
}