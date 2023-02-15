package io.github.orionpowered.worlddb.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.UUID;

public interface PlayerData {
    Optional<Container> get(UUID uuid);

    boolean save(Container container);

    @Data
    @AllArgsConstructor
    class Container implements AutoCloseable {
        private final PlayerData parent;
        private final UUID uuid;
        private byte[] dat, datOld, advancements, stats;

        @Override
        public void close() {
            parent.save(this);
        }
    }
}
