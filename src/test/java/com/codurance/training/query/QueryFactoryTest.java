package com.codurance.training.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryFactoryTest {

    @Test
    public void should_create_a_today_query() {
        Query command = QueryFactory.queryFrom("today");
        assertEquals(new Today(), command);
    }
}
