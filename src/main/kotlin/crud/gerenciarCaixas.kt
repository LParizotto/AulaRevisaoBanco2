package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Material
import java.sql.Connection
import java.sql.ResultSet

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5432/postgres",
    usuario = "postgres",
    senha = "postgres",
)

fun criarTabelaCaixa(){


    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY, " +
            " material varchar(255), " +
            " capacidade integer, " +
            " cor varchar(30), " +
            " peso double, " +
            " marca varchar(255) " +
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)

    banco.close()
}

fun cadastrarCaixa(){

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



    val c = CaixaDAgua(

        material = material,
        capacidade = litros,
        cor = cor,
        peso = peso,
        marca = marca
    )

    val banco = conectar.conectarComBanco()!!.prepareStatement(
        "INSERT INTO CaixaDAgua " +
                " (material, capacidade, cor, peso, marca) " +
                " VALUES (?, ?, ?, ?, ?)"
    )
        banco.setString(1, c.material.name)
        banco.setInt(2, c.capacidade)
        banco.setString(3, c.cor)
        banco.setDouble(4, c.peso)
        banco.setString(5, c.marca)

        banco.executeUpdate()//Isso fará um COMMIT no banco
        banco.close()//Fecha a transação e a conexão com o banco

}

fun editarCaixa(){

}

fun listarCaixas(){

    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    val resultados : ResultSet = banco!!.createStatement().executeQuery(sql)

    while(resultados.next()){
        println("---------------------------------")
        println("Id: ${resultados.getString("id")}")
        println("Capacidade: ${resultados.getString("capacidade")}")
        println("Cor: ${resultados.getString("cor")}")
        println("Material: ${resultados.getString("material")}")
        println("Peso: ${resultados.getString("peso")}")
        println("Marca: ${resultados.getString("marca")}")
        println("---------------------------------")
    }

}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir: ")
    val id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id=?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1, id)
    val retorno = resultados.executeQuery()
    while(retorno.next()){
        println("---------------------------------")
        println("Id: ${retorno.getString("id")}")
        println("Capacidade: ${retorno.getString("capacidade")}")
        println("Cor: ${retorno.getString("cor")}")
        println("Material: ${retorno.getString("material")}")
        println("Peso: ${retorno.getString("peso")}")
        println("Marca: ${retorno.getString("marca")}")
        println("---------------------------------")
    }

    println("Tem certeza que vai excluir isso!!")
    val resposta = readln().lowercase()
    when(resposta){
        "sim"->{
           val deletar=  banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id=?")
            deletar.setInt(1, id)
            deletar.executeUpdate()
        }else ->{
            println("Operação Cancelada!!!!")
        }

    }



}