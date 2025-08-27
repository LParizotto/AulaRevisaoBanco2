package org.example.entidades

import org.example.enumeradores.Material
import java.math.BigDecimal

class CaixaDAgua (

    val capacidade : Int,
    val cor: String,
    val material: Material,
    val interno: Boolean,
    val preco: BigDecimal,
    val peso: Double,
    val dimensao: Array<Double>,
    val marca: String,
    val tampa: Boolean
)
{

}