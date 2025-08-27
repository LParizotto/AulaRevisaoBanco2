package org.example.ui

fun menu(){
    do{
        println("1 - Cadastrar Caixa D'Água: ")
        println("2 - Editar Caixa D'Água: ")
        println("3 - Listar Caixas D'Água: ")
        println("4 - Excluir Caixa D'Água: ")
        println("0 - Sair")
        println("--------------------------------")

        var opcao = readln().toInt()

        when(opcao){
            0 -> println("Saindo...")
            1 -> println("Cadastrando caixa...")
            2 -> println("Editando caixa...")
            3 -> println("Listando caixas...")
            4 -> println("Excluindo caixa...")
            else -> println("Opção desconhecida...")

        }

    }while(opcao != 0)

}