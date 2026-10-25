package io.github.luafoxscosmicinsanity.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CosmicCrystalBlockBlock extends Block {
	public CosmicCrystalBlockBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.AMETHYST).strength(8f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.DRAGON));
	}
}