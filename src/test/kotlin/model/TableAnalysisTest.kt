package model

import org.junit.jupiter.api.Test
import kotlin.test.assertIs

class TableAnalysisTest {

    class TableAnalysisMock : TableAnalysis<Double> {
        override fun analysis(userInfoList: List<UserInfo>): Double {
            return 0.0
        }
    }

    @Test
    fun testMustBeInstanciable() {
        assertIs<TableAnalysis<Double>>(TableAnalysisMock(),"1. Integracao com 'TableAnalysis'")
    }
}