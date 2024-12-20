package model

import kotlin.test.Test
import kotlin.test.assertEquals

class SiimpleTableAnalysisTest {

    @Test
    fun testIntegration() {
        val mock: SimpleTableAnalysis = MockSimpleTableAnalysis()
        val list: List<UserInfo> = emptyList()
        assertEquals(0.0, mock.analysis(list), "1. Integracao do 'analysis()'")
    }
}

class MockSimpleTableAnalysis: SimpleTableAnalysis {
    override fun analysis(userInfoList: List<UserInfo>): Double {
        return 0.0
    }
}
