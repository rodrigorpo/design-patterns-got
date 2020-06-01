package xyz.rpolnx.design_patterns_gof.solid.SRP.bad;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
@NoArgsConstructor
public class FullJournal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public static FullJournal of(String... text) {
        return new FullJournal(text);
    }

    private FullJournal(String... text) {
        addEntry(text);
    }

    public void addEntry(String... text) {
        for (String s : text) {
            entries.add("" + (++count) + ": " + s);
        }
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }


    public UUID save() {
        // communicate to DB and save
        return UUID.randomUUID();
    }

    public FullJournal get(UUID id) {
        // communicate to DB and get
        return this;
    }
}
