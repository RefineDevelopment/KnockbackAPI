package xyz.refinedev.api.knockback;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import org.jetbrains.annotations.NotNull;

import xyz.refinedev.api.knockback.azurite.AzuriteHook;
import xyz.refinedev.api.knockback.carbon.CarbonHook;
import xyz.refinedev.api.knockback.carbon.CarbonLegacyHook;
import xyz.refinedev.api.knockback.foxspigot.FoxSpigotHook;
import xyz.refinedev.api.knockback.imanity.ImanityHook;

import java.util.HashSet;
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
public class KnockbackHandler implements IKnockbackHandler {

    private final Set<KnockbackHook> hooks = new HashSet<>();
    private boolean initialized = false;
    private KnockbackHook hook;

    @Override
    public void init() {
        this.registerHook(new CarbonHook()); // Carbon 5.0
        this.registerHook(new CarbonLegacyHook()); // Carbon 4.3
        this.registerHook(new ImanityHook());
        this.registerHook(new AzuriteHook());
        this.registerHook(new FoxSpigotHook());

        this.hook = this.detect();
        if (this.hook == null) {
            this.hook = KnockbackHook.DEFAULT;
        }

        this.initialized = true;
    }

    @Override
    public void registerHook(KnockbackHook hook) {
        this.hooks.add(hook);
    }

    @Override
    public void unregisterHook(KnockbackHook hook) {
        this.hooks.remove(hook);
    }

    @Override
    public Set<KnockbackHook> getHooks() {
        return ImmutableSet.copyOf(hooks);
    }

    @Override
    public @NotNull KnockbackHook getHook() {
        Preconditions.checkArgument(initialized, "KnockbackAPI has not been initialized yet!");
        return hook;
    }

    @Override
    public void setHook(@NotNull KnockbackHook hook) {
        this.hook = hook;
    }

    /**
     * Detects the appropriate knockback hook by iterating through the registered hooks
     *
     * @return the detected knockback hook, or null if none are applicable
     */
    private KnockbackHook detect() {
        for (KnockbackHook hook : hooks) {
            if (hook.isApplicable()) {
                return hook;
            }
        }
        return null;
    }
}
