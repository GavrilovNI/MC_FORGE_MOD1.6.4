package me.doggy.tutorial.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    /*
    public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    */



    public static <T extends Item> RegistryObject<T> register(String name, Supplier<T> sup)
    {
        return Registration.ITEMS.register(name, sup);
    }


    static void register() {}
}
