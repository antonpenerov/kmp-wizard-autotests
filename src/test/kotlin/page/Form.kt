package page

import org.openqa.selenium.WebDriver
import page.fields.TargetField
import page.fields.TextField

class Form(val driver: WebDriver) {
    companion object Locators {
        const val PROJECT_NAME_FIELD_ID = "projectName"
        const val PROJECT_ID_FIELD_ID = "projectId"
        const val ANDROID_FIELD_ID = "Android"
        const val IOS_FIELD_ID = "iOS"
        const val DESKTOP_FIELD_ID = "Desktop"
        const val WEB_FIELD_ID = "Web"
        const val SERVER_FIELD_ID = "Server"
        const val DOWNLOAD_BUTTON = "downloadNewProject"
    }

    val projectNameField = TextField(driver, PROJECT_NAME_FIELD_ID)
    val projectIdField = TextField(driver, PROJECT_ID_FIELD_ID)
    val androidField = TargetField(driver, ANDROID_FIELD_ID)
    val iosField = TargetField(driver, IOS_FIELD_ID)
    val desktopField = TargetField(driver, DESKTOP_FIELD_ID)
    val serverField = TargetField(driver, SERVER_FIELD_ID)

    val downloadButton = Button(driver, DOWNLOAD_BUTTON)
}