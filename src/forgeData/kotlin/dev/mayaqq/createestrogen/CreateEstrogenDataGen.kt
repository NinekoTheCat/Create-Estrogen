package dev.mayaqq.createestrogen

import dev.mayaqq.createestrogen.datagen.recipe.CreateEstrogenRecipeProvider
import dev.myaqq.createestrogen.datagen.*
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber(modid = "createestrogen", bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod("createestrogen")
object CreateEstrogenDataGen {

    init {
        CreateEstrogen.init()
    }

    @SubscribeEvent
    @JvmStatic
    fun gatherData(event: GatherDataEvent) {
        CreateEstrogen.info("Firing Datagen")
        val generator = event.generator
        val output = generator.packOutput
        if (generator.providersView.isNotEmpty()) return
        generator.addProvider(event.includeServer(), CreateEstrogenLootTableProvider(output))
        generator.addProvider(
            event.includeClient(),
            CreateEstrogenItemModelProvider(output, event.existingFileHelper)
        )
        generator.addProvider(event.includeServer(), CreateEstrogenRecipeProvider(output))
        generator.addProvider(event.includeClient(), CreateEstrogenLanguageProvider(output, "en_us"))
        val blockTagProvider =
            CreateEstrogenBlockTagProvider(output, event.lookupProvider, event.existingFileHelper)
        generator.addProvider(event.includeServer(), blockTagProvider)
        generator.addProvider(
            event.includeServer(),
            CreateEstrogenItemTagProvider(
                output,
                event.lookupProvider,
                blockTagProvider.contentsGetter(),
                event.existingFileHelper
            )
        )
        if (event.includeServer()) {
            CreateEstrogenRecipeProvider.registerAllProcessing(generator,output)
        }

    }

}