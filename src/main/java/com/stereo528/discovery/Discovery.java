package com.stereo528.discovery;

import com.stereo528.discovery.blocks.DiscoveryBlocks;
import com.stereo528.discovery.items.DiscoveryItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.world.level.block.Blocks.COBBLESTONE;

public class Discovery implements ModInitializer {
	public static final String MODID = "discovery";
	public static final Logger LOGGER = LoggerFactory.getLogger("Discovery");


	public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MODID, "discovery.tab"));
	public static final CreativeModeTab DISCOVERY = FabricItemGroup.builder()
		.icon(() -> new ItemStack(COBBLESTONE))
		.title(Component.translatable("itemGroup.discovery.discovery_tab"))
		.build();

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Are ya ready to go on some Discovery kids?");
		DiscoveryBlocks.init();
		DiscoveryItems.init();

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, DISCOVERY);
	}
}
