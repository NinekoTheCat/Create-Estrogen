package dev.mayaqq.createestrogen.forge

import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.MOD_ID
import net.minecraftforge.fml.common.Mod

@Mod(MOD_ID)
object CreateEstrogenForge {
    init { CreateEstrogen.init() }
}