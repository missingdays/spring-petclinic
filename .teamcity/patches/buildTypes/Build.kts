package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    features {
        add {
            notifications {
                notifier = "jbSlackNotifier"
                buildFailed = true
                param("plugin:notificator:jbSlackNotifier:connection", "PROJECT_EXT_4")
                param("plugin:notificator:jbSlackNotifier:channel", "asdasd")
            }
        }
    }
}
