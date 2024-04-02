// TARGET_BACKEND: JVM_IR
// DUMP_IR

// IGNORE_CODEGEN_WITH_FIR2IR_FAKE_OVERRIDE_GENERATION: JVM_IR
// Fir2Ir fake override generator does not generate publicStaticField in Child.

// FILE: javapackage/PackagePrivateGrandparentInterface.java

package javapackage;

/*package-private*/ interface PackagePrivateGrandparentInterface {
    String publicStaticField = "OK";
}

// FILE: javapackage/PublicParentClass.java

package javapackage;

public class PublicParentClass implements PackagePrivateGrandparentInterface {}

// FILE: Child.kt

import javapackage.PublicParentClass

class Child : PublicParentClass() {
    fun foo(): String {
        return publicStaticField
    }
}

// FILE: test.kt

fun box() = Child().foo()
