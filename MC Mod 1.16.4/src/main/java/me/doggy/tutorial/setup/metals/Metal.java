package me.doggy.tutorial.setup.metals;

import me.doggy.tutorial.setup.ModBlocks;
import me.doggy.tutorial.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class Metal
{
    public enum OreDrop
    {
        itself,
        ingot
    }
    public class MetalSettings
    {
        public OreDrop oreDrop = OreDrop.itself;
        public float smeltingXp = 0.5f;
        public int cookingTime = 200;
    }

    private String name;
    private RegistryObject<Item> _ingot;
    private RegistryObject<Item> _nugget;
    private RegistryObject<Block> _ore;
    private RegistryObject<Block> _block;


    public String getName(){ return name; }
    public RegistryObject<Item> getIngot() { return _ingot; }
    public RegistryObject<Item> getNugget() { return _nugget; }
    public RegistryObject<Block> getOre() { return _ore; }
    public RegistryObject<Block> getBlock() { return _block; }

    public boolean hasIngot() { return _ingot != null; }
    public boolean hasNugget() { return _nugget != null; }
    public boolean hasOre() { return _ore != null; }
    public boolean hasBlock() { return _block != null; }


    public final MetalSettings settings = new MetalSettings();

    public Metal setOreDrop(OreDrop oreDrop) { this.settings.oreDrop = oreDrop; return this; }
    public Metal setSmeltingXp(int smeltingXp) { this.settings.smeltingXp = smeltingXp; return this; }
    public Metal setCookingTime(int cookingTime) { this.settings.cookingTime = cookingTime; return this; }



    public Metal(String name)
    {
        this.name = name;
    }

    public Metal registerIngot(java.util.function.Supplier<Item> sup)
    {
        if(_ingot == null)
        {
            _ingot = Registration.ITEMS.register(name+"_ingot", sup);
        }
        return this;
    }
    public Metal registerNugget(java.util.function.Supplier<Item> sup)
    {
        if(_nugget == null)
        {
            _nugget = Registration.ITEMS.register(name+"_nugget", sup);
        }
        return this;
    }
    public Metal registerOre(java.util.function.Supplier<Block> sup)
    {
        if(_ore == null)
        {
            _ore = ModBlocks.register(name+"_ore", sup);
        }
        return this;
    }
    public Metal registerBlock(java.util.function.Supplier<Block> sup)
    {
        if(_block == null)
        {
            _block = ModBlocks.register(name+"_block", sup);
        }
        return this;
    }


}