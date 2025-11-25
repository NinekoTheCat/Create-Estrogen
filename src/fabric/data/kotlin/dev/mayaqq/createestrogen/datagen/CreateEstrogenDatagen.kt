package dev.mayaqq.createestrogen.datagen

import dev.mayaqq.createestrogen.datagen.loottables.CreateEstrogenLoottables
import dev.mayaqq.createestrogen.datagen.models.CreateEstrogenModels
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenCentrifugingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenCompactingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenDeployingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenEmptyingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenFillingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenItemApplicationRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenMillingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenMixingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenRecipeProvider
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSandpaperPolishingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSequencedAssemblyRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSplashingRecipesGen
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
        pack.addProvider(::CreateEstrogenCentrifugingRecipesGen)
        pack.addProvider(::CreateEstrogenCompactingRecipesGen)
        pack.addProvider(::CreateEstrogenEmptyingRecipesGen)
        pack.addProvider(::CreateEstrogenDeployingRecipesGen)
        pack.addProvider(::CreateEstrogenFillingRecipesGen)
        pack.addProvider(::CreateEstrogenItemApplicationRecipesGen)
        pack.addProvider(::CreateEstrogenMillingRecipesGen)
        pack.addProvider(::CreateEstrogenMixingRecipesGen)
        pack.addProvider(::CreateEstrogenRecipeProvider)
        pack.addProvider(::CreateEstrogenSandpaperPolishingRecipesGen)
        pack.addProvider(::CreateEstrogenSequencedAssemblyRecipesGen)
        pack.addProvider(::CreateEstrogenSplashingRecipesGen)
    }

    override fun setupFabric(pack: EstrogenPack) {
    }

    override fun setupForge(pack: EstrogenPack) {
    }
}