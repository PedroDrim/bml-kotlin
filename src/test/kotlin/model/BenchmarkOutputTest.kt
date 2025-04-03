package model

import model.exception.InvalidParameterException
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class BenchmarkOutputTest {

    class BenchmarkOutputMock : BenchmarkOutput {
        override fun start(tag: String) {}

        override fun end(tag: String) {}

        override fun result(tag: String, format: TimeFormat): Double {
            return 0.0
        }

        override fun result(format: TimeFormat): Map<String, Double> {
            return HashMap()
        }

        override fun export(fileName: String, format: TimeFormat) {}
    }

    @Test
    fun testMustBeInstanciable() {
        assertIs<BenchmarkOutput>(BenchmarkOutputMock(),"1. Integracao com 'BenchmarkOutput'")
    }

}