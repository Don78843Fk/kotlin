/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlinx.serialization.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlinx.serialization.TestGeneratorKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kotlinx-serialization/testData/boxIr")
@TestDataPath("$PROJECT_ROOT")
public class SerializationIrBoxTestGenerated extends AbstractSerializationIrBoxTest {
    @Test
    @TestMetadata("allConstructorsAccessible.kt")
    public void testAllConstructorsAccessible() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/allConstructorsAccessible.kt");
    }

    @Test
    public void testAllFilesPresentInBoxIr() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlinx-serialization/testData/boxIr"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @Test
    @TestMetadata("annotationsOnFile.kt")
    public void testAnnotationsOnFile() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/annotationsOnFile.kt");
    }

    @Test
    @TestMetadata("caching.kt")
    public void testCaching() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/caching.kt");
    }

    @Test
    @TestMetadata("clashBetweenSerializableAndNonSerializableProperty.kt")
    public void testClashBetweenSerializableAndNonSerializableProperty() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/clashBetweenSerializableAndNonSerializableProperty.kt");
    }

    @Test
    @TestMetadata("classSerializerAsObject.kt")
    public void testClassSerializerAsObject() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/classSerializerAsObject.kt");
    }

    @Test
    @TestMetadata("constValInSerialName.kt")
    public void testConstValInSerialName() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/constValInSerialName.kt");
    }

    @Test
    @TestMetadata("contextualByDefault.kt")
    public void testContextualByDefault() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/contextualByDefault.kt");
    }

    @Test
    @TestMetadata("contextualFallback.kt")
    public void testContextualFallback() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/contextualFallback.kt");
    }

    @Test
    @TestMetadata("contextualWithTypeParameters.kt")
    public void testContextualWithTypeParameters() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/contextualWithTypeParameters.kt");
    }

    @Test
    @TestMetadata("delegatedInterface.kt")
    public void testDelegatedInterface() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/delegatedInterface.kt");
    }

    @Test
    @TestMetadata("delegatedProperty.kt")
    public void testDelegatedProperty() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/delegatedProperty.kt");
    }

    @Test
    @TestMetadata("enumsAreCached.kt")
    public void testEnumsAreCached() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/enumsAreCached.kt");
    }

    @Test
    @TestMetadata("expectActual.kt")
    public void testExpectActual() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/expectActual.kt");
    }

    @Test
    @TestMetadata("expectActualSealedClass.kt")
    public void testExpectActualSealedClass() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/expectActualSealedClass.kt");
    }

    @Test
    @TestMetadata("externalSerialierJava.kt")
    public void testExternalSerialierJava() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/externalSerialierJava.kt");
    }

    @Test
    @TestMetadata("externalSerializerForClassWithNonSerializableType.kt")
    public void testExternalSerializerForClassWithNonSerializableType() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/externalSerializerForClassWithNonSerializableType.kt");
    }

    @Test
    @TestMetadata("generatedClassifiersViaLibraryDependency.kt")
    public void testGeneratedClassifiersViaLibraryDependency() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/generatedClassifiersViaLibraryDependency.kt");
    }

    @Test
    @TestMetadata("genericBaseClassMultiple.kt")
    public void testGenericBaseClassMultiple() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/genericBaseClassMultiple.kt");
    }

    @Test
    @TestMetadata("genericBaseClassSimple.kt")
    public void testGenericBaseClassSimple() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/genericBaseClassSimple.kt");
    }

    @Test
    @TestMetadata("generics.kt")
    public void testGenerics() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/generics.kt");
    }

    @Test
    @TestMetadata("inlineClasses.kt")
    public void testInlineClasses() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/inlineClasses.kt");
    }

    @Test
    @TestMetadata("interfaces.kt")
    public void testInterfaces() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/interfaces.kt");
    }

    @Test
    @TestMetadata("intrinsicAnnotations.kt")
    public void testIntrinsicAnnotations() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/intrinsicAnnotations.kt");
    }

    @Test
    @TestMetadata("intrinsicsBox.kt")
    public void testIntrinsicsBox() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/intrinsicsBox.kt");
    }

    @Test
    @TestMetadata("intrinsicsNonReified.kt")
    public void testIntrinsicsNonReified() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/intrinsicsNonReified.kt");
    }

    @Test
    @TestMetadata("intrinsicsNullable.kt")
    public void testIntrinsicsNullable() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/intrinsicsNullable.kt");
    }

    @Test
    @TestMetadata("intrinsicsStarProjections.kt")
    public void testIntrinsicsStarProjections() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/intrinsicsStarProjections.kt");
    }

    @Test
    @TestMetadata("metaSerializable.kt")
    public void testMetaSerializable() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/metaSerializable.kt");
    }

    @Test
    @TestMetadata("mpp.kt")
    public void testMpp() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/mpp.kt");
    }

    @Test
    @TestMetadata("multiFieldValueClasses.kt")
    public void testMultiFieldValueClasses() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/multiFieldValueClasses.kt");
    }

    @Test
    @TestMetadata("multimoduleInheritance.kt")
    public void testMultimoduleInheritance() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/multimoduleInheritance.kt");
    }

    @Test
    @TestMetadata("multipleGenericsPolymorphic.kt")
    public void testMultipleGenericsPolymorphic() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/multipleGenericsPolymorphic.kt");
    }

    @Test
    @TestMetadata("namedCompanions.kt")
    public void testNamedCompanions() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/namedCompanions.kt");
    }

    @Test
    @TestMetadata("repeatableSerialInfo.kt")
    public void testRepeatableSerialInfo() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/repeatableSerialInfo.kt");
    }

    @Test
    @TestMetadata("sealedClassMultifile.kt")
    public void testSealedClassMultifile() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/sealedClassMultifile.kt");
    }

    @Test
    @TestMetadata("sealedInterfaces.kt")
    public void testSealedInterfaces() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/sealedInterfaces.kt");
    }

    @Test
    @TestMetadata("serialInfo.kt")
    public void testSerialInfo() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serialInfo.kt");
    }

    @Test
    @TestMetadata("serializableFromAnotherModule.kt")
    public void testSerializableFromAnotherModule() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serializableFromAnotherModule.kt");
    }

    @Test
    @TestMetadata("serializableFromAnotherModule_multipleFields.kt")
    public void testSerializableFromAnotherModule_multipleFields() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serializableFromAnotherModule_multipleFields.kt");
    }

    @Test
    @TestMetadata("serializableOnPropertyType.kt")
    public void testSerializableOnPropertyType() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serializableOnPropertyType.kt");
    }

    @Test
    @TestMetadata("serializerFactory.kt")
    public void testSerializerFactory() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serializerFactory.kt");
    }

    @Test
    @TestMetadata("serializerFactoryInUserDefined.kt")
    public void testSerializerFactoryInUserDefined() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/serializerFactoryInUserDefined.kt");
    }

    @Test
    @TestMetadata("starProjections.kt")
    public void testStarProjections() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/starProjections.kt");
    }

    @Test
    @TestMetadata("typealiasesTest.kt")
    public void testTypealiasesTest() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/typealiasesTest.kt");
    }

    @Test
    @TestMetadata("useSerializersChain.kt")
    public void testUseSerializersChain() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/useSerializersChain.kt");
    }

    @Test
    @TestMetadata("userDefinedSerializerInCompanion.kt")
    public void testUserDefinedSerializerInCompanion() throws Exception {
        runTest("plugins/kotlinx-serialization/testData/boxIr/userDefinedSerializerInCompanion.kt");
    }
}
