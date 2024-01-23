/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp.compilationImpl

import org.gradle.api.NamedDomainObjectSet
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.sources.internal


internal fun KotlinCompilationSourceSetsContainer(
    defaultSourceSet: KotlinSourceSet
): KotlinCompilationSourceSetsContainer {
    return DefaultKotlinCompilationSourceSetsContainer(defaultSourceSet)
}

internal interface KotlinCompilationSourceSetsContainer {
    val defaultSourceSet: KotlinSourceSet
    val kotlinSourceSets: NamedDomainObjectSet<KotlinSourceSet>
    val allKotlinSourceSets: NamedDomainObjectSet<KotlinSourceSet>
    fun source(sourceSet: KotlinSourceSet)
}

private class DefaultKotlinCompilationSourceSetsContainer(
    override val defaultSourceSet: KotlinSourceSet
) : KotlinCompilationSourceSetsContainer {
    private val kotlinSourceSetsImpl: NamedDomainObjectSet<KotlinSourceSet> = defaultSourceSet
        .project
        .objects
        .namedDomainObjectSet(KotlinSourceSet::class.java)
        .also { set -> set.add(defaultSourceSet) }

    private val allKotlinSourceSetsImpl: NamedDomainObjectSet<KotlinSourceSet> = defaultSourceSet
        .project
        .objects
        .namedDomainObjectSet(KotlinSourceSet::class.java).also { set ->
            defaultSourceSet.internal.withDependsOnClosure.forAll(set::add)
        }

    override val kotlinSourceSets: NamedDomainObjectSet<KotlinSourceSet>
        get() = kotlinSourceSetsImpl

    override val allKotlinSourceSets: NamedDomainObjectSet<KotlinSourceSet>
        get() = allKotlinSourceSetsImpl

    /**
     * All SourceSets that have been processed by [source] already.
     * [directlyIncludedKotlinSourceSets] cannot be used in this case, because
     * the [defaultSourceSet] will always be already included.
     */
    private val sourcedKotlinSourceSets = hashSetOf<KotlinSourceSet>()

    override fun source(sourceSet: KotlinSourceSet) {
        if (!sourcedKotlinSourceSets.add(sourceSet)) return
        kotlinSourceSetsImpl.add(sourceSet)
        sourceSet.internal.withDependsOnClosure.forAll { inDependsOnClosure ->
            allKotlinSourceSetsImpl.add(inDependsOnClosure)
        }
    }
}
