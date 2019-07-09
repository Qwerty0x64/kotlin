
plugins {
    kotlin("jvm")
    id("jps-compatible")
}

JvmProject.configure(project, "1.8")

dependencies {
    compile(project(":compiler:util"))
    compile(project(":core:descriptors"))
    compileOnly(intellijDep()) { includeJars("trove4j") }
}

sourceSets {
    "main" { projectDefault() }
    "test" {}
}
