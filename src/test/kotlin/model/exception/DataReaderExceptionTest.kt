package model.exception;

import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DataReaderExceptionTest {

    @Test
    fun testMustBeInstanciable() {
        val mensagemEsperada = "teste"
        val exception = DataReaderException(mensagemEsperada)

        assertEquals(mensagemEsperada, exception.message, "1. Devera ser instanciado corretamente")
    }

    @Test
    fun testMustBeThrowable() {
        val mensagemErro = "teste"

        assertFailsWith <DataReaderException> ("2. Devera ser lancado corretamente") {
            throw DataReaderException(mensagemErro)
        }
    }
}