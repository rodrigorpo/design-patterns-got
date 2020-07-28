package xyz.rpolnx.design_patterns_gof.creational_patterns.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeBuilder {
    public String className;
    public List<String> fields = new ArrayList<>();

    private final int indentationLevel = 2;
    private final String lineSeparator = System.lineSeparator();
    private final String endClass = "}";

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type, String accessLevel) {
        String fieldPattern = "%s %s %s;";
        fields.add(String.format(fieldPattern, accessLevel, type, name));
        return this;
    }

    public String toStringImpl() {
        String initialClassPattern = "public class %s {";
        StringBuilder content = new StringBuilder();

        content
                .append(String.format(initialClassPattern, className))
                .append(lineSeparator);

        for (String field : fields) {
            content
                    .append(String.join("", Collections.nCopies(indentationLevel, " ")))
                    .append(field)
                    .append(lineSeparator);
        }
        content.append(endClass);

        return content.toString();
    }

    @Override
    public String toString() {
        return toStringImpl();
    }
}

class CodeBuilderExercise {
    public String className;
    public List<String> fields = new ArrayList<>();

    private final int indentationLevel = 2;
    private final String lineSeparator = System.lineSeparator();
    private final String endClass = "}";

    public CodeBuilderExercise(String className) {
        this.className = className;
    }

    public CodeBuilderExercise addField(String name, String type) {
        String fieldPattern = "public %s %s;";
        fields.add(String.format(fieldPattern, type, name));
        return this;
    }

    public String toStringImpl() {
        String initialClassPattern = "public class %s\n{";
        StringBuilder content = new StringBuilder();

        content
                .append(String.format(initialClassPattern, className))
                .append(lineSeparator);

        for (String field : fields) {
            content
                    .append(String.join("", Collections.nCopies(indentationLevel, " ")))
                    .append(field)
                    .append(lineSeparator);
        }
        content.append(endClass);

        return content.toString();
    }

    @Override
    public String toString() {
        return toStringImpl();
    }
}

class CodeBuilderRun {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person")
                .addField("name", "String", "public")
                .addField("age", "int", "public");

        CodeBuilderExercise exercise = new CodeBuilderExercise("Person")
                .addField("name", "String")
                .addField("age", "int");

        System.out.println(codeBuilder);
        System.out.println(exercise);
    }
}