package dev.mayaqq.createestrogen.datagen

import dev.latvian.mods.kubejs.recipe.RecipeSchemaProvider
import dev.mayaqq.createestrogen.datagen.loottables.CreateEstrogenLoottables
import dev.mayaqq.createestrogen.datagen.models.CreateEstrogenItemModels
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenCentrifugingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenCompactingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenDeployingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenEmptyingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenFillingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenItemApplicationRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenMillingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenMixingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenRecipes
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSandpaperPolishingRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSequencedAssemblyRecipesGen
import dev.mayaqq.createestrogen.datagen.recipes.CreateEstrogenSplashingRecipesGen
import dev.mayaqq.createestrogen.datagen.tags.CreateEstrogenBlockTags
import dev.mayaqq.createestrogen.datagen.tags.CreateEstrogenItemTags
import dev.mayaqq.createestrogen.datagen.translations.CreateEstrogenTranslations
import dev.mayaqq.createestrogen.id
import invoke.kitty.kritter.platform.Mod
import invoke.kitty.kritter.platform.forge.EntrypointHandler
import invoke.kitty.kritter.platform.forge.eventBus
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.data.event.GatherDataEvent
import java.util.concurrent.CompletableFuture

@EntrypointHandler("init")
fun init(mod: Mod) {
    mod.eventBus.register(CreateEstrogenDatagen)
}

object CreateEstrogenDatagen {

    @SubscribeEvent
    fun onDatagenInit(event: GatherDataEvent) {
        val generator = event.generator
        val efh = event.existingFileHelper
        val lookup = event.lookupProvider
//        event.addProvider(object: RecipeSchemaProvider("Create: Estrogen Recipe Schema Provider",event) {
//            override fun add(lookup: HolderLookup.Provider?) {
//                add(id("centrifuging")) { builder ->
//                }
//            }
//        })
        event.includeClient().apply {
            generator.addProvider(this, ::CreateEstrogenTranslations)
            generator.addProvider(this) { output -> CreateEstrogenItemModels(output, efh) }
        }
        event.includeServer().apply {
            val blockTags = generator.addProvider(this) { output -> CreateEstrogenBlockTags(output, lookup, efh) }
            generator.addProvider(this) { output -> CreateEstrogenItemTags(output, lookup, blockTags.contentsGetter(), efh) }
            generator.addProvider(this) { output -> CreateEstrogenLoottables(output, lookup) }


            // Recipes
            event.addProvider(this, ::CreateEstrogenRecipes)
            event.addProvider(this, ::CreateEstrogenCentrifugingRecipesGen)
            event.addProvider(this, ::CreateEstrogenCompactingRecipesGen)
            event.addProvider(this, ::CreateEstrogenDeployingRecipesGen)
            event.addProvider(this, ::CreateEstrogenEmptyingRecipesGen)
            event.addProvider(this, ::CreateEstrogenFillingRecipesGen)
            event.addProvider(this, ::CreateEstrogenItemApplicationRecipesGen)
            event.addProvider(this, ::CreateEstrogenMillingRecipesGen)
            event.addProvider(this, ::CreateEstrogenMixingRecipesGen)
            event.addProvider(this, ::CreateEstrogenSandpaperPolishingRecipesGen)
            event.addProvider(this, ::CreateEstrogenSequencedAssemblyRecipesGen)
            event.addProvider(this, ::CreateEstrogenSplashingRecipesGen)

        }
    }

    fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, provider: (PackOutput, CompletableFuture<HolderLookup.Provider>) -> T): T {
        return this.generator.addProvider(run) {
            provider.invoke(it, this.lookupProvider)
        }
    }
}