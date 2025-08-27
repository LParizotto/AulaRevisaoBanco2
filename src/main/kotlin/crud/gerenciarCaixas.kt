package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Material

fun cadastrarCaixa(){
    /*

    val material: Material,
    val capacidade : Int,
    val cor: String,
    val peso: Double,
    val marca: String,
     */
    println("Digite o material do qual a caixa é composta: ")
    println("1 - Plástico")
    println("2 - Fibra de vidro")
    println("3 - Polietileno")
    println("4 - Concreto")
    val opcao = readln().toInt()
    var material : Material
    when (opcao) {
        1 -> material = Material.PLASTICO
        2 -> material = Material.FIBRA_DE_VIDRO
        3 -> material = Material.POLIETILENO
        4 -> material = Material.CONCRETO
        else -> material = Material.PLASTICO
    }

    println("Digite a capacidade  da Caixa em Litros: ")
    val litros = readln().toInt()

    println("Digite a cor da Caixa D'Água: ")
    val cor = readln().toString()

    println("Qual o peso da Caixa D'Água: ")
    val peso = readln().toDouble()

    println("Digite a marca da Caixa D'Água: ")
    val marca = readln().toString()

    CaixaDAgua(
        material = material,
        capacidade = litros,
        cor = cor,
        peso = peso,
        marca = marca
    )
}

fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}