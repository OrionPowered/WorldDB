package io.github.orionpowered.worlddb.api;

public interface PlayerData {
    /**
     * Gets the data of this player in byte array form
     * @return The player data.
     */
    byte[] data();

    /**
     * Gets the advancements of this player in byte array form.
     * @return The advancements.
     */
    byte[] advancements();

    /**
     * Gets the stats of this player in byte array form.
     * @return The stats.
     */
    byte[] stats();
}
