package provider

import model.TableAnalysis
import model.UserInfo
import model.exception.InvalidParameterException

/**
 * Classe para ordenação MergeSort
 * @see model.TableAnalysis
 */
class MergeSortAnalysis : TableAnalysis<List<UserInfo>> {

    /**
     * Realiza uma ordenação MergeSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Lista ordenada
     * @throws InvalidParameterException Caso a lista seja vazia
     */
    override fun analysis(userInfoList: List<UserInfo>): List<UserInfo> {
        if (userInfoList.isEmpty())
            throw InvalidParameterException("'userInfoList' é vazio")
        return mergeSort(userInfoList)
    }

    /**
     * Inicia o MergeSort
     * @param array Lista a ser ordenada
     * @return Lista ordenada
     */
    private fun mergeSort(array: List<UserInfo>): List<UserInfo> {
        if (array.size <= 1) return array

        val meio = array.size / 2
        val esquerda = this.mergeSort(array.subList(0, meio))
        val direita = this.mergeSort(array.subList(meio, array.size))

        return this.merge(esquerda, direita)
    }

    /**
     * Método responsável por unir os vetores
     * @param esquerda Lista da esquerda
     * @param direita Lista da direita
     * @return Lista unificada
     */
    private fun merge(esquerda: List<UserInfo>, direita: List<UserInfo>): List<UserInfo> {
        val response = mutableListOf<UserInfo>()
        var indexEsquerda = 0
        var indexDireita = 0

        while (indexEsquerda < esquerda.size && indexDireita < direita.size) {
            if (esquerda[indexEsquerda].credit > direita[indexDireita].credit) {
                response.add(esquerda[indexEsquerda])
                indexEsquerda++
            } else {
                response.add(direita[indexDireita])
                indexDireita++
            }
        }

        response.addAll(esquerda.subList(indexEsquerda, esquerda.size))
        response.addAll(direita.subList(indexDireita, direita.size))

        return response
    }
}
