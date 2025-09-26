package xyz.refinedev.api.knockback.carbon;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import xyz.refinedev.api.knockback.KnockbackHook;

import xyz.refinedev.spigot.api.knockback.KnockbackAPI;
import xyz.refinedev.spigot.knockback.KnockbackProfile;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version KnockbackAPI
 * @since 9/26/2025
 */
public class CarbonLegacyHook implements KnockbackHook {

    @Override
    public String getName() {
        return "Carbon (Legacy)";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        KnockbackAPI knockbackAPI = KnockbackAPI.getInstance();
        KnockbackProfile profile = knockbackAPI.getProfile(knockbackProfile);
        if (profile == null) {
            profile = knockbackAPI.getDefaultProfile();
        }
        knockbackAPI.setPlayerProfile(player, profile);
    }

    private static boolean applicable;
    static {
        try {
            Class.forName("xyz.refinedev.spigot.api.knockback.KnockbackAPI");
            applicable = true;
        } catch (ClassNotFoundException e) {
            applicable = false;
        }
    }
}
