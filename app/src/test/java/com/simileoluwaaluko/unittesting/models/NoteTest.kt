package com.simileoluwaaluko.unittesting.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by Simileoluwa Aluko on 2020-05-02.
 */
class NoteTest {

    val TIMESTAMP1 = "03-2020"
    val TIMESTAMP2 = "04-2020"

    /**
     *  Compare two equal notes
     */
    @Test
    fun isNotesEqual_identicalProperties_returnTrue() {
        //arrange
        val note1 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note1.id = 1
        val note2 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note2.id = 1

        //act

        //assert
         assertEquals(note1, note2)
        println("the notes are equal!")
    }


    /**
     * compare notes with 2 different ids
     */
    @Test
    fun isNotesEqual_differentIds_returnFalse() {
        //arrange
        val note1 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note1.id = 1
        val note2 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note2.id = 2

        //act

        //assert
        assertNotEquals(note1, note2)
        println("the notes are not equal!")
    }


    /**
     * compare two notes with different timestamps
     */
    @Test
    fun isNotesEqual_differentTimestamps_returnTrue() {
        //arrange
        val note1 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note1.id = 1
        val note2 = Note("Note #1", "this is note 1", TIMESTAMP2)
        note2.id = 1

        //act

        //assert
        assertEquals(note1, note2)
        println("the notes are equal!")
    }

    /**
     * compare two notes with different titles
     */
    @Test
    fun isNotesEqual_differentTitles_returnFalse() {
        //arrange
        val note1 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note1.id = 1
        val note2 = Note("Note #2", "this is note 1", TIMESTAMP1)
        note2.id = 1

        //act

        //assert
        assertNotEquals(note1, note2)
        println("the notes are not equal! different timestamps")
    }

    /**
     * compare two notes with different content
     */
    @Test
    fun isNotesEqual_differentContents_returnFalse() {
        //arrange
        val note1 = Note("Note #1", "this is note 1", TIMESTAMP1)
        note1.id = 1
        val note2 = Note("Note #1", "this is note 2 ", TIMESTAMP1)
        note2.id = 1

        //act

        //assert
        assertNotEquals(note1, note2)
        println("the notes are not equal! different content")
    }
}