package xyz.rpolnx.design_patterns_gof.solid.SRP.good;

import java.util.UUID;

public interface DBLayer {
    UUID save();

    Journal get(UUID id);
}
