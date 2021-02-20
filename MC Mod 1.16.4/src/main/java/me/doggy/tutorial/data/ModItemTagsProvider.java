package me.doggy.tutorial.data;

import me.doggy.tutorial.Main;
import me.doggy.tutorial.setup.ModTags;
import me.doggy.tutorial.setup.metals.Metal;
import me.doggy.tutorial.setup.metals.MetalTag;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, Main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);


        /*
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModMetals.SILVER.get_ingot().get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
        */

        registerMetal(ModTags.Metals.SILVER);
    }

    protected void registerMetal(MetalTag metalTag)
    {
        Metal metal = metalTag.getMetal();

        if(metal.hasOre())
            copy(metalTag.getOre_BlockTag(), metalTag.getOre_ItemTag());
        if(metal.hasBlock())
            copy(metalTag.getBlock_BlockTag(), metalTag.getBlock_ItemTag());

        if(metal.hasIngot())
        {
            ITag.INamedTag<Item> ingotTag = metalTag.getIngot_ItemTag();
            getOrCreateBuilder(ingotTag).add(metal.getIngot().get());
            getOrCreateBuilder(Tags.Items.INGOTS).addTag(ingotTag);
        }

        if(metal.hasNugget())
        {
            ITag.INamedTag<Item> nuggetTag = metalTag.getNugget_ItemTag();
            getOrCreateBuilder(nuggetTag).add(metal.getNugget().get());
            getOrCreateBuilder(Tags.Items.NUGGETS).addTag(nuggetTag);
        }

    }
}
