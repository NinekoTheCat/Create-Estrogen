package dev.mayaqq.createestrogen.forge.integration

import dev.nyon.klf.KlfLoadingContext
import dev.nyon.klf.MOD_BUS
import net.minecraftforge.eventbus.api.IEventBus
import uwu.serenity.kritter.ModBusProvider

/**
 * Kritter support for KotlingLangForge
 * TODO: when kritter updates to handle KLF please remove :3
 */
@ModBusProvider
fun klfBusProvider(context: KlfLoadingContext.Companion): IEventBus = MOD_BUS