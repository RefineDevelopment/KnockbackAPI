# Knockback API
A simple API to allow plugins to apply different knockback profiles to players.

## Supported Spigots
Please note that these spigots are supported through public APIs.

- ImanitySpigot
- AzuriteSpigot
- FoxSpigot

## Installation

### Gradle
```kotlin
repositories {
    maven {
        name = "refine-public"
        url = uri("https://maven.refinedev.xyz/public-repo/")
    }
}

dependencies {
    implementation("xyz.refinedev.api:KnockbackAPI:1.0.0")
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>refine-public</id>
        <url>https://maven.refinedev.xyz/public-repo/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>xyz.refinedev.api</groupId>
        <artifactId>KnockbackAPI</artifactId>
        <version>1.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## Usage

### Basic Setup
```java
import xyz.refinedev.api.knockback.knockbackHandler;

public class ExamplePlugin extends JavaPlugin implements Listener {

    private KnockbackHandler knockbackHandler;

    @Override
    public void onEnable() {
        this.knockbackHandler = new KnockbackHandler();
        //this.nameTagHandler.registerHook(new CustomHook()); Register your own hook before init call.
        this.knockbackHandler.init();

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        KnockbackHook hook = knockbackHandler.getHook();
        hook.setKnockback(player, "test");
    }
}

```

### Registering Custom Hooks
You can implement hooks for your own spigot forks by implementing the 'KnockbackHook' interface and registering it before the init call.

```java
import xyz.refinedev.api.knockback.KnockbackHook;

public class CustomHook implements KnockbackHook {
    // Implement required methods
}

knockbackHandler.registerHook(new CustomHook());
// or force it as the active hook after the init call
knockbackHandler.setHook(new CustomHook());
```

## Contributing
Pull requests and suggestions are welcome! Please open an issue or PR for any improvements.

## License
This project is open source and may be used in commercial or non-commercial projects, provided that credit is given to the authors of this repository.
Selling the code itself is not permitted.