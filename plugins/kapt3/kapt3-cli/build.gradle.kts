plugins {
    kotlin("jvm")
    id("jps-compatible")
}

JvmProject.configure(project, "1.8")

dependencies {
    compile(project(":compiler:cli"))

    compileOnly(intellijCoreDep()) { includeJars("intellij-core", rootProject = rootProject) }

    testCompile(projectTests(":compiler:tests-common"))
    testCompile(projectTests(":compiler"))
    testCompile(commonDep("junit:junit"))
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

testsJar()

projectTest {
    workingDir = rootDir
    dependsOn(":dist")
}