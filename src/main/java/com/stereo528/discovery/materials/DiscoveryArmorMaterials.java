package com.stereo528.discovery.materials;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import static com.stereo528.discovery.Discovery.MODID;

public enum DiscoveryArmorMaterials implements ArmorMaterial {
	BONE("bone", 15, new int[]{1, 4, 6, 2}, 10, SoundEvents.BONE_BLOCK_STEP, 1.0f, 0.0f, Ingredient.of(Items.BONE));


	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 12};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionMultiplier;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Ingredient repairIngredient;

	DiscoveryArmorMaterials(String name, int durabilityMultiplier, int[] ProtectionMultiplier, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionMultiplier = ProtectionMultiplier;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurabilityForType(ArmorItem.Type type) {
		return BASE_DURABILITY[type.getSlot().getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(ArmorItem.Type type) {
		return this.protectionMultiplier[type.getSlot().getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public @NotNull ResourceLocation getTexture() {
		return new ResourceLocation(MODID, "textures/models/armor/" + this.name);
	}

}
