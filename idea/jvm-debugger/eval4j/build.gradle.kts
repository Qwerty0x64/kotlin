plugins {
    kotlin("jvm")
    id("jps-compatible")
}

JvmProject.configure(project, "1.8")

dependencies {
    compile(kotlinStdlib())
    compile(project(":compiler:backend"))
    compile(files(toolsJar()))
    compileOnly(intellijCoreDep()) { includeJars("intellij-core", "asm-all", rootProject = rootProject) }
    testCompile(project(":kotlin-test:kotlin-test-junit"))
    testCompile(commonDep("junit:junit"))
    testCompile(intellijDep()) { includeJars("asm-all", rootProject = rootProject) }
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

projectTest(parallel = true) {
    dependsOn(":dist")
    workingDir = rootDir
}
