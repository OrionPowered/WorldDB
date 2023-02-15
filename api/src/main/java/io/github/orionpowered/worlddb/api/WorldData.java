package io.github.orionpowered.worlddb.api;

import io.github.orionpowered.worlddb.api.dim.EndData;
import io.github.orionpowered.worlddb.api.dim.NetherData;
import io.github.orionpowered.worlddb.api.dim.OverworldData;

/**
 * Represents the backing data behind a world. This world might be stored using any {@link WorldStorage} implementation.
 * <b>NOTE:</b> This class, nor any other class in the API, provide deserialization. This is merely a storage API, and
 * all data will be provided in byte form.
 */
public interface WorldData extends AutoCloseable {
    WorldStorage storage();

    byte[] levelDat();

    byte[] levelDatOld();

    boolean locked();

    OverworldData overworld();

    NetherData nether();

    EndData end();

    PlayerData players();

    default boolean save() {
        return this.overworld().save() &&
                this.nether().save() &&
                this.end().save() &&
                this.storage().save(this);
    }

    @Override
    default void close() {
        this.save();
    }
}
