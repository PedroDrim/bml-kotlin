package model

import java.io.BufferedReader
import java.io.File

/**
 * Classe para gerenciar uma tabela de usuarios
 * @param fileName Nome do arquivo
 */
class Table(fileName: String) {

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    val userInfoList: List<UserInfo> = this._deserializeFile(fileName)

    /**
     * Método privado para encriptar senhas
     * @param fileName Nome do arquivo
     * @return Lista convertida de usuarios  
     */
    private fun _deserializeFile(fileName: String): List<UserInfo> {
        // Lendo arquivo .csv
        val bufferedReader: BufferedReader = File(fileName).bufferedReader()

        // Iniciando lista mutavel
        val list = mutableListOf<UserInfo>()
        var header: Boolean = true

        bufferedReader.useLines {
            lines -> lines.forEach {

                if(header) {
                    header = false
                }else {
                    // Separando valores
                    val values = it.split(",")

                    // Obtendo valores do usuario
                    val user: String = values[0].trim()
                    val password: String = values[1].trim()
                    val credit: Double = values[2].trim().toDouble()

                    // Construindo usuario
                    val userInfo = UserInfo(user, password, credit)

                    list.add(userInfo)
                }
            }
        }

        bufferedReader.close()
        return list.toList()
    }
}