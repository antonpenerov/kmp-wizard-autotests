package test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import page.Form
import java.time.Duration

class OpenWizard {
    private lateinit var driver: WebDriver
    private lateinit var form: Form

    @BeforeEach
    fun setUp() {
        driver = ChromeDriver()
        driver.get("https://kmp.jetbrains.com/")
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500))
        form = Form(driver)
    }

    @Test
    @DisplayName("Checking default configuration of the KMP Wizard project")
    fun defaultProjectConfigurationTest() {
        form.projectNameField.checkValue("KotlinProject")

        form.projectIdField.checkValue("org.example.project")

        form.androidField.checkIsEnabled()

        form.iosField.checkIsEnabled()

        form.desktopField.checkIsDisabled()

        form.serverField.checkIsDisabled()
    }

    @Test
    @DisplayName("Checking helpers of the Project Name field with invalid characters")
    fun projectNameHelpersTest() {
        val projectName = driver.findElement(By.id("projectName"))

        //projectName.click()

        val jsDriver: JavascriptExecutor = (driver as JavascriptExecutor?)!!
        jsDriver.executeScript("document.getElementById('projectName').setAttribute('value', 'TEST')")

        projectName.sendKeys(".")
        assertEquals("Project name is not valid", driver.findElement(By.id("projectName-helper-text")).text)

        projectName.sendKeys(",")
        assertEquals("Project name is not valid", driver.findElement(By.id("projectName-helper-text")).text)

    }

    @Test
    @DisplayName("Checking helpers of the Project ID field with invalid characters")
    fun projectIDHelpersTest() {

    }

    @Test
    @DisplayName("Checking fields' labels")
    fun checkFieldsLabels() {
        val projectNameLabel = driver.findElement(By.id("projectName-label"))
        val projectNameLabelValue = projectNameLabel.text
        assertEquals("Project Name", projectNameLabelValue)
    }

    @Test
    @DisplayName("Checking required fields")
    fun requiredFieldsTest() {

    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}