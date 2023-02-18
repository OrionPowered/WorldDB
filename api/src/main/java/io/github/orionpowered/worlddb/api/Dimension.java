package io.github.orionpowered.worlddb.api;

import java.util.Map;
import java.util.Optional;

public interface Dimension {
    byte[] dat(String name);

    default byte[] raids() {
        return dat("raids");
    }

    /**
     * Gets a region from this dimension.
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
