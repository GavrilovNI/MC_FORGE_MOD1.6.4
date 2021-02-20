package me.doggy.tutorial.setup;

import me.doggy.tutorial.setup.metals.Metal;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;


public class ModMetals {


    public static final Metal SILVER = new Metal("silver")
            .registerIngot(() -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)))
            .registerOre(() -> new Block(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(3,10)
                    .harvestLevel(2)
                    .sound(SoundType.STONE)
            ), 0.5f, 200)
            .registerBlock(() -> new Block(AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(3,10)
                    .sound(SoundType.METAL)
            ));

    static void register() {}

}


