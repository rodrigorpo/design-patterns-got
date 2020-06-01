package xyz.rpolnx.design_patterns_gof.solid.SRP;


import xyz.rpolnx.design_patterns_gof.solid.SRP.bad.FullJournal;
import xyz.rpolnx.design_patterns_gof.solid.SRP.good.DBLayer;
import xyz.rpolnx.design_patterns_gof.solid.SRP.good.Journal;
import xyz.rpolnx.design_patterns_gof.solid.SRP.good.JournalRepository;

import java.util.UUID;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        bad();
        good();
    }

    private static void bad() {
        FullJournal badFullJournal = FullJournal.of("This example is bad");
        badFullJournal.addEntry("Because different responsibilities are in the same class");
        badFullJournal.removeEntry(1);

        FullJournal get = badFullJournal.get(UUID.randomUUID());
        UUID savedId = badFullJournal.save();

        System.out.println("=== BAD ===");
        System.out.println(get);
        System.out.println(badFullJournal);
        System.out.println(savedId + "\n");
    }

    private static void good() {
        Journal entity = Journal.of("Although, this example is good");
        entity.addEntry("Because classes are separated by functionalities");
        entity.removeEntry(0);

        //Responsibilities are separated
        JournalRepository repository = new JournalRepository(mockLayer(entity));

        Journal journalFromDB = repository.get(UUID.randomUUID());
        UUID savedId = repository.save();

        System.out.println("=== GOOD ===");
        System.out.println(entity);
        System.out.println(journalFromDB);
        System.out.println(savedId);
    }

    private static DBLayer mockLayer(Journal entity) {
        return new DBLayer() {
            @Override
            public UUID save() {
                return UUID.randomUUID();
            }

            @Override
            public Journal get(UUID id) {
                return entity;
            }
        };
    }
}
