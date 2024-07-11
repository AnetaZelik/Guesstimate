package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Guesstimator {
    int wordsAmount;
    Path filePath;
    String text;
    int platformsAmount = 1;
    int devicesAmount = 1;
    int languagesAmount = 1;
    private TextComplexity textComplexity;
    private BugReportingComplexity bugReportingComplexity;

    public float guesstimate(int wordsAmount, TextComplexity textComplexity,
                             BugReportingComplexity bugReportingComplexity,
                             int platformsAmount, int devicesAmount,
                             int languagesAmount) {
        this.textComplexity = textComplexity;
        this.bugReportingComplexity = bugReportingComplexity;
        return (float) wordsAmount * getTextComplexity() *
                getBugReportingComplexity() *
                platformsAmount * devicesAmount * languagesAmount;
    }

    public float guesstimateFromText() {
        getUserInput();
        //todo to correctly use words per hour
        return getWordsAmountFromText(this.text) * getTextComplexity() *
                getBugReportingComplexity() *
                this.platformsAmount * this.devicesAmount * this.languagesAmount;
    }

    public float guesstimateFromPath() throws IOException {
        getUserInput();
        //todo to correctly use words per hour
        return getWordsAmountFromTextFile(this.filePath) * getTextComplexity() *
                getBugReportingComplexity() *
                this.platformsAmount * this.devicesAmount * this.languagesAmount;
    }

    public float guesstimateFromTextFile(Path textFilePath, TextComplexity textComplexity,
                                     BugReportingComplexity bugReportingComplexity,
                                     int platformsAmount, int devicesAmount,
                                     int languagesAmount) throws IOException {
        this.textComplexity = textComplexity;
        this.bugReportingComplexity = bugReportingComplexity;
        int wordsAmount = getWordsAmountFromTextFile(textFilePath);
        return (float) wordsAmount * getTextComplexity() *
                getBugReportingComplexity() *
                platformsAmount * devicesAmount * languagesAmount;
    }

    public float guesstimateFromText(String text, TextComplexity textComplexity,
                                     BugReportingComplexity bugReportingComplexity,
                                     int platformsAmount, int devicesAmount,
                                     int languagesAmount) {
        this.textComplexity = textComplexity;
        this.bugReportingComplexity = bugReportingComplexity;
        this.wordsAmount = getWordsAmountFromText(text);
        return (float) wordsAmount * getTextComplexity() *
                getBugReportingComplexity() *
                platformsAmount * devicesAmount * languagesAmount;
    }

    private int getWordsAmountFromTextFile(Path textFilePath) throws IOException {
    return getWordsAmountFromText(Files.readString(textFilePath));
    }

    private int getWordsAmountFromText(String text) {
        return new StringTokenizer(text).countTokens();
    }

    private int getBugReportingComplexity() {
        switch (this.bugReportingComplexity) {
            case EXCEL:
                return 1;
            case MEDIUM:
                return 2;
            case COMPLICATED:
                return 3;
            default:
                return 1;
        }

    }

    private int getTextComplexity() {
        switch (this.textComplexity) {
            case EASY:
                return 1;
            case MEDIUM:
                return 2;
            case COMPLICATED:
                return 3;
            default:
                return 1;
        }
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide the words amount");
        wordsAmount = scanner.nextInt();

        System.out.println("Provide the text");
        text = scanner.nextLine();

        System.out.println("Provide the file path");
        filePath = Path.of(scanner.next());

        System.out.println("Provide the text complexity");
        textComplexity = TextComplexity.valueOf(scanner.next());

        System.out.println("Provide the bug reporting complexity");
        bugReportingComplexity = BugReportingComplexity.valueOf(scanner.next());

        System.out.println("Provide the platforms amount");
        platformsAmount = scanner.nextInt();

        System.out.println("Provide the devices amount");
        devicesAmount = scanner.nextInt();

        System.out.println("Provide the languages amount");
        languagesAmount = scanner.nextInt();

        scanner.close();
    }
}