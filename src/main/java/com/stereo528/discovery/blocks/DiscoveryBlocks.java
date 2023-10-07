package com.stereo528.discovery.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static com.stereo528.discovery.Discovery.ITEM_GROUP;
import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryBlocks {
	public static final Block VARIABLE_REDSTONE_LAMP = registerBlock("variable_redstone_lamp", new VariableRedstoneLampBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).isValidSpawn(Blocks::always).lightLevel(VariableRedstoneLampBlock.LIGHT_EMISSION)));



	public static Block registerBlock(String name, Block block) {
		BlockItem item = new BlockItem(block, new QuiltItemSettings());
		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.accept(item);
		});
		Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, name), item);
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name), block);
	}

	public static void init() {}
}
