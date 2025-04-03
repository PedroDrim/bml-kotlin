package provider

import model.UserInfo
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertContentEquals

class QuickSortAnalysisTest {

    @Test
    fun mustBeInstanciableByDefault() {
        assertDoesNotThrow("1. Devera ser valido por padrao") {
            val quickSortAnalysis = QuickSortAnalysis()
        }
    }

    @Test
    fun analysisMustBeValidWithValidParameters() {
        val quickSortAnalysis = QuickSortAnalysis()
        val value = listOf(
            UserInfo("u2", "p2", 2.0),
            UserInfo("u1", "p1", 1.0),
            UserInfo("u3", "p3", 3.0)
        )

        val expected = listOf(
            UserInfo("u3", "p3", 3.0),
            UserInfo("u2", "p2", 2.0),
            UserInfo("u1", "p1", 1.0)
        ).map(UserInfo::credit)

        val response = quickSortAnalysis.analysis(value).map(UserInfo::credit)
        assertContentEquals(response, expected,"2. 'analysis' devera ser valido caso possua valores validos")
    }
}
