package io.github.orionpowered.worlddb.api;

import java.util.Map;
import java.util.Optional;

public interface Dimension {
    byte[] dat(String name);

    default byte[] raids() {
        return dat("raids");
    }

    Optional<byte[]> poi(int x, int z);

    Optional<byte[]> entities(int x, int z);

    Optional<byte[]> chunk(int x, int z);

    enum Type {
        OVERWORLD,
        NETHER,
        END
    }
}
