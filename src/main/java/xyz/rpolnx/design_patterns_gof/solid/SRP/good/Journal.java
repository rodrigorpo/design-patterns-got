package xyz.rpolnx.design_patterns_gof.solid.SRP.good;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
@NoArgsConstructor
public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public static Journal of(String... text) {
        return new Journal(text);
    }

    private Journal(String... text) {
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
}
