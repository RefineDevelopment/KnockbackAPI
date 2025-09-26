package xyz.refinedev.api.knockback.azurite;

import dev.azurite.spigot.api.SpigotAPI;
import dev.azurite.spigot.api.knockback.IKnockback;
import dev.azurite.spigot.api.knockback.IKnockbackManager;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import xyz.refinedev.api.knockback.KnockbackHook;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @since 9/26/2025
 * @version KnockbackAPI
 */ 
public class AzuriteHook implements KnockbackHook {

    @Override
    public String getName() {
        return "AzuriteSpigot";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        IKnockbackManager manager = SpigotAPI.getInstance().getKnockbackManager();
        IKnockback knockback = manager.getByName(knockbackProfile);
        if (knockback == null) {
            knockback = manager.getActiveProfile();
        }
        player.setKnockbackProfile(knockback);
    }

    static boolean applicable;
    static {
        try {
            Class.forName("dev.azurite.spigot.api.knockback.IKnockbackManager");
            applicable = true;
        } catch (Throwable e) {
            applicable = false;
        }
    }
}
