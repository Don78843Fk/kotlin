/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package test.numbers

import kotlin.test.*

class FpNumberToStringTest {
    @Test fun doubleTest() {
        assertEquals((0.5).toString(), "0.5")
        assertEquals((-0.5).toString(), "-0.5")
        assertEquals((0.0).toString(), "0.0")
        assertEquals((-0.0).toString(), "-0.0")
        assertEquals(Double.NaN.toString(), "NaN")
        assertEquals(Double.POSITIVE_INFINITY.toString(), "Infinity")
        assertEquals(Double.NEGATIVE_INFINITY.toString(), "-Infinity")
    }

    @Test fun floatTest() {
        assertEquals((0.5f).toString(), "0.5")
        assertEquals((-0.5f).toString(), "-0.5")
        assertEquals((0.0f).toString(), "0.0")
        assertEquals((-0.0f).toString(), "-0.0")
        assertEquals(Float.NaN.toString(), "NaN")
        assertEquals(Float.POSITIVE_INFINITY.toString(), "Infinity")
        assertEquals(Float.NEGATIVE_INFINITY.toString(), "-Infinity")
    }
}