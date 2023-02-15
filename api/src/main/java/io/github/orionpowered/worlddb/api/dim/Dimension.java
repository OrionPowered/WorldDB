package io.github.orionpowered.worlddb.api.dim;

public interface Dimension extends AutoCloseable {
    byte[] raids();

    boolean save();

    @Override
    default void close() throws Exception {
        this.save();
    }
}
