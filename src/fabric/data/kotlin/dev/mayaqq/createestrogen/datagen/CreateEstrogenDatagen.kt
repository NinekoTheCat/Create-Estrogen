package dev.mayaqq.createestrogen.datagen

import dev.mayaqq.createestrogen.datagen.loottables.CreateEstrogenLoottables
import dev.mayaqq.createestrogen.datagen.models.CreateEstrogenModels
import dev.mayaqq.createestrogen.datagen.tags.CreateEstrogenBlockTags
import dev.mayaqq.createestrogen.datagen.tags.CreateEstrogenItemTags
import dev.mayaqq.createestrogen.datagen.translations.CreateEstrogenTranslations
import dev.mayaqq.estrogen.datagen.api.EstrogenDatagenEntrypoint
import dev.mayaqq.estrogen.datagen.api.EstrogenPack

object CreateEstrogenDatagen : EstrogenDatagenEntrypoint("createestrogen") {
    override fun setupCommon(pack: EstrogenPack) {
        pack.addProvider(::CreateEstrogenTranslations)
        pack.addProvider(::CreateEstrogenLoottables)
        pack.addProvider(::CreateEstrogenItemTags)
        pack.addProvider(::CreateEstrogenBlockTags)
        pack.addProvider(::CreateEstrogenModels)
    }

    override fun setupFabric(pack: EstrogenPack) {
    }

    override fun setupForge(pack: EstrogenPack) {
    }
}