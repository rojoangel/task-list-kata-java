package com.codurance.training.query;

public class Today implements Query {

    public Today(String... arguments) {
    }

    @Override
    public String execute() {
        return System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
