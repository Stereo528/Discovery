package com.stereo528.discovery.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.stereo528.discovery.DiscoveryClient;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.stereo528.discovery.Discovery.MODID;

public class FlowerStriderRenderer extends MobRenderer<FlowerStrider, FlowerStriderModel<FlowerStrider>> {
	public FlowerStriderRenderer(EntityRendererProvider.Context context) {
		super(context, new FlowerStriderModel<>(context.bakeLayer(DiscoveryClient.FLOWER_STRIDER_LAYER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FlowerStrider entity) {
		return new ResourceLocation(MODID, "textures/entity/flower_strider.png");
	}
}
