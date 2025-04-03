package model.exception;

import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BenchmarkExceptionTest {

    @Test
    fun testMustBeInstanciable() {
        val mensagemEsperada = "teste"
        val exception = BenchmarkException(mensagemEsperada)

        assertEquals(mensagemEsperada, exception.message, "1. Devera ser instanciado corretamente")
    }

    @Test
    fun testMustBeThrowable() {
        val mensagemErro = "teste"

        assertFailsWith <BenchmarkException> ("2. Devera ser lancado corretamente") {
            throw BenchmarkException(mensagemErro)
        }
    }
}