package provider

import model.UserInfo
import model.SimpleTableAnalysis

// Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
class MinValueAnalysis: SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar a análise na lista de "UserInfo"
     * @param Lista de "UserInfo"
     * @return valor minimo da análise
     */
    override fun analysis(userInfoList: List<UserInfo>): Double {
        var min: Double = Double.MAX_VALUE

        userInfoList.forEach {
            if(it.credit < min) min = it.credit
        }

        return min
    }
}