package io.github.orionpowered.worlddb.api;

public interface Region {
/**
     * Gets the chunk data in byte array form.
     * @return The chunk data.
     */
    byte[] chunks();

    /**
     * Gets the POI in byte array form.
     * @return POI.
     */
    byte[] poi();

    /**
     * Gets the entities in byte array form.
     * @return The entities.
     */
    byte[] entities();

}
