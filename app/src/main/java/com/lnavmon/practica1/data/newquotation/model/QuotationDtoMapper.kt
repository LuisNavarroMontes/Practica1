package com.lnavmon.practica1.data.newquotation.model

import com.lnavmon.practica1.iu.domain.model.Quotation
import okio.IOException
import retrofit2.Response

fun QuotationDto.toDomain() =
    Quotation(quoteLink, quoteAuthor, quoteText)
fun Response<QuotationDto>.toDomain() =
    if (isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())
