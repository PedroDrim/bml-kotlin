package provider

import model.UserInfo
import model.SimpleTableAnalysis

// Criando uma classe "MeanAnalysis" que implementa a interface "SimpleTableAnalysis"
class MeanAnalysis: SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar a análise na lista de "UserInfo"
     * @param userInfoList Lista de "UserInfo"
     * @return media aritmética de valores da análise
     */
    override fun analysis(userInfoList: List<UserInfo>): Double {
        var mean: Double = 0.0
        userInfoList.forEach {
            mean += it.credit
        }

        return mean/userInfoList.size
    }
}