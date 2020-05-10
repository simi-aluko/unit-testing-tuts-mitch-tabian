package com.simileoluwaaluko.unittesting.util

import com.simileoluwaaluko.unittesting.util.DateUtil.GET_MONTH_ERROR
import com.simileoluwaaluko.unittesting.util.DateUtil.getMonthFromNumber
import com.simileoluwaaluko.unittesting.util.DateUtil.monthNumbers
import com.simileoluwaaluko.unittesting.util.DateUtil.months
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestReporter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

/**
 * Created by Simileoluwa Aluko on 2020-05-05.
 */
class DateUtilTest {
    val today = "05-2020"

    @Test
    fun testGetCurrentTimestamp_returnedTimestamp() {
        assertDoesNotThrow {
            assertEquals(today, DateUtil.getCurrentTimeStamp())
            println("Timestamp is generated correctly")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun getMonthFromNumber_returnSuccess(monthNumber : Int, testInfo: TestInfo, testReporter: TestReporter) {
        assertEquals(months[monthNumber], DateUtil.getMonthFromNumber(monthNumbers[monthNumber]))
        println(monthNumbers[monthNumber] + " : " + months[monthNumber])
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun testGetMonthFromNumber_returnError(monthNumber : Int, testInfo: TestInfo, testReporter: TestReporter) {
        val randomInt = Random.nextInt(90) + 13
        assertEquals(getMonthFromNumber((monthNumber * randomInt).toString()), GET_MONTH_ERROR)
        println((monthNumber * randomInt).toString())
        println(monthNumbers[monthNumber] + " : " + GET_MONTH_ERROR)
    }
}