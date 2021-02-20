package me.doggy.tutorial.data;

import me.doggy.tutorial.Main;
import me.doggy.tutorial.setup.metals.Metal;
import me.doggy.tutorial.setup.ModTags;
import me.doggy.tutorial.setup.metals.MetalTag;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {


    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, Main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {

        registerMetal(ModTags.Metals.SILVER);

        /*getOrCreateBuilder(ModTags.Blocks.ORES_SILVER).add(ModMetals.SILVER.getOre().get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModMetals.SILVER.getBlock().get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);*/
    }

    protected void registerMetal(MetalTag metalTag)
    {
        Metal metal = metalTag.getMetal();

        if(metal.hasOre()) {
            ITag.INamedTag<Block> oreTag = metalTag.getOre_BlockTag();
            getOrCreateBuilder(oreTag).add(metal.getOre().get());
            getOrCreateBuilder(Tags.Blocks.ORES).addTag(oreTag);
        }

        if(metal.hasBlock()) {
            ITag.INamedTag<Block> storageBlockTag = metalTag.getBlock_BlockTag();
            getOrCreateBuilder(storageBlockTag).add(metal.getBlock().get());
            getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(storageBlockTag);
        }

    }
}
