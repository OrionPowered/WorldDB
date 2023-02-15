package io.github.orionpowered.worlddb.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;

public interface RegionData {

    Optional<Container> get(int x, int z);

    boolean save(Container container);

    @Data
    @AllArgsConstructor
    class Container implements AutoCloseable {
        private final RegionData parent;
        private final int x, z;
        private byte[] data, entities, poi;

        @Override
        public void close() {
            parent.save(this);
        }
    }
}
