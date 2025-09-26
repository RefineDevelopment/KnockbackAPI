package xyz.refinedev.api.knockback;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

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
public interface KnockbackHook {

    KnockbackHook DEFAULT = new Default();

    static boolean isDefault(KnockbackHook hook) {
        return hook == DEFAULT;
    }

    /**
     * Gets the name of the knockback hook. This is just a friendly name
     * to identify the hook.
     */
    String getName();

    /**
     * Is the given hook applicable to the current server?
     *
     * @return true if the hook is applicable, false otherwise
     */
    boolean isApplicable();

    /**
     * Sets the knockback profile of a player.
     *
     * @param player           The player to set the knockback profile of
     * @param knockbackProfile The knockback profile to set
     */
    void setKnockback(@NotNull Player player, @NotNull String knockbackProfile);

    class Default implements KnockbackHook {

        @Override
        public String getName() {
            return "Paper";
        }

        @Override
        public boolean isApplicable() {
            return true;
        }

        @Override
        public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
            // No implementation
        }
    }

}
