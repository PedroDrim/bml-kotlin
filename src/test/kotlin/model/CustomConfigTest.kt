package model

import kotlin.test.Test
import kotlin.test.assertEquals

class CustomConfigTest {

    @Test
    fun testNewInstance() {
        val config: CustomConfig = CustomConfig(emptyArray(), "p1")
        assertEquals(config, config, "1. Devera ser instanciavel corretamente")
    }

    @Test
    fun testGetInputFilenameList() {
        val expected: Array<String> = emptyArray<String>()
        val config: CustomConfig = CustomConfig(expected, "p1")
        assertEquals(expected, config.INPUT_FILENAME_LIST, "2. 'INPUT_FILENAME_LIST' devera ser obtido corretamente")
    }

    @Test
    fun testGeOutputFilename() {
        val expected: String = "output"
        val config: CustomConfig = CustomConfig(emptyArray(), expected)
        assertEquals(expected, config.OUTPUT_FILENAME, "3. 'OUTPUT_FILENAME' devera ser executado corretamente")
    }
}
