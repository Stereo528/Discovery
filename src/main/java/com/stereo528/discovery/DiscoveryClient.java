package com.stereo528.discovery;

import com.stereo528.discovery.entities.DiscoveryEntities;
import com.stereo528.discovery.entities.FlowerStriderModel;
import com.stereo528.discovery.entities.FlowerStriderRenderer;
import eu.midnightdust.lib.config.MidnightConfig;
import com.stereo528.discovery.config.ModConfig;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryClient implements ClientModInitializer {

	public static final ModelLayerLocation FLOWER_STRIDER_LAYER = new ModelLayerLocation(new ResourceLocation(MODID, "flower_strider"), "main");

	@Override
	public void onInitializeClient(ModContainer mod) {
		MidnightConfig.init(MODID, ModConfig.class);

		EntityRendererRegistry.register(DiscoveryEntities.FLOWER_STRIDER, (FlowerStriderRenderer::new));
		EntityModelLayerRegistry.registerModelLayer(FLOWER_STRIDER_LAYER, FlowerStriderModel::createBodyLayer);
	}
}
