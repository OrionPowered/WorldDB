package io.github.orionpowered.worlddb.api;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface StorageProvider {
    /**
     * Loads a world from the storage provider.
     * @param name The name of the world.
     * @return The world, if it exists.
     */
    Optional<World> world(String name);

    /**
     * Loads a world from the storage provider.
     * @param uuid The UUID of the world.
     * @return The world, if it exists.
     */
    Optional<World> world(UUID uuid);

    /**
     * Deletes a world from the storage provider.
     * @param world The world to delete .
     * @return A future that completes when the world has been deleted.
     */
    CompletableFuture<Boolean> delete(World world);

    /**
     * Imports a world to this storage provider.
     * @param world The world to import.
     * @return A future that completes when the world has been imported.
     * @throws IOException Thrown if the world could not be imported.
     */
    default CompletableFuture<Boolean> importWorld(World world) throws IOException {
        if (world(world.id()).isPresent()) throw new IOException("World already exists, cannot import");
        return save(world);
    }

    /**
     * Saves a world to this storage provider.
     * @param world The world to save.
     * @return A future that completes when the world has been saved.
     */
    default CompletableFuture<Boolean> save(World world) {
        return world.save(this);
    }
}
