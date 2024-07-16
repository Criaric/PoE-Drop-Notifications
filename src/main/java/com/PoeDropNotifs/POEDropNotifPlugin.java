package com.PoeDropNotifs;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@PluginDescriptor(
	name = "POE Drop Notifications"
)
public class POEDropNotifPlugin extends Plugin
{

	public static final File SOUND_FOLDER = new File(RuneLite.RUNELITE_DIR.getPath() + File.separator + "item-drop-sounds");
	public static final File SOUND_FILE0 =  new File(SOUND_FOLDER, "Sound0.wav");
	public static final File SOUND_FILE1 =  new File(SOUND_FOLDER, "Sound1.wav");
	public static final File SOUND_FILE2 =  new File(SOUND_FOLDER, "Sound2.wav");
	public static final File SOUND_FILE3 =  new File(SOUND_FOLDER, "Sound3.wav");

	@Inject
	private Client client;

	@Inject
	private POEDropNotifConfig config;

	@Override
	protected void startUp() throws Exception
	{
		initializeSoundFiles();

		log.info("PoE Drop Notifications started!");
	}

	// Initialize Sound Files

	private void initializeSoundFiles() {
		if (!SOUND_FOLDER.exists()) {
			if (!SOUND_FOLDER.mkdirs()) {
				log.warn("Failed to create folder for item drop sounds");
			}
		}
		
		try{
			if (SOUND_FILE0.exists()) {
				return;
			}
			
			InputStream stream = POEDropNotifPlugin.class.getClassLoader().getResourceAsStream("item_drop0.wav");
			OutputStream out = Files.newOutputStream(SOUND_FILE0.toPath());
			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = Objects.requireNonNull(stream).read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			stream.close();
		}	
		
		catch (Exception e){
			log.error(e.getLocalizedMessage());
		}

		try{
			if (SOUND_FILE1.exists()) {
				return;
			}
			
			InputStream stream = POEDropNotifPlugin.class.getClassLoader().getResourceAsStream("item_drop1.wav");
			OutputStream out = Files.newOutputStream(SOUND_FILE1.toPath());
			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = Objects.requireNonNull(stream).read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			stream.close();
		}	
		
		catch (Exception e){
			log.error(e.getLocalizedMessage());
		}

		try{
			if (SOUND_FILE2.exists()) {
				return;
			}
			
			InputStream stream = POEDropNotifPlugin.class.getClassLoader().getResourceAsStream("item_drop2.wav");
			OutputStream out = Files.newOutputStream(SOUND_FILE2.toPath());
			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = Objects.requireNonNull(stream).read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			stream.close();
		}	
		
		catch (Exception e){
			log.error(e.getLocalizedMessage());
		}

		try{
			if (SOUND_FILE3.exists()) {
				return;
			}
			
			InputStream stream = POEDropNotifPlugin.class.getClassLoader().getResourceAsStream("item_drop3.wav");
			OutputStream out = Files.newOutputStream(SOUND_FILE3.toPath());
			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = Objects.requireNonNull(stream).read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			stream.close();
		}	
		
		catch (Exception e){
			log.error(e.getLocalizedMessage());
		}


	}
	
	private List<Integer> getItemIdsT0(){
		try{
			return Arrays.stream(config.itemIdsT0().split(";")).map(Integer::parseInt).collect(Collectors.toList());
		} catch (NumberFormatException ex){
			log.error("Invalid item id configuration in T0");
			return new ArrayList<>();
		}
	}

	private List<Integer> getItemIdsT1(){
		try{
			return Arrays.stream(config.itemIdsT1().split(";")).map(Integer::parseInt).collect(Collectors.toList());
		} catch (NumberFormatException ex){
			log.error("Invalid item id configuration in T1");
			return new ArrayList<>();
		}
	}

	private List<Integer> getItemIdsT2(){
		try{
			return Arrays.stream(config.itemIdsT2().split(";")).map(Integer::parseInt).collect(Collectors.toList());
		} catch (NumberFormatException ex){
			log.error("Invalid item id configuration in T2");
			return new ArrayList<>();
		}
	}

	private List<Integer> getItemIdsT3(){
		try{
			return Arrays.stream(config.itemIdsT3().split(";")).map(Integer::parseInt).collect(Collectors.toList());
		} catch (NumberFormatException ex){
			log.error("Invalid item id configuration in T2");
			return new ArrayList<>();
		}
	}


	// private String getSoundValT0(){
	//  		return config.OptionTier0Config().toString();
	//  }

	// private String getSoundValT1(){
	// 		return config.OptionTier1Config().toString();
	// }

	// private String getSoundValT2(){
	// 		return config.OptionTier2Config().toString();
	// }


	@Override
	protected void shutDown() throws Exception
	{
		log.info("PoE Drop Notifications stopped!");
	}


	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned)
	{
		List<Integer> itemIds0 = getItemIdsT0();
		List<Integer> itemIds1 = getItemIdsT1();
		List<Integer> itemIds2 = getItemIdsT2();
		List<Integer> itemIds3 = getItemIdsT3();
		// String SoundID0 = getSoundValT0();
		// String SoundID1 = getSoundValT1();
		// String SoundID2 = getSoundValT2();
		Clip clip = null;
		

		// if(SoundID0 == "Sound0"){
		// 	File Tier0Sound = SOUND_FILE0;
		// }else if(SoundID0 == "Sound1"){
		// 	File Tier0Sound = SOUND_FILE1;
		// }else if(SoundID0 == "Sound2"){
		// 	final File Tier0Sound = SOUND_FILE2;
		// }



		TileItem item = itemSpawned.getItem();
		if(itemIds0.contains(item.getId())) {
			try (InputStream fileStream = new BufferedInputStream(Files.newInputStream(SOUND_FILE0.toPath()));
				 AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load item drop alert sound", e);
			}
			
			if (clip != null) {
				
				clip.setFramePosition(clip.getFrameLength());
				clip.loop(1);
				clip.close();
			}
		}else if(itemIds1.contains(item.getId())) {
			try (InputStream fileStream = new BufferedInputStream(Files.newInputStream(SOUND_FILE1.toPath()));
				 AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load item drop alert sound", e);
			}
			
			if (clip != null) {
				
				clip.setFramePosition(clip.getFrameLength());
				clip.loop(1);
				clip.close();
			}
		}else if(itemIds2.contains(item.getId())) {
			try (InputStream fileStream = new BufferedInputStream(Files.newInputStream(SOUND_FILE2.toPath()));
				 AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load item drop alert sound", e);
			}
			
			if (clip != null) {
				
				clip.setFramePosition(clip.getFrameLength());
				clip.loop(1);
				clip.close();
			}
		}else if(itemIds3.contains(item.getId())) {
			try (InputStream fileStream = new BufferedInputStream(Files.newInputStream(SOUND_FILE3.toPath()));
				 AudioInputStream sound = AudioSystem.getAudioInputStream(fileStream))
			{
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
			{
				log.warn("Unable to load item drop alert sound", e);
			}
			
			if (clip != null) {
				
				clip.setFramePosition(clip.getFrameLength());
				clip.loop(1);
				clip.close();
			}
		}

	}
	
	
	// @Subscribe
	// public void onGameStateChanged(GameStateChanged gameStateChanged)
	// {
	// 	if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
	// 	{
	// 		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
	// 	}
	// }

	@Provides
	POEDropNotifConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(POEDropNotifConfig.class);
	}
}
