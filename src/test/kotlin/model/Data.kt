package model

data class Data(
    var projectName: String,
    var projectID: String,
    var targetAndroid: Boolean,
    var targetiOS: Boolean,
    var targetDesktop: Boolean,
    var targetWeb: Boolean,
    var targetServer: Boolean
)
