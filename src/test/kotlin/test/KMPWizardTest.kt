package test

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import page.Form
import java.time.Duration

class KMPWizardTest {
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

        form.downloadButton.checkIsEnabled()
    }

    @Test
    @DisplayName("Checking helpers of the Project Name field")
    fun projectNameHelpersTest() {
        form.projectNameField.clearValue()
        form.projectNameField.checkHelper("Project name must not be empty")

        form.projectNameField.setValue(".")
        form.projectNameField.checkHelper("Project name is not valid")
    }

    @Test
    @DisplayName("Checking helpers of the Project ID field")
    fun projectIDHelpersTest() {
        form.projectIdField.clearValue()
        form.projectIdField.checkHelper("Project ID must not be empty")

        form.projectIdField.setValue(".")
        form.projectIdField.checkHelper("Project ID is not valid")

        form.projectIdField.setValue("test")
        form.projectIdField.checkHelper("Project ID must contain at least one '.' separator")
    }

    @Test
    @DisplayName("Checking fields' labels")
    fun fieldsLabelsTest() {
        form.projectNameField.checkLabel("Project Name")

        form.projectIdField.checkLabel("Project ID")
    }

    @Test
    @DisplayName("Checking required fields")
    fun requiredFieldsTest() {
        form.projectNameField.clearValue()
        form.downloadButton.checkIsDisabled()

        form.projectNameField.setValue("Test")
        form.projectIdField.clearValue()
        form.downloadButton.checkIsDisabled()

        form.projectIdField.setValue("test.test")
        form.androidField.disableField()
        form.iosField.disableField()
        form.downloadButton.checkIsDisabled()
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}