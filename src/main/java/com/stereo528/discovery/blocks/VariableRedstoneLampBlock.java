package com.stereo528.discovery.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class VariableRedstoneLampBlock extends Block {

	public static final BooleanProperty LIT;

	public static final IntegerProperty POWER;

	public static final ToIntFunction<BlockState> LIGHT_EMISSION;
	public VariableRedstoneLampBlock(Properties properties) {
		super(properties);
		this.registerDefaultState((BlockState)this.defaultBlockState().setValue(LIT, false).setValue(POWER, 0));
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		return (BlockState)this.defaultBlockState().setValue(LIT, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos())).setValue(POWER, getInputSignal(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos()));
	}

	public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
		if (!level.isClientSide) {
			boolean lit = (Boolean)blockState.getValue(LIT);
			if (lit != level.hasNeighborSignal(blockPos)) {
				if (lit) {
					level.scheduleTick(blockPos, this, 4);
				} else {
					level.setBlock(blockPos, (BlockState) blockState.cycle(LIT).setValue(POWER, getInputSignal(level, blockPos)), 2);
				}
			}
		}
	}

	public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		if ((Boolean)blockState.getValue(LIT) && !serverLevel.hasNeighborSignal(blockPos)) {
			serverLevel.setBlock(blockPos, (BlockState)blockState.cycle(LIT).setValue(POWER, getInputSignal(serverLevel, blockPos)), 2);
		}
		if(!blockState.getValue(LIT)) {
			serverLevel.setBlock(blockPos, blockState.setValue(POWER, 0), 2);
		}
	}

	protected int getInputSignal(Level level, BlockPos blockPos) {
		Direction[] directions = {Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
		int power = 0;
		for (Direction direction : directions) {
			int neighborPower = level.getSignal(blockPos.relative(direction), direction);
			if (neighborPower >= 15)
				return 15;
			if (neighborPower > power)
				power = neighborPower;


		}
		return power;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{LIT, POWER});
	}

	static {
		LIT = RedstoneTorchBlock.LIT;
		POWER = BlockStateProperties.POWER;

		LIGHT_EMISSION = (blockState) -> {
			return (Integer)blockState.getValue(POWER);
		};
	}
}
