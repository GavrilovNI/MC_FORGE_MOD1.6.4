package me.doggy.tutorial.data.recipes;

import me.doggy.tutorial.setup.ModTags;
import me.doggy.tutorial.setup.metals.Metal;
import me.doggy.tutorial.setup.metals.MetalTag;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {

    public ModRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        registerMetal(consumer, ModTags.Metals.SILVER);
    }

    private void registerMetal(Consumer<IFinishedRecipe> consumer, MetalTag metalTag)
    {
        Metal metal = metalTag.getMetal();
        if (metal.hasOre()) {

            CookingRecipeBuilder.smeltingRecipe(Ingredient.fromTag(metalTag.getOre_ItemTag()), metal.getIngot().get(), metal.settings.smeltingXp, metal.settings.cookingTime)
                    .addCriterion("has_item", hasItem(metalTag.getOre_ItemTag()))
                    .build(consumer, new ResourceLocation(metal.getName() + "_ore_smelting"));
        }

        if(metal.hasIngot()) {

            InventoryChangeTrigger.Instance hasIngot = hasItem(metalTag.getIngot_ItemTag());

            ITag<Item> ingotTag = metalTag.getIngot_ItemTag();
            IItemProvider ingot = metal.getIngot().get();

            if (metal.hasBlock()) {

                ITag<Item> blockTag = metalTag.getBlock_ItemTag();
                IItemProvider block = metal.getBlock().get();

                ShapelessRecipeBuilder.shapelessRecipe(ingot, 9)
                        .addIngredient(blockTag)
                        .addCriterion("has_item", hasIngot)
                        .build(consumer, new ResourceLocation(ingot.asItem().getRegistryName() + "_from_block"));
                ShapedRecipeBuilder.shapedRecipe(block)
                        .key('#', ingotTag)
                        .patternLine("###")
                        .patternLine("###")
                        .patternLine("###")
                        .addCriterion("has_item", hasIngot)
                        .build(consumer);
            }

            if (metal.hasNugget()) {

                ITag<Item> nuggetTag = metalTag.getNugget_ItemTag();
                IItemProvider nugget = metal.getBlock().get();

                ShapelessRecipeBuilder.shapelessRecipe(nugget, 9)
                        .addIngredient(ingotTag)
                        .addCriterion("has_item", hasIngot)
                        .build(consumer);
                ShapedRecipeBuilder.shapedRecipe(ingot)
                        .key('#', nuggetTag)
                        .patternLine("###")
                        .patternLine("###")
                        .patternLine("###")
                        .addCriterion("has_item", hasIngot)
                        .build(consumer, new ResourceLocation(ingot.asItem().getRegistryName() + "_from_nuggets"));
            }
        }
    }

}
