package model

import kotlin.test.Test
import kotlin.test.assertEquals

class TimeFormatTest {

    @Test
    fun testSegundosValue() {
        assertEquals(TimeFormat.SEGUNDOS.proportion, 0.001, "1. Devera obter o valor de 'SEGUNDOS' corretamente")
    }

    @Test
    fun testMilissegundosValue() {
        assertEquals(TimeFormat.MILISSEGUNDOS.proportion, 1.0, "2. Devera obter o valor de 'MILISSEGUNDOS' corretamente")
    }

    @Test
    fun testNanossegundosValue() {
        assertEquals(TimeFormat.NANOSSEGUNDOS.proportion, 1000.0, "3. Devera obter o valor de 'NANOSSEGUNDOS' corretamente")
    }
}
