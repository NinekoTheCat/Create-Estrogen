package dev.mayaqq.createestrogen.content.recipes

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import com.teamresourceful.bytecodecs.base.ByteCodec
import com.teamresourceful.bytecodecs.base.`object`.ObjectByteCodec
import dev.mayaqq.createestrogen.content.CreateEstrogenRecipes
import dev.mayaqq.cynosure.core.bytecodecs.ByteCodecs
import dev.mayaqq.cynosure.core.bytecodecs.toByteCodec
import dev.mayaqq.cynosure.core.codecs.fieldOf
import earth.terrarium.botarium.common.fluid.base.FluidContainer
import earth.terrarium.botarium.common.fluid.base.FluidHolder
import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.Container
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.crafting.RecipeType
import net.minecraft.world.level.Level
import net.minecraft.world.level.material.Fluid

/**
 * Container for centrifuges, throws [UnsupportedOperationException] if any methods from [Container] are used
 * @param input fluid that is input into this recipe
 */
data class CentrifugingContainer(val input :FluidContainer) : Container {
    override fun clearContent() = throw UnsupportedOperationException()

    override fun getContainerSize(): Int = throw UnsupportedOperationException()

    override fun isEmpty(): Boolean = throw UnsupportedOperationException()

    override fun getItem(p0: Int): ItemStack = throw UnsupportedOperationException()

    override fun removeItem(p0: Int, p1: Int): ItemStack = throw UnsupportedOperationException()

    override fun removeItemNoUpdate(p0: Int): ItemStack = throw UnsupportedOperationException()

    override fun setItem(p0: Int, p1: ItemStack) = throw UnsupportedOperationException()

    override fun setChanged() = throw UnsupportedOperationException()

    override fun stillValid(p0: Player): Boolean = throw UnsupportedOperationException()
}

/**
 * an ingredient for a recipe that requires a throughput of fluid instead of a specific amount
 * @property fluid the type of fluid to input
 * @property amountPerTick the amount per tick this can output/input of the fluid
 */
data class RatioFluidIngredient(
    val fluid: Fluid,
    val amountPerTick: Long
) {
    val holder get() = FluidHolder.of(fluid,amountPerTick)

    companion object {
        fun codec(): Codec<RatioFluidIngredient> = RecordCodecBuilder.create {instance ->
            instance.group(
                BuiltInRegistries.FLUID.byNameCodec().fieldOf("fluid").forGetter(RatioFluidIngredient::fluid),
                Codec.LONG.fieldOf(RatioFluidIngredient::amountPerTick)
            ).apply(instance,::RatioFluidIngredient)
        }
        fun netCodec() : ByteCodec<RatioFluidIngredient> = ObjectByteCodec.create(
            BuiltInRegistries.FLUID.byNameCodec().toByteCodec() fieldOf RatioFluidIngredient::fluid ,
            ByteCodec.LONG fieldOf RatioFluidIngredient::amountPerTick,
            ::RatioFluidIngredient

        )
    }


}

/**
 * an output of an ingredient for a recipe that requires a throughput of fluid instead of a specific amount
 * @property fluid fluid to output
 * @property amountPerTick the amount per tick to output
 */
data class RatioFluidOutput(
    val fluid: Fluid,
    val amountPerTick: Long
) {

    val holder get() = FluidHolder.of(fluid,amountPerTick)
    companion object {
        fun codec(): Codec<RatioFluidOutput> = RecordCodecBuilder.create {instance ->
            instance.group(
                BuiltInRegistries.FLUID.byNameCodec().fieldOf(RatioFluidOutput::fluid),
                Codec.LONG.fieldOf(RatioFluidOutput::amountPerTick)
            ).apply(instance,::RatioFluidOutput)
        }
        fun netCodec() : ByteCodec<RatioFluidOutput> = ObjectByteCodec.create(
            BuiltInRegistries.FLUID.byNameCodec().toByteCodec() fieldOf RatioFluidOutput::fluid ,
            ByteCodec.LONG fieldOf RatioFluidOutput::amountPerTick,
            ::RatioFluidOutput
        )
    }

}
class CentrifugingRecipe(val _id: ResourceLocation,
                         val inputs: List<RatioFluidIngredient>,
                         val result: RatioFluidOutput) : Recipe<CentrifugingContainer>{
    override fun matches(circumstance: CentrifugingContainer, p1: Level): Boolean {
        /// this is assuming that .fluids always returns merged fluids
        val actualFluidAmounts = mutableMapOf<Fluid,Long>()
        for (fluidHolder in circumstance.input.fluids) {
            if (fluidHolder.isEmpty) continue
            val fluidAmount = fluidHolder.fluidAmount
            actualFluidAmounts.compute(fluidHolder.fluid) {_,actualAmount ->
                if (actualAmount == null) return@compute fluidAmount
                /// crash if overflow
                return@compute  Math.addExact(fluidAmount,actualAmount)
            }
        }
        /// actualFluidAmounts should now have all the fluids without any slots business
        /// check if ALL the ingredients are satisfied
        return inputs.all { ingredient -> ingredient.amountPerTick <= actualFluidAmounts.getOrDefault(ingredient.fluid,0) }
    }

    override fun getId(): ResourceLocation = _id
    override fun assemble(p0: CentrifugingContainer, p1: RegistryAccess): ItemStack = throw UnsupportedOperationException()

    override fun canCraftInDimensions(p0: Int, p1: Int): Boolean = throw UnsupportedOperationException()
    override fun getResultItem(p0: RegistryAccess): ItemStack = throw UnsupportedOperationException()


    override fun getSerializer(): RecipeSerializer<*> = CreateEstrogenRecipes.Serializers.CENTRIFUGING_SERIALIZER

    override fun getType(): RecipeType<*> = CreateEstrogenRecipes.CENTRIFUGING
    companion object RecipeViewerInfo {
        fun codec(id: ResourceLocation): Codec<CentrifugingRecipe> = RecordCodecBuilder.create { instance ->
            instance.group(
                RecordCodecBuilder.point(id),
                RatioFluidIngredient.codec().listOf().fieldOf("ingredients").forGetter(CentrifugingRecipe::inputs),
               RatioFluidOutput.codec().fieldOf("result").forGetter(CentrifugingRecipe::result)

            ).apply(instance,::CentrifugingRecipe)
        }

        fun netCodec(id: ResourceLocation): ByteCodec<CentrifugingRecipe> = ObjectByteCodec.create(
            ByteCodecs.constantFieldOf(id),
            RatioFluidIngredient.netCodec().listOf() fieldOf CentrifugingRecipe::inputs,
            RatioFluidOutput.netCodec() fieldOf CentrifugingRecipe::result,
            ::CentrifugingRecipe
        )
    }


}