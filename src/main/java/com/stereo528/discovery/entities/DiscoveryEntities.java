package com.stereo528.discovery.entities;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import static com.stereo528.discovery.Discovery.MODID;

public class DiscoveryEntities {

	public static final EntityType<FlowerStrider> FLOWER_STRIDER = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(MODID, "flower_strider"), QuiltEntityTypeBuilder.create(MobCategory.AMBIENT, FlowerStrider::new).setDimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

	public static void init() {}
}
