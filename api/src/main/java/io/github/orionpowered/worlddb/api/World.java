package io.github.orionpowered.worlddb.api;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

public interface World {
    File path();

    byte[] levelDat();

    byte[] levelDatOld();

    byte[] lock();

    Optional<Dimension> dimension(String name);

    default Dimension dimension(Dimension.Type type) {
        return dimension(type.name()).orElseThrow();
    }

    default Dimension overworld() {
        return dimension(Dimension.Type.OVERWORLD);
    }

    default Dimension nether() {
        return dimension(Dimension.Type.NETHER);
    }

    default Dimension end() {
        return dimension(Dimension.Type.END);
    }

    Optional<PlayerData> player(UUID uuid);

    Optional<byte[]> icon();

    Optional<byte[]> advancement(UUID uuid);
}
