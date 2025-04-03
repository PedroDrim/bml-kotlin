package provider

import model.UserInfo
import model.exception.InvalidParameterException
import model.exception.DataReaderException
import model.DataReader
import java.io.File

/**
 * Classe responsável por ler e disponibilizar os dados em um formato desejado
 * @see DataReader
 */
class TableReader(private val fileName: String) : DataReader {

    /**
     * Lista contendo os dados
     */
    private var userInfoList: List<UserInfo> = emptyList()

    /**
     * Abre o arquivo de dados
     * @throws DataReaderException Lançada caso não seja possível ler os dados corretamente
     */
    fun open() {
        try {
            userInfoList = this.deserializeFile(fileName)
        } catch (_: RuntimeException) {
            throw DataReaderException("Erro ao ler arquivo: $fileName")
        }
    }

    /**
     * Obtém todos os dados disponíveis
     * @return Lista de usuários
     */
    override fun read(): List<UserInfo> = userInfoList

    /**
     * Obtém os dados disponíveis dentro de um intervalo
     * @param startIndex Início do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponíveis dentro do intervalo especificado
     * @throws InvalidParameterException Lançada caso os parâmetros sejam inválidos
     */
    override fun read(startIndex: Int, endIndex: Int): List<UserInfo> {
        if (startIndex < 0) throw InvalidParameterException("'startIndex' é menor que 0")
        if (endIndex < 0) throw InvalidParameterException("'endIndex' é menor que 0")
        if (startIndex >= endIndex) throw InvalidParameterException("'startIndex' é maior ou igual a 'endIndex'")

        return userInfoList.subList(startIndex, endIndex)
    }

    /**
     * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
     * @param fileName Nome do arquivo de dados
     * @return Lista contendo os dados desserializados
     * @throws DataReaderException Lançada caso não seja possível ler os dados corretamente
     */
    private fun deserializeFile(fileName: String): List<UserInfo> {
        try {
            return File(fileName).bufferedReader().useLines { lines ->
                lines.drop(1) // Pula a primeira linha (cabeçalho)
                    .map { convertLine(it) } // Converte cada linha em um objeto UserInfo
                    .toList() // Converte para uma lista
            }

        } catch (_: Exception) {
            throw DataReaderException("Erro ao ler arquivo: $fileName")
        }
    }

    /**
     * Converte a linha em um 'UserInfo'
     * @param line Linha a ser desserializada
     * @return Objeto 'UserInfo'
     */
    private fun convertLine(line: String): UserInfo {
        val values = line.split(",").map { it.trim() }
        val user = values[0]
        val password = values[1]
        val credit = values[2].toDouble()

        return UserInfo(user, password, credit)
    }
}