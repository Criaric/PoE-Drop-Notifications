package com.PoeDropNotifs;

import net.runelite.api.ItemID;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("PoeDropNotifs")
public interface POEDropNotifConfig extends Config
{
	// @ConfigItem(
	// 	keyName = "greeting",
	// 	name = "PoE Filter Greeting",
	// 	description = "PoE Loot Notifications Enabled.",
	//	position = #
	// )
	// default String greeting()
	// {
	// 	return "There is text in this box";
	// }


	///Tier 0
	// enum OptionTier0
	// {
	// Sound0,
	// Sound1,
	// Sound2,
	// Sound3,
	// Sound4
	// }
	// @ConfigItem(
	// 		position = 2,
	// 		keyName = "SoundSelectT0",
	// 		name = "",
	// 		description = "Select the Sound for Tier 0"
	// )
	// default OptionTier0 OptionTier0Config() { return OptionTier0.Sound0; }

	@ConfigItem(
			keyName = "item_ids T0",
			name = "T0 Item IDs:",
			description = "Item ids for T0 to play a drop sound for, enter multiple separated with ;",
			position = 1
	)
	default String itemIdsT0()
	{
		return Integer.toString(ItemID.ULTOR_VESTIGE);
	}	

	///Tier 1
	// enum OptionTier1
	// {
	// Sound0,
	// Sound1,
	// Sound2,
	// Sound3,
	// Sound4
	// }
	// @ConfigItem(
	// 		position = 4,
	// 		keyName = "SoundSelectT1",
	// 		name = "",
	// 		description = "Select the Sound for Tier 1"
	// )
	// default OptionTier1 OptionTier1Config() { return OptionTier1.Sound1; }

	@ConfigItem(
			keyName = "item_ids T1",
			name = "T1 Item IDs:",
			description = "Item ids for T1 to play a drop sound for, enter multiple separated with ;",
			position = 3
	)
	default String itemIdsT1()
	{
		return Integer.toString(ItemID.BLOOD_SHARD);
	}	


	///Tier 2
	// enum OptionTier2
	// {
	// Sound0,
	// Sound1,
	// Sound2,
	// Sound3,
	// Sound4
	// }
	// @ConfigItem(
	// 		position = 6,
	// 		keyName = "SoundSelectT2",
	// 		name = "",
	// 		description = "Select the Sound for Tier 2"
	// )
	// default OptionTier2 OptionTier2Config() { return OptionTier2.Sound2; }
	
	@ConfigItem(
		keyName = "item_ids T2",
		name = "T2 Item IDs:",
		description = "Item ids for T2 to play a drop sound for, enter multiple separated with ;",
		position = 5
)
default String itemIdsT2()
{
	return Integer.toString(ItemID.AWAKENERS_ORB);
}	

	///Tier 3
	// enum OptionTier0
	// {
	// Sound0,
	// Sound1,
	// Sound2,
	// Sound3,
	// Sound4
	// }
	// @ConfigItem(
	// 		position = 8,
	// 		keyName = "SoundSelectT0",
	// 		name = "",
	// 		description = "Select the Sound for Tier 0"
	// )
	// default OptionTier0 OptionTier0Config() { return OptionTier0.Sound0; }

	@ConfigItem(
			keyName = "item_ids T3",
			name = "T3 Item IDs:",
			description = "Item ids for T3 to play a drop sound for, enter multiple separated with ;",
			position = 7
	)
	default String itemIdsT3()
	{
		return Integer.toString(ItemID.RUNE_PLATEBODY);
	}	


}
