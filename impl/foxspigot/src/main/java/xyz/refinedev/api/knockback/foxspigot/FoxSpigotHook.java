package xyz.refinedev.api.knockback.foxspigot;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

import pt.foxspigot.jar.knockback.KnockbackModule;
import pt.foxspigot.jar.knockback.KnockbackProfile;
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
public class FoxSpigotHook implements KnockbackHook {

    @Override
    public String getName() {
        return "FoxSpigot";
    }

    @Override
    public boolean isApplicable() {
        return applicable;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        KnockbackProfile profile = KnockbackModule.getByName(knockbackProfile);
        ((CraftPlayer) player).getHandle().setKnockback(profile);
    }

    static boolean applicable;
    static {
        try {
            Class.forName("pt.foxspigot.jar.knockback.KnockbackModule");
            applicable = true;
        } catch (Throwable e) {
            applicable = false;
        }
    }
}
