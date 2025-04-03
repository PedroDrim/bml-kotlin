package provider

import model.UserInfo
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertContentEquals

class SummaryAnalysisTest {

    @Test
    fun mustBeInstanciableByDefault() {
        assertDoesNotThrow("1. Devera ser valido por padrao") {
            val summaryAnalysis = SummaryAnalysis()
        }
    }

    @Test
    fun analysisMustBeValidWithValidParameters() {
        val summaryAnalysis = SummaryAnalysis()
        val value = listOf(
            UserInfo("u2", "p2", 2.0),
            UserInfo("u1", "p1", 1.0),
            UserInfo("u3", "p3", 3.0)
        )

        val expected: Array<Double> = listOf(1.0, 3.0, 2.0).toTypedArray()
        val response: Array<Double> = summaryAnalysis.analysis(value)
        assertContentEquals(response , expected,"2. 'analysis' devera ser valido caso possua valores validos")
    }
}
