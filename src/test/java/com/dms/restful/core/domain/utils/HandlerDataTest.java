package com.dms.restful.core.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerDataTest {
    @Test
    void testHandlerValue_NullInput() {
        assertEquals("", HandleData.handlerValue(null), "Deve retornar string vazia para null");
    }

    @Test
    void testHandlerValue_EmptyString() {
        assertEquals("", HandleData.handlerValue(""), "Deve retornar string vazia para entrada vazia");
    }

    @Test
    void testHandlerValue_TrimmedValue() {
        assertEquals("test", HandleData.handlerValue("  test  "), "Deve remover espaços extras");
    }

    @Test
    void testHandlerValue_ReplaceCommaWithDot() {
        assertEquals("3.14", HandleData.handlerValue("3,14"), "Deve substituir vírgula por ponto");
    }

    @Test
    void testHandlerValue_TrimAndReplace() {
        assertEquals("10.5", HandleData.handlerValue("  10,5  "), "Deve remover espaços e substituir vírgula por ponto");
    }

    @Test
    void testIsNumeric_NullInput() {
        assertFalse(HandleData.isNumeric(null), "Null deve retornar false");
    }

    @Test
    void testIsNumeric_EmptyString() {
        assertFalse(HandleData.isNumeric(""), "String vazia deve retornar false");
    }

    @Test
    void testIsNumeric_ValidInteger() {
        assertTrue(HandleData.isNumeric("123"), "Deve reconhecer número inteiro positivo");
    }

    @Test
    void testIsNumeric_ValidNegativeInteger() {
        assertTrue(HandleData.isNumeric("-456"), "Deve reconhecer número inteiro negativo");
    }

    @Test
    void testIsNumeric_ValidDecimal() {
        assertTrue(HandleData.isNumeric("3.14"), "Deve reconhecer número decimal");
    }

    @Test
    void testIsNumeric_ValidNegativeDecimal() {
        assertTrue(HandleData.isNumeric("-7.89"), "Deve reconhecer número decimal negativo");
    }

    @Test
    void testIsNumeric_InvalidCharacters() {
        assertFalse(HandleData.isNumeric("12abc"), "Deve retornar false para string com letras");
    }

    @Test
    void testIsNumeric_MultipleDots() {
        assertFalse(HandleData.isNumeric("1.2.3"), "Deve retornar false para números com múltiplos pontos");
    }
}
