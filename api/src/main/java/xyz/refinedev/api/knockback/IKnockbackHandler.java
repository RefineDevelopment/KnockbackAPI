package xyz.refinedev.api.knockback;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

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
public interface IKnockbackHandler {

    /**
     * Initializes the KnockbackAPI by detecting the appropriate hook
     * and setting it as the active hook.
     */
    void init();

    /**
     * Registers a knockback hook to the handler
     *
     * @param hook the hook to register
     */
    void registerHook(KnockbackHook hook);

    /**
     * Unregisters a knockback hook from the handler
     *
     * @param hook the hook to unregister
     */
    void unregisterHook(KnockbackHook hook);

    /**
     * Gets an immutable set of all registered knockback hooks.
     *
     * @return an immutable set of registered knockback hooks
     */
    Set<KnockbackHook> getHooks();

    /**
     * Gets the active knockback hook.
     *
     * @return the active knockback hook or {@link KnockbackHook#DEFAULT} if none found.
     * @throws IllegalStateException if the KnockbackAPI has not been initialized yet
     */
    @NotNull KnockbackHook getHook();

    /**
     * Sets the active knockback hook.
     *
     * @param hook the hook to set as active
     */
    void setHook(@NotNull KnockbackHook hook);
}
