package hisui.sillyitems;

import hisui.sillyitems.item.AzidoazideAzideItem;
import hisui.sillyitems.item.EmptyStanleyCupItem;
import hisui.sillyitems.item.FilledStanleyCupItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SillyItems implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MODID = "sillyitems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final Item AZIDOAZIDEAZIDE = registerItem(new AzidoazideAzideItem(new Item.Settings()), "azidoazideazide");
	public static final Item BLINDNESS_SOUP = registerItem(new StewItem(new Item.Settings().food(
			new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(
					new StatusEffectInstance(StatusEffects.BLINDNESS, 24000), 1).alwaysEdible().build()
			)
	), "blindness_stew");
	public static final Item EMPTY_STANLEY = registerItem(new EmptyStanleyCupItem(new Item.Settings().maxCount(1)), "empty_stanley");
	public static final Item FILLED_STANLEY = registerItem(new FilledStanleyCupItem(new Item.Settings().maxCount(1)), "filled_stanley");


	public static Item registerItem(Item item, String name){
		return Registry.register(Registries.ITEM, new Identifier(MODID, name), item);
	}

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
	}
}
