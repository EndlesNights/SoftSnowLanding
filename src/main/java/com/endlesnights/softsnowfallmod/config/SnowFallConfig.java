package com.endlesnights.softsnowfallmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SnowFallConfig
{
	public static ForgeConfigSpec.DoubleValue snowFall_ratio;
	public static ForgeConfigSpec.IntValue snowFall_maxLayers;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("SnowFall Config");
		
		snowFall_ratio = server
				.comment("Multiplyer that determines the ratio between the number of layers of snow times how many blocks of fall distance they cancel out.")
				.defineInRange("softsnowfallconfig.snowFall_ratio", 1.0, 0.0, 100.0);
		
		snowFall_maxLayers = server
				.comment("The maximume number of snow layers that will be conisdered to negate fall damage")
				.defineInRange("softsnowfallconfig.snowFall_layers", 32, 0, 2048);
	}
}