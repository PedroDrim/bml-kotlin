package provider

import model.TimeFormat
import model.exception.BenchmarkException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.io.File
import kotlin.test.assertTrue
import java.lang.Thread.sleep
import kotlin.test.assertIs

class BenchmarkMeasureTest {

    @Test
    fun mustBeInstanciable() {
        val benchmark = BenchmarkMeasure()
        assertIs<BenchmarkMeasure>(benchmark, "1 - Devera ser instanciavel caso possua valor valido")
    }

    @Test
    fun startMustBeValidWithValidParameters() {
        val benchmark = BenchmarkMeasure()
        assertDoesNotThrow("2 - start() devera ser chamado sem erros caso possua parametros validos") { benchmark.start("test") }
    }

    @Test
    fun endMustBeValidWithValidParameters() {
        val benchmark = BenchmarkMeasure()
        assertDoesNotThrow("3 - end() devera ser chamado sem erros caso possua parametros validos") { benchmark.end("test") }
    }

    @Test
    fun resultMustBeValidWithValidParameters() {
        val benchmark = BenchmarkMeasure()
        benchmark.start("test")
        sleep(10) // Simula tempo de execução
        benchmark.end("test")

        val resultado = benchmark.result("test", TimeFormat.NANOSSEGUNDOS)
        assertTrue(resultado > 0, "4 - result() devera retornar valor valido caso possua parametros validos")
    }

    @Test
    fun resultMustThrowErroWithInvalidParameters() {
        val benchmark = BenchmarkMeasure()
        assertThrows<BenchmarkException>("5 - result() devera retornar erro caso a tag nao exista") {
            val resultado = benchmark.result("test", TimeFormat.NANOSSEGUNDOS)
        }
    }

    @Test
    fun resultMustThrowErroWithNoStart() {
        val benchmark = BenchmarkMeasure()
        benchmark.end("test")

        assertThrows<BenchmarkException>("6 - result() devera retornar erro caso a tag nao possua start") {
            val resultado = benchmark.result("test", TimeFormat.NANOSSEGUNDOS)
        }
    }

    @Test
    fun resultMustThrowErroWithNoEnd() {
        val benchmark = BenchmarkMeasure()
        benchmark.start("test")

        assertThrows<BenchmarkException>("7 - result() devera retornar erro caso a tag nao possua end") {
            val resultado = benchmark.result("test", TimeFormat.NANOSSEGUNDOS)
        }
    }

    @Test
    fun resultMustBeValidByDefault() {
        val benchmark = BenchmarkMeasure()
        benchmark.start("T1")
        sleep(10)
        benchmark.end("T1")

        val resultado = benchmark.result(TimeFormat.NANOSSEGUNDOS)
        assertTrue(resultado.isNotEmpty(), "8 - result() devera ser valido por padrao")
    }

    @Test
    fun exportMustBeValidwithValidParameters() {
        val benchmark = BenchmarkMeasure()
        val fileName = "benchmark.json"

        benchmark.start("T1")
        sleep(10)
        benchmark.end("T1")

        benchmark.export(fileName, TimeFormat.NANOSSEGUNDOS)

        val file = File(fileName)
        assertTrue(file.exists(), "9 - export() devera ser valido caso possua valores validos")
        file.delete() // Remove o arquivo após o teste
    }
}
