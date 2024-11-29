package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Pokemon(

	@field:SerializedName("generation")
	val generation: Int? = null,

	@field:SerializedName("types")
	val types: Any? = null,

	@field:SerializedName("egg_groups")
	val eggGroups: Any? = null,

	@field:SerializedName("resistances")
	val resistances: Any? = null,

	@field:SerializedName("weight")
	val weight: Any? = null,

	@field:SerializedName("sexe")
	val sexe: Any? = null,

	@field:SerializedName("catch_rate")
	val catchRate: Any? = null,

	@field:SerializedName("evolution")
	val evolution: Any? = null,

	@field:SerializedName("sprites")
	val sprites: Sprites? = null,

	@field:SerializedName("formes")
	val formes: Any? = null,

	@field:SerializedName("pokedex_id")
	val pokedexId: Int? = null,

	@field:SerializedName("stats")
	val stats: Any? = null,

	@field:SerializedName("name")
	val name: Name? = null,

	@field:SerializedName("level_100")
	val level100: Any? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("talents")
	val talents: Any? = null,

	@field:SerializedName("height")
	val height: Any? = null
)

data class Name(

	@field:SerializedName("jp")
	val jp: String? = null,

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("fr")
	val fr: String? = null
)

data class Sprites(

	@field:SerializedName("shiny")
	val shiny: Any? = null,

	@field:SerializedName("gmax")
	val gmax: Any? = null,

	@field:SerializedName("regular")
	val regular: String? = null
)
