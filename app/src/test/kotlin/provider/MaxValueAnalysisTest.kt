package provider

import model.SimpleTableAnalysis
import model.UserInfo
import kotlin.test.Test
import kotlin.test.assertEquals

class MaxValueAnalysisTest {

    @Test
    fun testNewInstance() {
        val mock: SimpleTableAnalysis = MaxValueAnalysis()
        assertEquals(mock, mock, "1. Devera ser instanciavel")
    }

    @Test
    fun testAnalysisMethod() {
        val mock: SimpleTableAnalysis = MaxValueAnalysis()
        val list: List<UserInfo> = listOf(
            UserInfo("u1", "p1", 1.0),
            UserInfo("u2", "p2", 2.0),
            UserInfo("u3", "p3", 3.0)
        )
        assertEquals(3.0, mock.analysis(list), "2. 'analysis()' devera ser valido caso possua parametros validos'")
    }
}