package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Guesstimator guesstimator = new Guesstimator();
        float guesstimate = guesstimator.guesstimate(12,
                TextComplexity.MEDIUM, BugReportingComplexity.MEDIUM,
                2, 2, 12);
//        float guesstimateFromText = guesstimator.guesstimateFromText();
        float guesstimateFromPath = guesstimator.guesstimateFromPath();

        System.out.println("Guesstimate: " + guesstimate + ", from test: " + "guesstimateFromText"
                + "and from a text file: " + guesstimateFromPath);

    }
}