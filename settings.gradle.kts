pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")
            credentials {
                username = "NicolasAvilaB"
                password = "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"
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
            maven {
                url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")
                credentials {
                    username = "NicolasAvilaB"
                    password = "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"
                }
        }
    }
}

rootProject.name = "PokeApiPokedex"
include(":app")
 