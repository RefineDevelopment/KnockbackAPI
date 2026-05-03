package xyz.refinedev.api.knockback.knockbackmanager;

import me.dw1e.kbm.KnockbackManager;
import me.dw1e.kbm.api.KnockbackManagerAPI;

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
 * @version KnockbackAPI
 * @since 9/26/2025
 */
public class KnockbackManagerHook implements KnockbackHook {

    @Override
    public String getName() {
        return "KnockbackManager";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        KnockbackManagerAPI kbmAPI = KnockbackManager.getInstance().getAPI();
        kbmAPI.setKBFile(player, knockbackProfile);
    }

    private static boolean applicable;
    static {
        try {
            Class.forName("me.dw1e.kbm.KnockbackManager");
            applicable = true;
        } catch (ClassNotFoundException e) {
            applicable = false;
        }
    }
}