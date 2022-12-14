package com.looker.core.data.fdroid.model

import com.looker.core.database.model.RepoEntity
import kotlinx.serialization.Serializable

@Serializable
data class RepoDto(
	val icon: String = "",
	val address: String = "",
	val name: String = "",
	val description: String = "",
	val timestamp: Long = 0L,
	val version: Int = -1,
	val mirrors: List<String> = emptyList()
)

fun RepoDto.toEntity(
	fingerPrint: String,
	etag: String
): RepoEntity = RepoEntity(
	timestamp = timestamp,
	version = version,
	name = name,
	description = description,
	icon = icon,
	address = address,
	// It is obviously enabled that's why we are syncing
	enabled = true,
	fingerprint = fingerPrint,
	etag = etag,
	mirrors = mirrors
)