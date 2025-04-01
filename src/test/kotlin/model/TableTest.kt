package model

import kotlin.test.Test
import kotlin.test.assertEquals

class TableTest {

    @Test
    fun testNewInstance() {
        val table: Table = Table("data/test.csv")
        assertEquals(table, table, "1. Devera ser inscanciavel caso possua valor valido")
    }

    @Test
    fun testGetUserInfoList() {
        val table: Table = Table("data/test.csv")
        assertEquals(table.userInfoList, table.userInfoList, "2. 'userInfoList' devera retornar valor corretamente")
    }
}