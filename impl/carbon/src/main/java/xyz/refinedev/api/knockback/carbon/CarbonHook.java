package xyz.refinedev.api.knockback.carbon;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import xyz.refinedev.api.knockback.KnockbackHook;

import xyz.refinedev.spigot.features.combat.CombatAPI;
import xyz.refinedev.spigot.features.combat.ICombatProfile;

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
public class CarbonHook implements KnockbackHook {

    @Override
    public String getName() {
        return "Carbon";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        CombatAPI combatAPI = CombatAPI.instance();
        ICombatProfile profile = combatAPI.getProfile(knockbackProfile);
        if (profile == null) {
            profile = combatAPI.getDefaultProfile(player.getWorld());
        }
        combatAPI.setPlayerProfile(player, profile);
    }

    private static boolean applicable;
    static {
        try {
            Class.forName("xyz.refinedev.spigot.features.combat.CombatAPI");
            applicable = true;
        } catch (ClassNotFoundException e) {
            applicable = false;
        }
    }
}
