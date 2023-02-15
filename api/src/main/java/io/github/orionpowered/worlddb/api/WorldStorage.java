package io.github.orionpowered.worlddb.api;

import java.util.Optional;

/**
 * Represents a {@link WorldData} storage implementation. This is used to store the data in a specific way, whether
 * it be in a database, a file, or something else.
 */
public interface WorldStorage {
    Optional<WorldData> get(String name);

    boolean save(WorldData data);
}
