plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    linuxX64()
    linuxArm64()
//    macosArm64()
    <SingleNativeTarget>()
}