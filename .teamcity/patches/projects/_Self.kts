package patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the root project
accordingly, and delete the patch script.
*/
changeProject(DslContext.projectId) {
    params {
        add {
            password("another_password", "credentialsJSON:8352737c-5934-4367-b3f9-74575663b054")
        }
        add {
            password("password_1", "credentialsJSON:bd4b1c10-c3fe-4cd1-8416-2caf48f74666")
        }
        add {
            password("password_2", "credentialsJSON:4d527672-f306-40bc-8fc6-4c99c588cb51")
        }
    }
}
