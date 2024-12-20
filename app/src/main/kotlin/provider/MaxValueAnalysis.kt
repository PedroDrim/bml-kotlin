package provider

import model.UserInfo
import model.SimpleTableAnalysis

// Criando uma classe "MaxValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MaxValueAnalysis: SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar a análise na lista de "UserInfo"
     * @param userInfoList Lista de "UserInfo"
     * @return valor máximo da análise
     */
    override fun analysis(userInfoList: List<UserInfo>): Double {
        var max: Double = Double.MIN_VALUE

        userInfoList.forEach {
            if(it.credit > max) max = it.credit
        }

        return max
    }
}