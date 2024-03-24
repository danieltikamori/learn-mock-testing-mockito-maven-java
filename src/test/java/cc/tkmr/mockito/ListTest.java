/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Mock
    private List<String> wordList; // Mock this List<String>

    @Test
    void addItemToList() { // Test the addItemToList() method
    when(wordList.get(0)).thenReturn("Bob");
    assertEquals("Bob", wordList.get(0));
    }
    @Test
    void removeItemFromList() {
        when(wordList.removeFirst()).thenReturn("Bob");
        assertEquals("Bob", wordList.removeFirst());
    }
    @Test
    void clearList() {
        wordList.clear();
        verify(wordList, times(1)).clear();
    }
    @Test
    void sizeOfList() {
        when(wordList.size()).thenReturn(3);
        assertEquals(3, wordList.size());
    }
    @Test
    void isEmptyList() {
        when(wordList.isEmpty()).thenReturn(false);
        assertFalse(wordList.isEmpty());
    }
    @Test
    void containsItem() {
        when(wordList.contains("Bob")).thenReturn(true);
        assertTrue(wordList.contains("Bob"));
    }
    @Test
    void indexOfItem() {
        when(wordList.indexOf("Bob")).thenReturn(0);
        assertEquals(0, wordList.indexOf("Bob"));
    }

    @Test
    void lastIndexOfItem() {
        when(wordList.lastIndexOf("Bob")).thenReturn(0);
        assertEquals(0, wordList.lastIndexOf("Bob"));
    }
}

