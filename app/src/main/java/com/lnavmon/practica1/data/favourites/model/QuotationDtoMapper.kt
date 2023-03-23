package com.lnavmon.practica1.data.favourites.model

import com.lnavmon.practica1.iu.domain.model.Quotation

fun QuotationDto.toDomain(): Quotation {
    return Quotation(
        identificador = this.identificador,
        nombre = this.nombre,
        autor = this.autor
    )
}

fun Quotation.toDto(): QuotationDto {
    return QuotationDto(
        identificador = this.identificador,
        nombre = this.nombre,
        autor = this.autor
    )
}