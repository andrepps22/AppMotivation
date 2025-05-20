package com.example.motivation.data

import com.example.motivation.utils.AppConsts

data class Phrase(val description:String, val category: Int)

class PhraseRepository {
    val all = AppConsts.FILTER.ALL

    val listOfPhrase = listOf(
        // Happy
        Phrase("A felicidade começa com um sorriso sincero.", AppConsts.FILTER.HAPPY),
        Phrase("Encontre alegria nas pequenas coisas.", AppConsts.FILTER.HAPPY),
        Phrase("Você merece ser feliz, todos os dias.", AppConsts.FILTER.HAPPY),
        Phrase("A gratidão é o caminho mais curto até a felicidade.", AppConsts.FILTER.HAPPY),
        Phrase("Sorrir é o melhor remédio para qualquer dia ruim.", AppConsts.FILTER.HAPPY),
        Phrase("Quando você escolhe a felicidade, tudo muda.", AppConsts.FILTER.HAPPY),
        Phrase("A alegria é contagiante — espalhe por aí!", AppConsts.FILTER.HAPPY),
        Phrase("Permita-se ser leve, permita-se ser feliz.", AppConsts.FILTER.HAPPY),
        Phrase("Não espere momentos perfeitos, faça-os felizes.", AppConsts.FILTER.HAPPY),
        Phrase("A felicidade está em seguir o seu próprio caminho.", AppConsts.FILTER.HAPPY),

        // Sunny
        Phrase("Deixe o sol tocar sua alma hoje.", AppConsts.FILTER.SUNNY),
        Phrase("Cada raio de sol traz uma nova chance.", AppConsts.FILTER.SUNNY),
        Phrase("O brilho do sol é o reflexo da sua força.", AppConsts.FILTER.SUNNY),
        Phrase("Um dia ensolarado começa com uma mente clara.", AppConsts.FILTER.SUNNY),
        Phrase("O céu azul é um convite para recomeçar.", AppConsts.FILTER.SUNNY),
        Phrase("O sol não se cansa de brilhar — e você também não deveria.", AppConsts.FILTER.SUNNY),
        Phrase("Abra a janela, respire fundo e sinta o poder do agora.", AppConsts.FILTER.SUNNY),
        Phrase("Em dias de sol, a esperança floresce mais rápido.", AppConsts.FILTER.SUNNY),
        Phrase("O calor do sol aquece até os sonhos adormecidos.", AppConsts.FILTER.SUNNY),
        Phrase("A luz que você procura lá fora também está dentro de você.", AppConsts.FILTER.SUNNY)
    )

    fun getPhrase(filter: Int): String{
            val phrase = listOfPhrase.filter { (it.category == filter|| filter == all) }
            val rand = phrase.indices.random()
            return phrase[rand].description


    }
}