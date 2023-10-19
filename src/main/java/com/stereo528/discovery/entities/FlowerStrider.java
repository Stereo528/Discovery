package com.stereo528.discovery.entities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FlowerStrider extends Animal {
	protected FlowerStrider(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}

	@Nullable
	@Override
	public FlowerStrider getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}
}
