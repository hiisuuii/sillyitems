package hisui.sillyitems;

import hisui.item.AzidoazideAzideItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SillyItems implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors

	public static final String MODID = "sillyitems";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final Item AZIDOAZIDEAZIDE = new AzidoazideAzideItem(new FabricItemSettings());

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM, new Identifier(MODID,"sillyitems"), AZIDOAZIDEAZIDE);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}