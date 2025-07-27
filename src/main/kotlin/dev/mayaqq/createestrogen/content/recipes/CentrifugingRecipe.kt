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
import earth.terrarium.botarium.common.fluid.utils.FluidIngredient
import net.minecraft.core.RegistryAccess
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

class CentrifugingRecipe(val _id: ResourceLocation, val processingTime: Int, val inputs: FluidIngredient, val result: FluidHolder) : Recipe<CentrifugingContainer>{
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
        return inputs.fluids.all { ingredient -> ingredient.fluidAmount <= actualFluidAmounts.getOrDefault(ingredient.fluid,0) }
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
                Codec.INT.fieldOf("processing_time").forGetter(CentrifugingRecipe::processingTime),
                FluidIngredient.CODEC.fieldOf("ingredients").forGetter(CentrifugingRecipe::inputs),
                FluidHolder.NEW_CODEC.fieldOf("result").forGetter(CentrifugingRecipe::result)

            ).apply(instance,::CentrifugingRecipe)
        }

        fun netCodec(id: ResourceLocation): ByteCodec<CentrifugingRecipe> = ObjectByteCodec.create(
            ByteCodecs.constantFieldOf(id),
            ByteCodec.INT fieldOf CentrifugingRecipe::processingTime,
            FluidIngredient.CODEC.toByteCodec() fieldOf CentrifugingRecipe::inputs,
            FluidHolder.NEW_CODEC.toByteCodec() fieldOf CentrifugingRecipe::result,
            ::CentrifugingRecipe
        )
    }


}