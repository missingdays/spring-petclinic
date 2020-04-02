package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }
    steps {
        insert(1) {
            script {
                name = "Fail build"
                enabled = false
                scriptContent = "exit 1"
            }
        }
    }

    features {
        add {
            notifications {
                notifier = "jbSlackNotifier"
                buildStarted = true
                buildFailed = true
                buildFinishedSuccessfully = true
                param("plugin:notificator:jbSlackNotifier:connection", "PROJECT_EXT_4")
                param("plugin:notificator:jbSlackNotifier:channel", "#teamcity-notifications-test")
            }
        }
    }
}
