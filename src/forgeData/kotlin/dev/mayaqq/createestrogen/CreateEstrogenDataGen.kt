package dev.mayaqq.createestrogen

import dev.myaqq.createestrogen.datagen.*
import dev.myaqq.createestrogen.datagen.recipe.CreateEstrogenRecipeProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext


//@EventBusSubscriber(modid = "createestrogen", bus = EventBusSubscriber.Bus.MOD)
@Mod("createestrogen")
class CreateEstrogenDataGen {
    init {
        CreateEstrogen.init()
        val eventBus = FMLJavaModLoadingContext.get().modEventBus
        eventBus.addListener(::gatherData)
    }
    companion object {
        @SubscribeEvent
        @JvmStatic
        fun gatherData(event: GatherDataEvent) {
            CreateEstrogen.info("starting datagens forge...")
            val generator = event.generator
            val output = generator.packOutput
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

}