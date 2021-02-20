package me.doggy.tutorial.data.client;

import me.doggy.tutorial.Main;
import me.doggy.tutorial.setup.ModMetals;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Main.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModMetals.SILVER.get_ore().get());
        simpleBlock(ModMetals.SILVER.get_block().get());
    }
}
