package dev.mayaqq.createestrogen

import dev.myaqq.createestrogen.datagen.CreateEstrogenRecipeProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext


//@EventBusSubscriber(modid = "createestrogen", bus = EventBusSubscriber.Bus.MOD)
@Mod("createestrogen")
class CreateEstrogenDataGen() {
    init {
        CreateEstrogen.init()
        val eventBus = FMLJavaModLoadingContext.get().modEventBus
        eventBus.addListener(::gatherData)
    }
    companion object {
        @SubscribeEvent
        @JvmStatic
        fun gatherData(event: GatherDataEvent) {
            CreateEstrogen.info("FUCK")
            val generator = event.generator
            val output = generator.packOutput
            generator.addProvider(event.includeServer(),CreateEstrogenRecipeProvider(output))
            if (event.includeServer()) {
                CreateEstrogenRecipeProvider.registerAllProcessing(generator,output)
            }
        }
    }

}