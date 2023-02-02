rootProject.name = "WorldDB"

include("api")

setupStorageProject("anvil")
setupStorageProject("mongodb")

fun setupStorageProject(name: String) {
    setupSubproject(name) {
        projectDir = file("storage/$name");
    }
}

inline fun setupSubproject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}