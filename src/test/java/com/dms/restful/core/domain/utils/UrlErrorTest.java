package com.dms.restful.core.domain.utils;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlErrorTest {
    @Test
    void shouldGetUrl() {
        UrlError urlError = new UrlError();

        ReflectionTestUtils.setField(urlError, "url", "http://localhost/error");

        assertEquals("http://localhost/error", urlError.getUrl());
    }
}
