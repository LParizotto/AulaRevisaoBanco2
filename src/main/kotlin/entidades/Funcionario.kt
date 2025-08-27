package org.example.entidades

import java.math.BigDecimal
import org.example.enumeradores.Setor
import org.example.enumeradores.Sexo

class Funcionario(
    nome: String,
    sobrenome: String,
    cpf: Long,
    sexo: Sexo,
    val setor: Setor

): Pessoa(
    nome = nome,
    sobrenome = sobrenome,
    cpf = cpf,
    sexo = sexo
){

    //Comportamento do Profissional
    fun instalarCaixaDAgua(clt : Funcionario){
        if(clt.setor.equals(Setor.MONTAGEM)){
            println("Profissional habilitado")
        }else{
            println("Profissional desqualificado")
        }

    }

    override fun receberConta(conta: Conta, aPagar: BigDecimal){
        conta.saldo = conta.saldo.subtract(aPagar)

    }

}