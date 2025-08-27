package org.example.entidades

import java.math.BigDecimal

class Conta(
    val titular : Pessoa,
    val numeroConta : Long,
    val senha : String,
    var saldo : BigDecimal,
    val limite: BigDecimal,
    val agencia: Int,


    ) {


}