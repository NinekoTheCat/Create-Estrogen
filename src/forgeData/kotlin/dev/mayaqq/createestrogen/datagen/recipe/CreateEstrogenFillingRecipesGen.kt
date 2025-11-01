package dev.mayaqq.createestrogen.datagen.recipe

import com.simibubi.create.AllItems
import com.simibubi.create.api.data.recipe.FillingRecipeGen
import com.simibubi.create.content.fluids.transfer.FillingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.content.EstrogenPotions
import dev.myaqq.createestrogen.datagen.getFluidAmount
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Items
import net.minecraft.world.item.alchemy.PotionUtils
import net.minecraft.world.level.material.Fluids


class CreateEstrogenFillingRecipesGen(packOutput: PackOutput) : FillingRecipeGen(packOutput, MOD_ID) {
    init {
        create<FillingRecipe>(
            "crystal_estrogen_pill"
        ) { builder ->
            builder
                .require(EstrogenItems.EstrogenPill)
                .require(EstrogenFluids.MoltenAmethyst.value, getFluidAmount(27000))
                .output(EstrogenItems.CrystalEstrogenPill, 1)
        }

        create<FillingRecipe>(
            "estrogen_pill"
        ) { builder ->
            builder
                .require(Items.COOKIE)
                .require(EstrogenFluids.LiquidEstrogen.value, getFluidAmount(27000))
                .output(EstrogenItems.EstrogenPill, 1)
        }

        create<FillingRecipe>(
            "filter"
        ) { builder ->
            builder
                .require(CreateEstrogenItems.UsedFilter)
                .require(Fluids.WATER, getFluidAmount(27000))
                .output(AllItems.FILTER, 1)
        }

        create<FillingRecipe>(
            "estrogen_tipped_arrow"
        ) { builder ->
            builder
                .require(Items.ARROW)
                .require(EstrogenFluids.LiquidEstrogen.value, getFluidAmount(27000))
                .output(Items.TIPPED_ARROW.defaultInstance.also {
                    PotionUtils.setPotion(
                        it,
                        EstrogenPotions.EstrogenPotion
                    )
                })
        }

        create<FillingRecipe>("gender_change_potion") { builder ->
            builder
                .require(Items.GLASS_BOTTLE)
                .require(EstrogenFluids.GenderFluid.value, getFluidAmount(27000))
                .output(EstrogenItems.GenderChangePotion)
        }

        create<FillingRecipe>("blahaj") {
            it.require(Items.LIGHT_BLUE_WOOL)
                .require(EstrogenFluids.LiquidEstrogen.value, getFluidAmount(81))
                .output(100f, ResourceLocation("blahaj", "blue_shark"), 1)
                .whenModLoaded("blahaj")
        }
    }
}