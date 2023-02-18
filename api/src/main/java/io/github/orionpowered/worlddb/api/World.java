package io.github.orionpowered.worlddb.api;

import java.io.File;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface World {
    /**
     * Gets the UUID of this world.
     * @return The UUID of the world.
     */
    UUID id();

    /**
     * Gets the level data in byte array form.
     * @return The level data.
     */
    byte[] levelDat();

    /**
     * Gets the old level data in byte array form.
     * @return The old level data.
     */
    byte[] levelDatOld();

    /**
     * Gets the lock file for this world.
     * @return The lock file.
     */
    byte[] lock();

    /**
     * Gets a dimension from this world.
     * @param name The name of the dimension.
     * @return The dimension, if it exists.
     */
    Optional<Dimension> dimension(String name);

    /**
     * Gets a dimension from this world.0
     * @param type The type of the dimension.
     * @return The dimension, if it exists.
     */
    default Dimension dimension(Dimension.Type type) {
        return dimension(type.name()).orElseThrow();
    }

    /**
     * Gets the overworld dimension.
     * @return The overworld dimension.
     */
    default Dimension overworld() {
        return dimension(Dimension.Type.OVERWORLD);
    }

    /**
     * Gets the nether dimension.
     * @return The nether dimension.
     */
    default Dimension nether() {
        return dimension(Dimension.Type.NETHER);
    }

    /**
     * Gets the end dimension.
     * @return The end dimension.
     */
    default Dimension end() {
        return dimension(Dimension.Type.END);
    }

    /**
     * Gets the player data for the provided UUID.
     * @param uuid The UUID of the player.
     * @return The player data, if it exists.
     */
    Optional<PlayerData> player(UUID uuid);

    /**
     * Gets the icon of this world.
     * @return The icon of this world.
     */
    Optional<byte[]> icon();

    /**
     * Saves this world to the provided storage provider.
     * @param storage The storage provider to save to.
     * @return A future that completes when the world has been saved.
     */
    CompletableFuture<Boolean> save(StorageProvider storage);
}
