package me.doggy.tutorial.data.loot;

import me.doggy.tutorial.Main;
import me.doggy.tutorial.setup.ModMetals;
import me.doggy.tutorial.setup.metals.Metal;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootTables {

    private static final ItemPredicate.Builder DIAMOND_PICKAXE = ItemPredicate.Builder.create().item(Items.DIAMOND_PICKAXE);
    private static final ItemPredicate.Builder DIAMOND_PICKAXE_SILK_TOUCH = DIAMOND_PICKAXE.enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)));
    private static final ItemPredicate.Builder SILK_TOUCH = ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)));

    @Override
    protected void addTables() {
        AddMetal(ModMetals.SILVER);
    }


    private void registerLootTableLikeDiamond(Metal metal)
    {
        registerLootTable(metal.getOre().get(), LootTable.builder()
                .addLootPool(LootPool.builder()
                        .addEntry(AlternativesLootEntry.builder()
                                .alternatively(ItemLootEntry.builder(metal.getOre().get())
                                        .acceptCondition(MatchTool.builder(SILK_TOUCH))
                                )
                                .alternatively(ItemLootEntry.builder(metal.getIngot().get())
                                        .acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))
                                        .acceptFunction(ExplosionDecay.builder())
                                )
                        )
                )
        );
    }

    private void AddMetal(Metal metal) {
        if(metal.hasBlock())
            registerDropSelfLootTable(metal.getBlock().get());

        if(metal.hasOre())
        {


            switch (metal.settings.oreDrop)
            {
                case itself: {
                    registerDropSelfLootTable(metal.getOre().get());
                    break;
                }
                case ingot: {
                    if (!metal.hasIngot()) {
                        throw new IllegalStateException("can't drop ingot when metal doesn't have it");
                    }
                    registerLootTableLikeDiamond(metal);
                    break;
                }
            }
        }



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> Main.MOD_ID.equals(block.getRegistryName().getNamespace()))
                .collect(Collectors.toSet());
    }
}
