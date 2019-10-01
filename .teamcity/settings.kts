import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.1"

project {

    vcsRoot(HttpsGithubComMissingdaysChatServiceRefsHeadsMaster)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    params {
        param("abc", "credentialsJSON:c02562c7-d8af-44ca-a17d-ffc3799dd72a")
    }

    vcs {
        root(HttpsGithubComMissingdaysChatServiceRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComMissingdaysChatServiceRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/missingdays/ChatService#refs/heads/master"
    url = "https://github.com/missingdays/ChatService"
    authMethod = password {
        userName = "missingdays"
        password = "credentialsJSON:e232d6c4-6e94-42cd-84bd-ca619a4efbf1"
    }
})
