package me.doggy.tutorial.setup.metals;

import me.doggy.tutorial.setup.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

public class MetalTag {

    private Metal _metal;

    private ITag.INamedTag<Item> _ingot;
    private ITag.INamedTag<Item> _nugget;
    private ITag.INamedTag<Item> _oreItem;
    private ITag.INamedTag<Item> _blockItem;

    private ITag.INamedTag<Block> _oreBlock;
    private ITag.INamedTag<Block> _blockBlock;


    public MetalTag(Metal metal, String namespaceIn)
    {
        this._metal = metal;

        if(_metal.get_ingot() != null)
            _ingot = ModTags.Items.makeTag(namespaceIn, "ingots/"+metal.getName());
        if(_metal.get_nugget() != null)
            _nugget = ModTags.Items.makeTag(namespaceIn, "nuggets/"+metal.getName());

        if(_metal.get_ore() != null) {
            _oreItem = ModTags.Items.makeTag(namespaceIn, "ores/" + metal.getName());
            _oreBlock = ModTags.Blocks.makeTag(namespaceIn, "ores/" + metal.getName());
        }

        if(_metal.get_block() != null) {
            _blockItem = ModTags.Items.makeTag(namespaceIn, "storage_blocks/" + metal.getName());
            _blockBlock = ModTags.Blocks.makeTag(namespaceIn, "storage_blocks/" + metal.getName());
        }

    }

    public Metal getMetal() { return _metal; }

    public ITag.INamedTag<Item> getIngot_ItemTag() { return _ingot; }
    public ITag.INamedTag<Item> getNugget_ItemTag() { return _nugget; }

    public ITag.INamedTag<Item> getOre_ItemTag() { return _oreItem; }
    public ITag.INamedTag<Item> getBlock_ItemTag() { return _blockItem; }

    public ITag.INamedTag<Block> getOre_BlockTag() { return _oreBlock; }
    public ITag.INamedTag<Block> getBlock_BlockTag() { return _blockBlock; }

}
