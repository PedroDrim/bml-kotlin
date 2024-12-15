import model.UserInfo
import kotlin.system.exitProcess
import kotlin.system.measureTimeMillis

/**
 * Função de inicialização do projeto
 * @param args Lista de parametros obtidos via console
 */
fun main(args: Array<String>) {
    // Tamanho dos objetos a serem gerados
    val tamanho: Int = prepareArgs(args)

    // Gerando builder e vetor de usuairos
    val builder: StringBuilder = StringBuilder()
    val list: Array<UserInfo?> = arrayOfNulls<UserInfo>(tamanho)

    // Medindo tempo
    val tempo: Long = measureTimeMillis {
        for (index in 0..<tamanho) {
            builder.clear()
            builder.append("user").append(index)
            val user: String = builder.toString()

            builder.clear()
            builder.append("password").append(index)
            val password: String = builder.toString()

            // Criando usuarios
            list[index] = UserInfo(user, password)
        }
    }

    builder.clear()
    builder.append("[OK]Tamanho: ").append(tamanho).append("\n").append("Tempo: ").append(tempo).append(" ms")

    // Retornando resposta
    println(builder.toString())
}

/**
 * Método para captura e tratamento dos parametros obtidos via console
 * @param codes Lista de parametros obtidos via console
 * @return Tamanho de usuários á serem gerados
 */
private fun prepareArgs(codes: Array<String>): Int {
    // Verificando tamanho de parametro
    if (codes.size != 1) {
        println("Parametros inválidos.")
        exitProcess(-1)
    }

    val line = Integer.parseInt(codes[0])

    // Validando quantidade de linhas
    if (line <= 0) {
        println("Quantidade de linhas menor que 1.")
        exitProcess(-1)
    }

    return line
}