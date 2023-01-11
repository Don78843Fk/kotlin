/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir

import junit.framework.TestCase
import org.jetbrains.kotlin.analysis.low.level.api.fir.lazy.resolve.FirLazyBodiesCalculator
import org.jetbrains.kotlin.analysis.low.level.api.fir.test.base.AbstractLowLevelApiSingleFileTest
import org.jetbrains.kotlin.fir.FirElement
import org.jetbrains.kotlin.fir.builder.BodyBuildingMode
import org.jetbrains.kotlin.fir.builder.RawFirBuilder
import org.jetbrains.kotlin.fir.expressions.impl.FirLazyBlock
import org.jetbrains.kotlin.fir.expressions.impl.FirLazyExpression
import org.jetbrains.kotlin.fir.renderer.FirRenderer
import org.jetbrains.kotlin.fir.scopes.kotlinScopeProvider
import org.jetbrains.kotlin.fir.visitors.FirVisitorVoid
import org.jetbrains.kotlin.jvm.specialization.annotations.Monomorphic
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.test.services.TestModuleStructure
import org.jetbrains.kotlin.test.services.TestServices

abstract class AbstractFirLazyBodiesCalculatorTest : AbstractLowLevelApiSingleFileTest() {
    private val lazyChecker = object : FirVisitorVoid() {
        override fun <@Monomorphic TE : FirElement> visitElement(element: TE) {
            TestCase.assertFalse("${FirLazyBlock::class.qualifiedName} should not present in the tree", element is FirLazyBlock)
            TestCase.assertFalse("${FirLazyExpression::class.qualifiedName} should not present in the tree", element is FirLazyExpression)
            element.acceptChildren(this)
        }
    }

    override fun doTestByFileStructure(ktFile: KtFile, moduleStructure: TestModuleStructure, testServices: TestServices) {
        resolveWithClearCaches(ktFile) { firResolveSession ->
            val session = firResolveSession.useSiteFirSession
            val provider = session.kotlinScopeProvider

            val laziedFirFile = RawFirBuilder(
                session,
                provider,
                bodyBuildingMode = BodyBuildingMode.LAZY_BODIES
            ).buildFirFile(ktFile)

            FirLazyBodiesCalculator.calculateLazyBodies(laziedFirFile)
            laziedFirFile.accept(lazyChecker)

            val fullFirFile = RawFirBuilder(
                session,
                provider,
                bodyBuildingMode = BodyBuildingMode.NORMAL
            ).buildFirFile(ktFile)

            val laziedFirFileDump = FirRenderer().renderElementAsString(laziedFirFile)
            val fullFirFileDump = FirRenderer().renderElementAsString(fullFirFile)

            TestCase.assertEquals(laziedFirFileDump, fullFirFileDump)
        }
    }
}