package com.stereo528.discovery.materials;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import static net.minecraft.world.item.Items.BONE;

public class BoneToolTier implements Tier {
	@Override
	public int getUses() {
		return 200;
	}

	@Override
	public float getSpeed() {
		return 6.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 1.5f;
	}

	@Override
	public int getLevel() {
		return 1;
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(BONE);
	}
}
