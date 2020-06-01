package xyz.rpolnx.design_patterns_gof.solid.SRP.good;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@AllArgsConstructor
public class JournalRepository {
    private final DBLayer dbLayer;

    public UUID save() {
        return dbLayer.save();
    }

    public Journal get(UUID id) {
        return dbLayer.get(id);
    }
}
