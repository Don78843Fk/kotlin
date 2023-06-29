/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

@file:OptIn(ExperimentalStdlibApi::class)

package kotlin.native.internal.test

import kotlin.experimental.ExperimentalNativeApi
import kotlin.system.exitProcess
import kotlin.native.concurrent.*

// Advanced users may need an access to test suites generated by the compiler to integrate
// our test machinery with third party test runners (e.g. with xctestrun).
// So we keep this object public but protect it with @ExperimentalStdlibApi
// to stress that it is not a part of the stable API.
// Related YT issue: KT-47915.
@ExperimentalNativeApi
@ThreadLocal
public object GeneratedSuites {
   val suites = mutableListOf<TestSuite>()
   fun add(suite: TestSuite) = suites.add(suite)
}

@ExperimentalNativeApi
public fun registerSuite(suite: TestSuite): Unit {
    GeneratedSuites.add(suite)
}

@ExperimentalNativeApi
fun testLauncherEntryPoint(args: Array<String>): Int {
    val testSettings = TestProcessor(GeneratedSuites.suites, args).process()
    return TestRunner(testSettings).run()
}

@ExperimentalNativeApi
fun main(args: Array<String>) {
    val exitCode = testLauncherEntryPoint(args)
    if (exitCode != 0) {
        exitProcess(exitCode)
    }
}

@OptIn(FreezingIsDeprecated::class)
@ExperimentalNativeApi
@ObsoleteWorkersApi
fun worker(args: Array<String>) {
    val worker = Worker.start()
    val exitCode = worker.execute(TransferMode.SAFE, { args.freeze() }) {
        it -> testLauncherEntryPoint(it)
    }.result
    worker.requestTermination().result
    if (exitCode != 0) {
        exitProcess(exitCode)
    }
}

@ExperimentalNativeApi
fun mainNoExit(args: Array<String>) {
    testLauncherEntryPoint(args)
}
