package com.endlesnights.softsnowfallmod.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.endlesnights.softsnowfallmod.SoftSnowFallMod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config
{
	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SERVER;
	
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CLIENT;
	
	static
	{
		SnowFallConfig.init(SERVER_BUILDER, CLIENT_BUILDER);
		
		SERVER = SERVER_BUILDER.build();
		CLIENT = CLIENT_BUILDER.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		SoftSnowFallMod.LOGGER.info("Loading config : " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		SoftSnowFallMod.LOGGER.info("Built config: " + path);
		file.load();
		SoftSnowFallMod.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
}