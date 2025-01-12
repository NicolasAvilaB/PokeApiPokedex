pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://maven.pkg.github.com/NicolasAvilaB/ui-composables")
            credentials {
                username = "NicolasAvilaB"
                password = "https://drive.google.com/file/d/1-B7vs7OC_m5daeK7RpQ2tHNazyj5IVF4/view?usp=sharing"
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
                    password = "https://drive.google.com/file/d/1-B7vs7OC_m5daeK7RpQ2tHNazyj5IVF4/view?usp=sharing"
                }
        }
    }
}

rootProject.name = "PokeApiPokedex"
include(":app")
 