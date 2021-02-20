package me.doggy.tutorial.setup;

import me.doggy.tutorial.Main;
import me.doggy.tutorial.setup.metals.Metal;
import me.doggy.tutorial.setup.metals.MetalTag;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags
{
    public static final String FORGE_NAMESPACE = "forge";
    public static final String MOD_NAMESPACE = Main.MOD_ID;


    public static final class Blocks {

        public static ITag.INamedTag<Block> makeTag(String namespaceIn, String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation(namespaceIn, path).toString());
        }
    }
    public static final class Items {

        public static ITag.INamedTag<Item> makeTag(String namespaceIn, String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation(namespaceIn, path).toString());
        }
    }

    public static final class Metals
    {
        public static final MetalTag SILVER = makeTag(FORGE_NAMESPACE, ModMetals.SILVER);

        public static MetalTag makeTag(String namespaceIn, Metal metal) {
            return new MetalTag(metal, namespaceIn);
        }
    }
}
