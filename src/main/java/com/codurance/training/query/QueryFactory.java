package com.codurance.training.query;

public class QueryFactory {
    public static Query queryFrom(String commandLine) {
        String[] commandRest = commandLine.split(" ");
        String command = commandRest[0];

        switch (command) {
            case "today":
                return new Today();
            default:
                return null;
        }
    }
}
