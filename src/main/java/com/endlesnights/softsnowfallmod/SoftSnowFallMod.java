package com.endlesnights.softsnowfallmod;

import com.endlesnights.softsnowfallmod.config.Config;
import com.endlesnights.softsnowfallmod.events.FallEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(SoftSnowFallMod.MODID)
@EventBusSubscriber(bus=Bus.MOD)
public class SoftSnowFallMod
{
	
	public static final String MODID = "softsnowfallmod";
	public static final String NAME = "Soft Snow Landing Mod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static SoftSnowFallMod instance;
	
	public SoftSnowFallMod()
	{
        instance = this;
        
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "softsnowfallmod-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "softsnowfallmod-client.toml");
        		
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("softsnowfallmod-server.toml").toString());
		Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("softsnowfallmod-client.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::loadComplete);
	}
	
	private void loadComplete(FMLLoadCompleteEvent event)
	{
		MinecraftForge.EVENT_BUS.register((Object)new FallEvent());
	}
}
