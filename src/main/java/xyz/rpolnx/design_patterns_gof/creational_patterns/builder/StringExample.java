package xyz.rpolnx.design_patterns_gof.creational_patterns.builder;

public class StringExample {
    public static void main(String[] args) {
        String[] words = {"hello", "world"};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>\n");

        for (String word : words) {
            stringBuilder.append(String.format("\t<li>%s</li>\n", word));
        }

        stringBuilder.append("</ul>");

        System.out.println(stringBuilder);
    }
}
