package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.AllItems
import com.simibubi.create.api.data.recipe.MixingRecipeGen
import com.simibubi.create.content.kinetics.mixer.MixingRecipe
import com.simibubi.create.content.processing.recipe.HeatCondition
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.myaqq.createestrogen.datagen.getFluidAmount
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items

class CreateEstrogenMixingRecipesGen(packOutput: PackOutput) : MixingRecipeGen(packOutput, MOD_ID) {
    init {
        create<MixingRecipe>("filtrated_horse_urine") {
            it.require(EstrogenFluids.HorseUrine.value, getFluidAmount(27000))
                .require(AllItems.FILTER)
                .output(EstrogenFluids.FiltratedHorseUrine.value, getFluidAmount(27000))
                .output(CreateEstrogenItems.UsedFilter)
        }
        create<MixingRecipe>("molten_amethyst") {
            it.require(Items.AMETHYST_SHARD)
                .output(EstrogenFluids.MoltenAmethyst.value, getFluidAmount(27000))
                .requiresHeat(HeatCondition.HEATED)
        }
        create<MixingRecipe>("balls") {
            it.require(Items.SLIME_BALL)
                .output(EstrogenItems.Balls)
                .output(EstrogenFluids.MoltenSlime.value, getFluidAmount(27000))
                .requiresHeat(HeatCondition.HEATED)
        }
        create<MixingRecipe>("testosterone_mixture") {
            it.require(EstrogenItems.TestosteronePowder).require(Items.COAL)
                .output(EstrogenFluids.TestosteroneMixture.value, getFluidAmount(54000))
                .requiresHeat(HeatCondition.HEATED)
        }
        create<MixingRecipe>("gender_fluid") {
            it.require(EstrogenFluids.LiquidEstrogen.value, getFluidAmount(20250))
                .require(EstrogenFluids.TestosteroneMixture.value, getFluidAmount(20250))
                .require(Items.POPPY)
                .require(Items.DANDELION)
                .require(Items.BLUE_ORCHID)
                .require(Items.ALLIUM)
                .require(Items.AZURE_BLUET)
                .require(Items.RED_TULIP)
                .require(Items.ORANGE_TULIP)
                .output(EstrogenFluids.GenderFluid.value, getFluidAmount(40500))
        }
    }
}