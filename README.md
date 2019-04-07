<p align="center">
  <a href="https://www.spigotcourse.org/?utm_source=github&utm_medium=github">
    <img src="https://i.imgur.com/Xr0p2g3.png" />
  </a>
</p>

# GameAPI
Open-source library for creating minigame plugins. This is a full plugin that shall be placed onto your server and hooked from your minigame plugin. It does nothing on its own, but allows other plugins to inter-communicate and it makes it easier for you to create event/minigame plugins.

## Goal
* Provide developers a simpler way of creating mini-game plugins based on arenas.
* Standardize way minigames are created and allow them to communicate cross-plugins.

## Current state
* The library is finished and documented. Plugins using this library are CoreArena, Puncher and AutoPlay (available on SpigotMC).
* It is considered stable and safe to use GameAPI as it has been in production since 2017.

## Maven Dependency

We use JitPack.io to always host the latest most updated version of GameAPI. Import this repository into your pom.xml

	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>

Import the dependency below into your pom.xml:

	<dependency>
	    <groupId>com.github.kangarko</groupId>
	    <artifactId>GameAPI</artifactId>
	    <version>master-SNAPSHOT</version>
	</dependency>


## How to Use
1. Download the GameAPI.jar to your server and install as any plugin normally.
2. Import this library into your plugin (Maven is recommended, see above).
3. Make your main plugin class implement 'ArenaPlugin' and your minigame arenas extend 'Arena'.
4. Register each of you arena in 'ArenaRegistry' on plugin load.
5. Done! Now you have access to your arenas from anywhere, and you can also listen to events in the event package.

© Copyright 2017 - 2019 kangarko | All Rights Reserved.