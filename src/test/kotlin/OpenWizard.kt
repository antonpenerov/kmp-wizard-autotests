import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.lang.Thread.sleep
import java.time.Duration
import Locators.ANDROID_FIELD_ID
import Locators.DESKTOP_FIELD_ID
import Locators.IOS_FIELD_ID
import Locators.PROJECT_ID_FIELD_ID
import Locators.PROJECT_NAME_FIELD_ID
import Locators.SERVER_FIELD_ID
import Locators.WEB_FIELD_ID
import org.openqa.selenium.JavascriptExecutor

class OpenWizard {
    private lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        driver = ChromeDriver()
        driver.get("https://kmp.jetbrains.com/")
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500))
    }

    @Test
    @DisplayName("Checking the Project Name field")
    fun checkTitle() {
        //var title = driver.findElement(By.xpath("//input[@id='projectName']"))
        val projectNameLabel = driver.findElement(By.id("projectName-label"))
        val projectNameLabelValue = projectNameLabel.text
        assertEquals("Project Name", projectNameLabelValue)

        var projectName = driver.findElement(By.id("projectName"))
        val projectNameValue = projectName.getAttribute("value")
        assertEquals("KotlinProject", projectNameValue)

        //projectName.setValue()
        //projectName.clear()
        //sleep(1500)
        projectName.sendKeys(".")

        var projectNameHelper = driver.findElement(By.id("projectName-helper-text"))
        val projectNameHelperText = projectNameHelper.text
        assertEquals("Project name is not valid", projectNameHelperText)

        sleep(2000)
    }

    @Test
    @DisplayName("Checking default configuration of the KMP Wizard project")
    fun defaultProjectConfigurationTest() {
        val projectName = TextField(driver, PROJECT_NAME_FIELD_ID)
        projectName.checkValue("KotlinProject")

        val projectID = TextField(driver, PROJECT_ID_FIELD_ID)
        projectID.checkValue("org.example.project")

        val targetAndroid = driver.findElement(By.id(ANDROID_FIELD_ID))
        //val targetAndroidCheckbox = driver.findElement(By.xpath("//*[contains(@id,'targetAndroid')]//*[contains(@class,'SvgIcon')]"))
        val targetAndroidCheckbox = driver.findElement(By.xpath("//*[contains(@id,'targetAndroid')]/div/button/div"))
        val targetAndroidCheckboxValue = targetAndroidCheckbox.getAttribute("id")
        assertEquals("disableTargetAndroid", targetAndroidCheckboxValue)

        val targetiOS = driver.findElement(By.id(IOS_FIELD_ID))
        val targetiOSCheckbox = driver.findElement(By.xpath("//*[contains(@id,'targetiOS')]/div/button/div"))
        val targetiOSCheckboxValue = targetiOSCheckbox.getAttribute("id")
        assertEquals("disableTargetiOS", targetiOSCheckboxValue)

        val targetDesktop = driver.findElement(By.id(DESKTOP_FIELD_ID))

        val targetWeb = driver.findElement(By.id(WEB_FIELD_ID))

        val targetServer = driver.findElement(By.id(SERVER_FIELD_ID))
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

        sleep(2000)
    }

    @Test
    @DisplayName("Checking helpers of the Project ID field with invalid characters")
    fun projectIDHelpersTest() {
        val projectID = driver.findElement(By.id("projectId"))

        sleep(2000)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}