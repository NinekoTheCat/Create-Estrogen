package dev.mayaqq.createestrogen.content.packages

import com.simibubi.create.content.logistics.box.PackageStyles.PackageStyle
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import dev.mayaqq.estrogen.content.EstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.items.ItemStackHandler

object CreateEstrogenPackageStyles {

    val estrogenPillStyles = listOf(
        PackageStyle("createestrogen:estrogen_cardboard", 12, 12, 23f, false),
        PackageStyle("createestrogen:estrogen_cardboard", 10, 12, 22f, false),
        PackageStyle("createestrogen:estrogen_cardboard", 10, 8, 18f, false),
        PackageStyle("createestrogen:estrogen_cardboard", 12, 10, 21f, false),
    )
    private val allowedItemsToBeCounted by lazy {
        setOf(
            EstrogenItems.EstrogenPill,
            EstrogenItems.CrystalEstrogenPill,
            EstrogenBlocks.EstrogenPillBlock.asItem()
        )
    }

    @JvmStatic
    fun containing(stacks: ItemStackHandler): ItemStack? {
        if (isMajorityOfItemsEstrogenItems(stacks)) {
            val box = ItemStack(CreateEstrogenItems.allEstrogenPillBoxes.random().value)
            val compound = CompoundTag()
            compound.put("Items", stacks.serializeNBT())
            box.tag = compound
            return box
        } else return null
    }

    private fun isMajorityOfItemsEstrogenItems(stacks: ItemStackHandler): Boolean {
        val itemToAmount = mutableMapOf<Item, Int>()

        for (i in 0..<stacks.slots) {
            val stack = stacks.getStackInSlot(i)
            var amount = itemToAmount.getOrDefault(stack.item, 0)
            amount += stack.count
            itemToAmount[stack.item] = amount
        }
        val itemToAmountImmutable: Map<Item, Int> = itemToAmount
        val amountOfEstrogenPillLikeItems = itemToAmountImmutable.getOrDefault(EstrogenItems.EstrogenPill, 0) +
                itemToAmountImmutable.getOrDefault(EstrogenItems.CrystalEstrogenPill, 0) +
                (itemToAmountImmutable.getOrDefault(EstrogenBlocks.EstrogenPillBlock.asItem(), 0) * 9)
        val amountOfOtherItems = itemToAmountImmutable.filterKeys { !allowedItemsToBeCounted.contains(it) }.asIterable()
            .fold(0) { acc, (_, value) -> acc + value }

        return amountOfEstrogenPillLikeItems > amountOfOtherItems
    }
}

