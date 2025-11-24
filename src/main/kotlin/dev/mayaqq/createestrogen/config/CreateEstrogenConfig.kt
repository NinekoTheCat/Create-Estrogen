package dev.mayaqq.createestrogen.config

import dev.mayaqq.createestrogen.MOD_ID
import uwu.serenity.kittyconfig.Config
import uwu.serenity.kittyconfig.KittyConfig
import uwu.serenity.kittyconfig.minecraft.SyncToClient
import uwu.serenity.kittyconfig.toml.TomlFormat

@Config("$MOD_ID/client", TomlFormat::class)
object CreateEstrogenClientConfig : KittyConfig {

}

@Config("$MOD_ID/common", TomlFormat::class)
@SyncToClient
object CreateEstrogenCommonConfig : KittyConfig {

}

@Config("$MOD_ID/server", TomlFormat::class)
object CreateEstrogenServerConfig : KittyConfig {

}