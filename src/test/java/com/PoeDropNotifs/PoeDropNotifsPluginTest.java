package com.PoeDropNotifs;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PoeDropNotifsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(POEDropNotifPlugin.class);
		RuneLite.main(args);
	}
}