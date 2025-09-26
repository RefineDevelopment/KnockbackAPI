package xyz.refinedev.api.knockback.imanity;

import dev.imanity.knockback.api.Knockback;
import dev.imanity.knockback.api.KnockbackService;

import org.bukkit.Bukkit;
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
public class ImanityHook implements KnockbackHook {

    @Override
    public String getName() {
        return "Imanity";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        KnockbackService service = Bukkit.imanity().getKnockbackService();
        Knockback profile = service.getKnockbackByName(knockbackProfile);
        if (profile == null) {
            profile = service.getGlobalKnockback();
        }
        service.setKnockback(player, profile);
    }

    static boolean applicable;
    static {
        try {
            Class.forName("org.imanity.imanityspigot.ImanitySpigot");
            applicable = true;
        } catch (Throwable e) {
            applicable = false;
        }
    }
}
