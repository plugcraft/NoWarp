package me.flungo.bukkit.NoWarp;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.ClaimedResidence;
import com.bekvon.bukkit.residence.protection.ResidencePermissions;

public class PlayerListeners implements Listener {
	public static NoWarp plugin;
	
	public PlayerListeners(NoWarp instance) {
		plugin = instance;
	}

	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		Player p = event.getPlayer();
		boolean defaultValue = true;
		Location from = event.getFrom();
		ClaimedResidence resfrom = Residence.getResidenceManager().getByLoc(from);
		if(resfrom!=null) {
			ResidencePermissions perms = resfrom.getPermissions();
			boolean hasPermission = perms.playerHas(p.getName(), "warp", defaultValue);
			if(!hasPermission) {
			     event.setCancelled(true);
			     return;
			}
		}
		Location to = event.getTo();
		ClaimedResidence resto = Residence.getResidenceManager().getByLoc(to);
		if(resto!=null) {
			ResidencePermissions perms = resto.getPermissions();
			boolean hasPermission = perms.playerHas(p.getName(), "warp", defaultValue);
			if(!hasPermission) {
			     event.setCancelled(true);
			     return;
			}
		}
	}
}
