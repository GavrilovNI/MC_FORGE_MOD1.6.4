package me.doggy.tutorial.setup.metals;

import me.doggy.tutorial.setup.ModBlocks;
import me.doggy.tutorial.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class Metal
{
    private String name;
    private RegistryObject<Item> _ingot;
    private RegistryObject<Item> _nugget;
    private RegistryObject<Block> _ore;
    private RegistryObject<Block> _block;

    private float _smeltingXp;
    private int _cookingTime;

    public String getName(){ return name; }
    public RegistryObject<Item> get_ingot() { return _ingot; }
    public RegistryObject<Item> get_nugget() { return _nugget; }
    public RegistryObject<Block> get_ore() { return _ore; }
    public RegistryObject<Block> get_block() { return _block; }

    public float getSmeltingXp() { return _smeltingXp; }
    public int getCookingTime() { return _cookingTime; }

    public boolean hasIngot() { return _ingot != null; }
    public boolean hasNugget() { return _nugget != null; }
    public boolean hasOre() { return _ore != null; }
    public boolean hasBlock() { return _block != null; }

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
    public Metal registerOre(java.util.function.Supplier<Block> sup, float smeltingXp, int cookingTime)
    {
        if(_ore == null)
        {
            this._smeltingXp = smeltingXp;
            this._cookingTime = cookingTime;
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