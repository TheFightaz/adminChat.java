package fightaz.adminchat.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fightaz.adminchat.Main;

public class AdminChat implements CommandExecutor {
	
	Main plugin;
	
	public AdminChat(Main m) {
		plugin = m;
		m.getCommand("ac").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		
		if(p.hasPermission("fightaz.adminchat")) {
			if(args.length > 0) {
				StringBuilder sb = new StringBuilder();
				
				for(int i = 0; i < args.length; ++i) {
					sb.append(args[i]).append(" ");		
					
				}
				
				String msg = sb.toString().replace("§", "§"); 
				
				for(Player players : Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("fightaz.adminchat")) {
						players.sendMessage("8§§l[§2§lA§6§lC§8§l] §6" + p.getDisplayName() + " §7§l» §5" + msg);
					}
				}
					
		} else {
			p.sendMessage("§7Poprawne użycie komendy §8[§a/ac §7[§eTekst§7]§8]");
		}
	} else {
		p.sendMessage("§7Nie masz uprawnien do korzystania z §aChatu administracji! §8[§cfightaz.adminchat§8]");
		
}
		return false;
	}
}
