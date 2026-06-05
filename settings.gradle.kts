pluginManagement {
    repositories { google(); mavenCentral(); gradlePluginPortal() }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories { google(); mavenCentral() }
}
rootProject.name = "GameVault"
include(":app")
include(":core:common")
include(":core:database")
include(":core:network")
include(":feature:gamelist")
include(":feature:gamedetail")
include(":feature:auth")
include(":feature:settings")
include(":feature:discover")
