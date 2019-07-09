plugins {
    kotlin("jvm")
    id("jps-compatible")
}

JvmProject.configure(project, "1.8")

dependencies {
    compile(kotlinStdlib())
    compile(files("${System.getProperty("java.home")}/../lib/tools.jar"))
    testCompile(commonDep("junit:junit"))
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

testsJar {}

projectTest {
    workingDir = rootDir
    dependsOn(":dist")
}