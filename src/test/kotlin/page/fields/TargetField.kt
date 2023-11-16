package page.fields

import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class TargetField(driver: WebDriver, var id: String) {

    val field = driver.findElement(By.xpath("//*[contains(@id,'target$id')]/div/button/div"))

    fun getValue(): String? {
        return field.getAttribute("id")
    }

    fun checkIsEnabled() {
        assertEquals("disableTarget$id", getValue(), "$id field is disabled!")
    }

    fun checkIsDisabled() {
        assertEquals("enableTarget$id", getValue(), "$id field is enabled!")
    }

    fun enableField() {
        checkIsDisabled()
        field.click()
        checkIsEnabled()
    }

    fun disableField() {
        checkIsEnabled()
        field.click()
        checkIsDisabled()
    }
}