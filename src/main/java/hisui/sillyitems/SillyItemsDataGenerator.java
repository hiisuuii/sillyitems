package hisui.sillyitems;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Consumer;

public class SillyItemsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModLanguageGenerator::new);
	}

	private static class ModModelGenerator extends FabricModelProvider {
		private ModModelGenerator(FabricDataOutput generator){
			super(generator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator){

			itemModelGenerator.register(SillyItems.AZIDOAZIDEAZIDE, Models.GENERATED);
			itemModelGenerator.register(SillyItems.EMPTY_STANLEY, Models.GENERATED);
			itemModelGenerator.register(SillyItems.FILLED_STANLEY, Models.GENERATED);
		}
	}

	private static class ModRecipeGenerator extends FabricRecipeProvider {

		public ModRecipeGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generate(Consumer<RecipeJsonProvider> exporter) {
			ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, SillyItems.AZIDOAZIDEAZIDE)
					.input(Items.ROTTEN_FLESH, 3).input(Items.BROWN_MUSHROOM).input(ItemTags.COALS)
					.criterion(FabricRecipeProvider.hasItem(Items.ROTTEN_FLESH),
							FabricRecipeProvider.conditionsFromItem(Items.ROTTEN_FLESH))
					.criterion(FabricRecipeProvider.hasItem(Items.BROWN_MUSHROOM),
							FabricRecipeProvider.conditionsFromItem(Items.BROWN_MUSHROOM))
					.criterion(FabricRecipeProvider.hasItem(Items.COAL),
							FabricRecipeProvider.conditionsFromTag(ItemTags.COALS))
					.criterion(FabricRecipeProvider.hasItem(Items.CHARCOAL),
							FabricRecipeProvider.conditionsFromTag(ItemTags.COALS))
					.criterion(FabricRecipeProvider.hasItem(SillyItems.AZIDOAZIDEAZIDE),
							FabricRecipeProvider.conditionsFromItem(SillyItems.AZIDOAZIDEAZIDE)).offerTo(exporter);

			ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, SillyItems.BLINDNESS_SOUP).input(Items.BOWL)
					.input(Items.BROWN_MUSHROOM).input(Items.RED_MUSHROOM).input(Items.SPIDER_EYE)
					.input(Items.NETHER_WART).input(Items.FEATHER)
					.criterion(FabricRecipeProvider.hasItem(Items.BOWL),
							FabricRecipeProvider.conditionsFromItem(Items.BOWL))
					.criterion(FabricRecipeProvider.hasItem(Items.NETHER_WART),
							FabricRecipeProvider.conditionsFromItem(Items.NETHER_WART))
					.criterion(FabricRecipeProvider.hasItem(Items.RED_MUSHROOM),
							FabricRecipeProvider.conditionsFromItem(Items.RED_MUSHROOM))
					.criterion(FabricRecipeProvider.hasItem(Items.BROWN_MUSHROOM),
							FabricRecipeProvider.conditionsFromItem(Items.BROWN_MUSHROOM))
					.criterion(FabricRecipeProvider.hasItem(Items.SPIDER_EYE),
							FabricRecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
					.criterion(FabricRecipeProvider.hasItem(Items.FEATHER),
							FabricRecipeProvider.conditionsFromItem(Items.FEATHER))
					.criterion(FabricRecipeProvider.hasItem(SillyItems.BLINDNESS_SOUP),
							FabricRecipeProvider.conditionsFromItem(SillyItems.BLINDNESS_SOUP)).offerTo(exporter);
		}
	}

	private static class ModLanguageGenerator extends FabricLanguageProvider {
		protected ModLanguageGenerator(FabricDataOutput dataOutput) {
			super(dataOutput);
		}

		@Override
		public void generateTranslations(TranslationBuilder tb) {
			tb.add(SillyItems.AZIDOAZIDEAZIDE, "Azidoazide Azide");
			tb.add(SillyItems.BLINDNESS_SOUP, "1-Day Blindness Stew");
			tb.add(SillyItems.EMPTY_STANLEY, "Stanley Cup");
			tb.add(SillyItems.FILLED_STANLEY, "Stanley Cup (Filled)");
			tb.add(SillyItems.EMPTY_STANLEY.getTranslationKey() + ".desc", "Contains Lead");
			tb.add(SillyItems.FILLED_STANLEY.getTranslationKey() + ".desc", "Contains Lead");
			tb.add(SillyItems.AZIDOAZIDEAZIDE.getTranslationKey() + ".desc", "C₂N₁₄");
		}
	}
}
