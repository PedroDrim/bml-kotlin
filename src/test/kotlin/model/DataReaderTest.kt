package model

import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class DataReaderTest {

    class DataReaderMock : DataReader {
        override fun read(): List<UserInfo> {
            return ArrayList()
        }

        override fun read(startIndex: Int, endIndex: Int): List<UserInfo> {
            return ArrayList()
        }
    }

    @Test
    fun testMustBeInstanciable() {
        assertIs<DataReader>(DataReaderMock(),"1. Integracao com 'DataReader'")
    }

}