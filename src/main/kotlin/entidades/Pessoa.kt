package org.example.entidades

import org.example.enumeradores.Sexo
import java.math.BigDecimal

open class Pessoa(
    val nome: String,
    val sobrenome: String,
    val cpf: Long,
    val sexo: Sexo

) {

    open fun receberConta(conta: Conta, aReceber: BigDecimal){
        conta.saldo = conta.saldo.add(aReceber)

    }
}