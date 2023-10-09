package com.stereo528.discovery.items;

import com.stereo528.discovery.Discovery;
import com.stereo528.discovery.tiers.BoneTier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static com.stereo528.discovery.Discovery.ITEM_GROUP;
import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryItems {
	public static Item SUNFLOWER_SEEDS = registerItem("sunflower_seeds", new Item(new QuiltItemSettings().food(new FoodProperties.Builder().fast().nutrition(1).saturationMod(0.5f).build())));

	public static Item BONE_SWORD = registerItem("bone_sword", new SwordItem(new BoneTier(), 5, -2.4f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_SHOVEL = registerItem("bone_shovel", new ShovelItem(new BoneTier(), 4, -3.0f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_PICKAXE = registerItem("bone_pickaxe", new PickaxeItem(new BoneTier(), 3, -2.8f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_AXE = registerItem("bone_axe", new AxeItem(new BoneTier(), 5, -3.1f, new QuiltItemSettings().maxCount(1)));
	public static Item BONE_HOE = registerItem("bone_hoe", new HoeItem(new BoneTier(), 1, -1.5f, new QuiltItemSettings().maxCount(1)));

	public static Item registerItem(String name, Item item) {
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> content.accept(item));
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
	}

	public static void init() {
	}
}
