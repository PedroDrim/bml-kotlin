package org.example

import model.*
import model.exception.InvalidParameterException
import provider.*
import java.io.File

fun main(args: Array<String>) {

    if (args.isEmpty()) throw InvalidParameterException("Parametros iniciais nao encontrados")
    val configFile = args[0]
    val properties = loadProperties(configFile)

    val inputList = properties.INPUT_FILENAME_LIST
    val output = properties.OUTPUT_FILENAME

    val benchmark: BenchmarkOutput = BenchmarkMeasure()
    val mergeSortAnalysis: TableAnalysis<List<UserInfo>> = MergeSortAnalysis()
    val quickSortAnalysis: TableAnalysis<List<UserInfo>> = QuickSortAnalysis()
    val languageSortAnalysis: TableAnalysis<List<UserInfo>> = LanguageSortAnalysis()
    val summaryAnalysis: TableAnalysis<Array<Double>> = SummaryAnalysis()

    for(index in inputList.indices) {
        val input = inputList [index]
        println("[START] Arquivo: $index")
        //==================================================
        // Leitura dos dados
        println("\t[LOG] Read")
        benchmark.start("Read@$index")
        val tableReader = TableReader(input)
        tableReader.open()
        val userInfoList = tableReader.read()
        benchmark.end("Read@$index")
        //==================================================
        // Analise dos dados (Summary)
        println("\t[LOG] Summary")
        benchmark.start("SummaryAnalysis@$index")
        val summary = summaryAnalysis.analysis(userInfoList)
        benchmark.end("SummaryAnalysis@$index")
        //==================================================
        // Analise dos dados (Merge)
        println("\t[LOG] Merge")
        benchmark.start("MergeAnalysis@$index")
        val mergeValue = mergeSortAnalysis.analysis(userInfoList)
        benchmark.end("MergeAnalysis@$index")
        //==================================================
        // Analise dos dados (Quick)
        println("\t[LOG] Quick")
        benchmark.start("QuickAnalyse@$index")
        val quickValue = quickSortAnalysis.analysis(userInfoList)
        benchmark.end("QuickAnalyse@$index")
        //==================================================
        // Analise dos dados (Language)
        println("\t[LOG] Language")
        benchmark.start("LanguageAnalyse@$index")
        val languageValue = languageSortAnalysis.analysis(userInfoList)
        benchmark.end("LanguageAnalyse@$index")
        //==================================================
        println("[END] Arquivo: $index")
    }

    benchmark.export(output, TimeFormat.MILISSEGUNDOS)
}

fun loadProperties(configFile: String): CustomConfig {
    val jsonString = File(configFile).readText()
    val customConfig: CustomConfig = parseJsonToConfig(jsonString)
    return customConfig
}


fun parseJsonToConfig(json: String): CustomConfig {
    // Remove espaços extras, quebras de linha e mantém o formato correto
    val cleanedJson = json.replace("\n", "").replace("\r", "").replace(" ", "")

    // Extração manual dos valores
    val inputListRegex = Regex(""""INPUT_FILENAME_LIST":\[(.*?)\]""")
    val outputFileRegex = Regex(""""OUTPUT_FILENAME":"(.*?)"""")

    // Encontrando correspondências
    val inputListMatch = inputListRegex.find(cleanedJson)
    val outputFileMatch = outputFileRegex.find(cleanedJson)

    // Convertendo INPUT_FILENAME_LIST para Array<String>
    val inputFileNameList = inputListMatch?.groupValues?.get(1)
        ?.split(",") // Divide pelos elementos da lista
        ?.map { it.trim().removeSurrounding("\"") } // Remove espaços e aspas
        ?.toTypedArray() ?: emptyArray()

    // Extraindo OUTPUT_FILENAME
    val outputFileName = outputFileMatch?.groupValues?.get(1) ?: ""

    return CustomConfig(inputFileNameList, outputFileName)
}