package provider

import model.UserInfo
import model.exception.InvalidParameterException
import model.TableAnalysis

/**
 * Classe para ordenação QuickSort
 * @see TableAnalysis
 */
class QuickSortAnalysis : TableAnalysis<List<UserInfo>> {

    /**
     * Realiza uma análise e ordenação com QuickSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Lista ordenada
     * @throws InvalidParameterException Se a lista estiver vazia
     */
    override fun analysis(userInfoList: List<UserInfo>): List<UserInfo> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")

        return this.quickSort(userInfoList)
    }

    /**
     * Iniciando QuickSort
     * @param array Lista a ser ordenada
     * @return Lista ordenada
     */
    private fun quickSort(array: List<UserInfo>): List<UserInfo> {
        if (array.size <= 1) return array

        // Obtendo posição central
        val pivot = array[array.size / 2]

        // Separando vetores
        val menores = array.filter { it.credit < pivot.credit }
        val iguais = array.filter { it.credit == pivot.credit }
        val maiores = array.filter { it.credit > pivot.credit }

        // Retornando vetor ordenado
        return this.quickSort(maiores) + iguais + this.quickSort(menores)
    }
}
