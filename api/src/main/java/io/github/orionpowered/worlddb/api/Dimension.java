package io.github.orionpowered.worlddb.api;

import java.util.Optional;

public interface Dimension {
    /**
     * Gets dat in byte array form from the provided name.
     *
     * @param name The name of the dat.
     * @return The dat, if it exists.
     */
    Optional<byte[]> dat(String name);

    /**
     * Gets the raids data in byte array form.
     *
     * @return The raids data.
     */
    default byte[] raids() {
        return dat("raids").orElseThrow();
    }

    /**
     * Gets a region from this dimension.
     *
     * @param x The x coordinate of the chunk.
     * @param z The z coordinate of the chunk.
     * @return The region, if it exists.
     */
    Optional<Region> region(int x, int z);

    enum Type {
        OVERWORLD,
        NETHER,
        END
    }
}
