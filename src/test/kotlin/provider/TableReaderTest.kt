package provider

import model.UserInfo
import model.exception.DataReaderException
import model.exception.InvalidParameterException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertContentEquals

class TableReaderTest {

    @Test
    fun mustBeInstanciableByDefault() {
        assertDoesNotThrow("1. Devera ser instanciavel caso possua valor valido") {
            val tableReader = TableReader("./data/test.csv")
        }
    }

    @Test
    fun openMustBeValidWithValidParameters() {
        val tableReader = TableReader("./data/test.csv")
        assertDoesNotThrow("2. 'open()' devera retornar valor valido caso arquivo seja valido") {
            tableReader.open()
        }
    }

    @Test
    fun openMustBeInvalidWithInvalidParameters() {
        val tableReader = TableReader("./data/fake.csv")
        assertThrows<DataReaderException>("3. 'open()' devera retornar excessao caso arquivo seja invalido") {
            tableReader.open()
        }
    }

    @Test
    fun readMustBeValidByDefault() {
        val tableReader = TableReader("./data/test.csv")
        tableReader.open()

        val expected = listOf(
            UserInfo("u1", "p1", 1.0),
            UserInfo("u2", "p2", 2.0),
            UserInfo("u3", "p3", 3.0),
            UserInfo("u4", "p4", 4.0),
            UserInfo("u5", "p5", 5.0),
            UserInfo("u6", "p6", 6.0),
            UserInfo("u7", "p7", 7.0),
            UserInfo("u8", "p8", 8.0),
            UserInfo("u9", "p9", 9.0),
            UserInfo("u10", "p10", 10.0)
        ).map(UserInfo::credit)

        val response = tableReader.read().map(UserInfo::credit)
        assertContentEquals(response, expected,"4. 'read()' devera retornar valor valido por padrao")
    }

    @Test
    fun readMustBeValidWithValidParameters() {
        val tableReader = TableReader("./data/test.csv")
        tableReader.open()

        val expected = listOf(
            UserInfo("u2", "p2", 2.0)
        ).map(UserInfo::credit)

        val response = tableReader.read(1,2).map(UserInfo::credit)
        assertContentEquals(response, expected,"5. 'read()' devera retornar valor valido caso possua valores validos")
    }

    @Test
    fun readMustBeInvalidWithStartNegative() {
        val tableReader = TableReader("./data/test.csv")
        assertThrows<InvalidParameterException>("6. 'read()' devera ser invalido caso 'start' seja negativo") { tableReader.read(-2,1) }
    }

    @Test
    fun readMustBeInvalidWithEndNegative() {
        val tableReader = TableReader("./data/test.csv")
        assertThrows<InvalidParameterException>("7. 'read()' devera ser invalido caso 'end' seja negativo") { tableReader.read(2,-1) }
    }

    @Test
    fun readMustBeInvalidWithEndLessThanStart() {
        val tableReader = TableReader("./data/test.csv")
        assertThrows<InvalidParameterException>("8. 'read()' devera ser invalido caso 'end' seja menor que 'start'") { tableReader.read(2,1) }
    }

    @Test
    fun readMustBeInvalidWithStartEqualEnd() {
        val tableReader = TableReader("./data/test.csv")
        assertThrows<InvalidParameterException>("9. 'read()' devera ser invalido caso 'end' seja igual a 'start'") { tableReader.read(2,2) }
    }
}