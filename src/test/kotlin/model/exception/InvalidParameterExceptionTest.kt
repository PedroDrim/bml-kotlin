package model.exception;

import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class InvalidParameterExceptionTest {

    @Test
    fun testMustBeInstanciable() {
        val mensagemEsperada = "teste"
        val exception = InvalidParameterException(mensagemEsperada)

        assertEquals(mensagemEsperada, exception.message, "1. Devera ser instanciado corretamente")
    }

    @Test
    fun testMustBeThrowable() {
        val mensagemErro = "teste"

        assertFailsWith <InvalidParameterException> ("2. Devera ser lancado corretamente") {
            throw InvalidParameterException(mensagemErro)
        }
    }
}