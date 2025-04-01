package org.example

import model.SimpleTableAnalysis
import model.Table
import provider.MaxValueAnalysis
import provider.MeanAnalysis
import provider.MinValueAnalysis
import kotlin.system.exitProcess
import kotlin.system.measureTimeMillis

class App {
    fun run(args: Array<String>) {

        // Obtendo nome do arquivo de entrada
        val fileName: String = prepareArgs(args)

        // Instanciando builder
        val builder: StringBuilder = StringBuilder()

        // Instanciando tabela
        val table: Table

        // Obtendo o tempo de leitura em milissegundos
        val leitura: Long = measureTimeMillis {
            // Convertendo arquivo em lista de "UserInfo"
            table = Table(fileName)
        }

        // Obtendo lista de usuarios
        val list = table.userInfoList

        // Instanciando analises
        val maxAnalysis: SimpleTableAnalysis = MaxValueAnalysis()
        val minAnalysis: SimpleTableAnalysis = MinValueAnalysis()
        val meanAnalysis: SimpleTableAnalysis = MeanAnalysis()

        // Iniciando valores
        var maxV: Double = 0.0
        var minV: Double = 0.0
        var meanV: Double = 0.0

        // Obtendo o tempo de analise em milissegundos
        val analise: Long = measureTimeMillis {
            // Realizando analises
            maxV = maxAnalysis.analysis(list)
            minV = minAnalysis.analysis(list)
            meanV = meanAnalysis.analysis(list)
        }

        // Dados de saida
        builder.append("[OK]Arquivo: $fileName").append("\n");
        builder.append("[OK]Tempo_leitura: ").append(leitura).append(" ms").append("\n");
        builder.append("[OK]Tempo_analise: ").append(analise).append(" ms").append("\n");
        builder.append("[OK]Max: $maxV").append("\n");
        builder.append("[OK]Min: $minV").append("\n");
        builder.append("[OK]Mean: $meanV");

        println("[START] $fileName\n")
        println(builder.toString())
        println("[END] $fileName\n")
    }

    /**
     * Método para captura e tratamento dos parametros obtidos via console
     * @param codes Lista de parametros obtidos via console
     * @return Tamanho de usuários á serem gerados
     */
    private fun prepareArgs(codes: Array<String>): String {
        if (codes.size != 1) {
            println("Parametros inválidos.")
            exitProcess(-1)
        }

        val line = codes[0]
        return line
    }
}

fun main(args: Array<String>) {
    App().run(args)
}
