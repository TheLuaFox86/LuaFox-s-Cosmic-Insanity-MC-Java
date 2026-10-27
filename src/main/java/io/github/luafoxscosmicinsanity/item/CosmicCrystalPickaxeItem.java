package io.github.luafoxscosmicinsanity.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

import io.github.luafoxscosmicinsanity.init.LuafoxsCosmicInsanityModItems;

public class CosmicCrystalPickaxeItem extends PickaxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 999;
		}

		@Override
		public float getSpeed() {
			return 9999f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 15;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL.get()));
		}
	};

	public CosmicCrystalPickaxeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 14f, -3f)).rarity(Rarity.RARE).fireResistant());
	}
}