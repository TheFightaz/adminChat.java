
package fightaz.adminchat;

import org.bukkit.plugin.java.JavaPlugin;

import fightaz.adminchat.cmds.AdminChat;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public void onEnable( ) {
		
		main = this;
		
		new AdminChat(this);
	}

	
	public static Main getMain() {
		return main;
	}
}
