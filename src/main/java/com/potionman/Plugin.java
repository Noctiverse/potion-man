package com.potionman;

import java.io.*;
import javax.sound.sampled.*;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Potion Man"
)
public class Plugin extends net.runelite.client.plugins.Plugin
{
	@Inject
	private Client client;

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		if (npc.getId() == NpcID.DR_JEKYLL || npc.getId() == NpcID.DR_JEKYLL_314)
		{
			try
			{
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("src/main/resources/potion man.wav")));
				clip.start();
			}
			catch (Exception exc)
			{
				exc.printStackTrace(System.out);
			}
		}
	}
}
