package com.stereo528.discovery.items;

import com.stereo528.discovery.materials.BoneToolTier;
import com.stereo528.discovery.materials.DiscoveryArmorMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static com.stereo528.discovery.Discovery.ITEM_GROUP;
import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryItems {
	public static Item SUNFLOWER_SEEDS = registerItem("sunflower_seeds", new Item(new QuiltItemSettings().food(new FoodProperties.Builder().fast().nutrition(1).saturationMod(0.5f).build())));

	public static Item BONE_SWORD = registerItem("bone_sword", new SwordItem(new BoneToolTier(), 5, -2.4f, new QuiltItemSettings()));
	public static Item BONE_SHOVEL = registerItem("bone_shovel", new ShovelItem(new BoneToolTier(), 4, -3.0f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_PICKAXE = registerItem("bone_pickaxe", new PickaxeItem(new BoneToolTier(), 3, -2.8f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_AXE = registerItem("bone_axe", new AxeItem(new BoneToolTier(), 5, -3.1f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_HOE = registerItem("bone_hoe", new HoeItem(new BoneToolTier(), 1, -1.5f, new QuiltItemSettings().maxCount(1)));

	public static Item BONE_HELMET = registerItem("bone_helmet", new ArmorItem(DiscoveryArmorMaterials.BONE, ArmorItem.Type.HELMET, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_CHESTPLATE = registerItem("bone_chestplate", new ArmorItem(DiscoveryArmorMaterials.BONE, ArmorItem.Type.CHESTPLATE, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_LEGGINGS = registerItem("bone_leggings", new ArmorItem(DiscoveryArmorMaterials.BONE, ArmorItem.Type.LEGGINGS, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_BOOTS = registerItem("bone_boots", new ArmorItem(DiscoveryArmorMaterials.BONE, ArmorItem.Type.BOOTS, new QuiltItemSettings().maxCount(1)));

	public static Item registerItem(String name, Item item) {
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> content.accept(item));
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
	}

	public static void init() {
	}
}
