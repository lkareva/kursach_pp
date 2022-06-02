package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Flow (
    val groups: String,
    @Serializable(with = SubgroupSerializer::class)
    val subgroup: Subgroup = Subgroup.ALL
)