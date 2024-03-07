/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.testOld.klib;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateJsTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/klib/evolution")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ClassicJsKlibEvolutionTestGenerated extends AbstractClassicJsKlibEvolutionTest {
  private void runTest(String testDataFilePath) {
    KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
  }

  @TestMetadata("addAbstractMemberBody.kt")
  public void testAddAbstractMemberBody() {
    runTest("compiler/testData/klib/evolution/addAbstractMemberBody.kt");
  }

  @TestMetadata("addCompanionObject.kt")
  public void testAddCompanionObject() {
    runTest("compiler/testData/klib/evolution/addCompanionObject.kt");
  }

  @TestMetadata("addCrossinline.kt")
  public void testAddCrossinline() {
    runTest("compiler/testData/klib/evolution/addCrossinline.kt");
  }

  @TestMetadata("addDefaultImplementations.kt")
  public void testAddDefaultImplementations() {
    runTest("compiler/testData/klib/evolution/addDefaultImplementations.kt");
  }

  @TestMetadata("addEnumClassMember.kt")
  public void testAddEnumClassMember() {
    runTest("compiler/testData/klib/evolution/addEnumClassMember.kt");
  }

  @TestMetadata("addLateinitToVar.kt")
  public void testAddLateinitToVar() {
    runTest("compiler/testData/klib/evolution/addLateinitToVar.kt");
  }

  @TestMetadata("addOpenToClass.kt")
  public void testAddOpenToClass() {
    runTest("compiler/testData/klib/evolution/addOpenToClass.kt");
  }

  @TestMetadata("addOpenToMember.kt")
  public void testAddOpenToMember() {
    runTest("compiler/testData/klib/evolution/addOpenToMember.kt");
  }

  @TestMetadata("addOrRemoveConst.kt")
  public void testAddOrRemoveConst() {
    runTest("compiler/testData/klib/evolution/addOrRemoveConst.kt");
  }

  @TestMetadata("addOrRemoveInitBlock.kt")
  public void testAddOrRemoveInitBlock() {
    runTest("compiler/testData/klib/evolution/addOrRemoveInitBlock.kt");
  }

  @TestMetadata("addOverloads.kt")
  public void testAddOverloads() {
    runTest("compiler/testData/klib/evolution/addOverloads.kt");
  }

  @TestMetadata("addParameterDefaulValue.kt")
  public void testAddParameterDefaulValue() {
    runTest("compiler/testData/klib/evolution/addParameterDefaulValue.kt");
  }

  @TestMetadata("addPropertyAccessor.kt")
  public void testAddPropertyAccessor() {
    runTest("compiler/testData/klib/evolution/addPropertyAccessor.kt");
  }

  @TestMetadata("addingSealedClassMember.kt")
  public void testAddingSealedClassMember() {
    runTest("compiler/testData/klib/evolution/addingSealedClassMember.kt");
  }

  public void testAllFilesPresentInEvolution() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/klib/evolution"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JS_IR, true);
  }

  @TestMetadata("changeBaseClassOrder.kt")
  public void testChangeBaseClassOrder() {
    runTest("compiler/testData/klib/evolution/changeBaseClassOrder.kt");
  }

  @TestMetadata("changeCompanionToNestedObject.kt")
  public void testChangeCompanionToNestedObject() {
    runTest("compiler/testData/klib/evolution/changeCompanionToNestedObject.kt");
  }

  @TestMetadata("changeConstInitialization.kt")
  public void testChangeConstInitialization() {
    runTest("compiler/testData/klib/evolution/changeConstInitialization.kt");
  }

  @TestMetadata("changeNamesOfTypeParameters.kt")
  public void testChangeNamesOfTypeParameters() {
    runTest("compiler/testData/klib/evolution/changeNamesOfTypeParameters.kt");
  }

  @TestMetadata("changeObjectToCompanion.kt")
  public void testChangeObjectToCompanion() {
    runTest("compiler/testData/klib/evolution/changeObjectToCompanion.kt");
  }

  @TestMetadata("changeParameterDefaultValue.kt")
  public void testChangeParameterDefaultValue() {
    runTest("compiler/testData/klib/evolution/changeParameterDefaultValue.kt");
  }

  @TestMetadata("changePropertyFromValToVar.kt")
  public void testChangePropertyFromValToVar() {
    runTest("compiler/testData/klib/evolution/changePropertyFromValToVar.kt");
  }

  @TestMetadata("changePropertyInitialization.kt")
  public void testChangePropertyInitialization() {
    runTest("compiler/testData/klib/evolution/changePropertyInitialization.kt");
  }

  @TestMetadata("constructorParameterMarkValVar.kt")
  public void testConstructorParameterMarkValVar() {
    runTest("compiler/testData/klib/evolution/constructorParameterMarkValVar.kt");
  }

  @TestMetadata("deleteOverrideMember.kt")
  public void testDeleteOverrideMember() {
    runTest("compiler/testData/klib/evolution/deleteOverrideMember.kt");
  }

  @TestMetadata("deletePrivateMembers.kt")
  public void testDeletePrivateMembers() {
    runTest("compiler/testData/klib/evolution/deletePrivateMembers.kt");
  }

  @TestMetadata("inlineBodyChange.kt")
  public void testInlineBodyChange() {
    runTest("compiler/testData/klib/evolution/inlineBodyChange.kt");
  }

  @TestMetadata("inlineFunction.kt")
  public void testInlineFunction() {
    runTest("compiler/testData/klib/evolution/inlineFunction.kt");
  }

  @TestMetadata("makeFunctionInfixOrTailrec.kt")
  public void testMakeFunctionInfixOrTailrec() {
    runTest("compiler/testData/klib/evolution/makeFunctionInfixOrTailrec.kt");
  }

  @TestMetadata("moreSpecificBaseClass.kt")
  public void testMoreSpecificBaseClass() {
    runTest("compiler/testData/klib/evolution/moreSpecificBaseClass.kt");
  }

  @TestMetadata("moveMemberUpInHierarchy.kt")
  public void testMoveMemberUpInHierarchy() {
    runTest("compiler/testData/klib/evolution/moveMemberUpInHierarchy.kt");
  }

  @TestMetadata("newFakeOverride.kt")
  public void testNewFakeOverride() {
    runTest("compiler/testData/klib/evolution/newFakeOverride.kt");
  }

  @TestMetadata("newOverrideMember.kt")
  public void testNewOverrideMember() {
    runTest("compiler/testData/klib/evolution/newOverrideMember.kt");
  }

  @TestMetadata("removeAbstractFromClass.kt")
  public void testRemoveAbstractFromClass() {
    runTest("compiler/testData/klib/evolution/removeAbstractFromClass.kt");
  }

  @TestMetadata("removeInfixOrTailrecFromFunction.kt")
  public void testRemoveInfixOrTailrecFromFunction() {
    runTest("compiler/testData/klib/evolution/removeInfixOrTailrecFromFunction.kt");
  }

  @TestMetadata("removeLateinitFromVar.kt")
  public void testRemoveLateinitFromVar() {
    runTest("compiler/testData/klib/evolution/removeLateinitFromVar.kt");
  }

  @TestMetadata("removePropertyAccessor.kt")
  public void testRemovePropertyAccessor() {
    runTest("compiler/testData/klib/evolution/removePropertyAccessor.kt");
  }

  @TestMetadata("renameArguments.kt")
  public void testRenameArguments() {
    runTest("compiler/testData/klib/evolution/renameArguments.kt");
  }

  @TestMetadata("reorderClassConstructors.kt")
  public void testReorderClassConstructors() {
    runTest("compiler/testData/klib/evolution/reorderClassConstructors.kt");
  }

  @TestMetadata("turnClassIntoDataClass.kt")
  public void testTurnClassIntoDataClass() {
    runTest("compiler/testData/klib/evolution/turnClassIntoDataClass.kt");
  }

  @TestMetadata("widenSuperMemberVisibility.kt")
  public void testWidenSuperMemberVisibility() {
    runTest("compiler/testData/klib/evolution/widenSuperMemberVisibility.kt");
  }
}
