package me.doggy.tutorial.data;

//https://github.com/SilentChaos512/Silent-Gear/tree/1.16.x/src/main/java/net/silentchaos512/gear

import me.doggy.tutorial.Main;
import me.doggy.tutorial.data.client.ModBlockStateProvider;
import me.doggy.tutorial.data.client.ModItemModelProvider;
import me.doggy.tutorial.data.loot.ModLootTables;
import me.doggy.tutorial.data.recipes.ModRecipesProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private DataGenerators() { }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));

        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
        gen.addProvider(blockTags);
        gen.addProvider(new ModItemTagsProvider(gen, blockTags, existingFileHelper));

        gen.addProvider(new ModLootTables(gen));
        gen.addProvider(new ModRecipesProvider(gen));
    }



}
