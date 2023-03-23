package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.data.newquotation.model.QuotationDto
import com.lnavmon.practica1.iu.domain.model.Quotation
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewQuotationDataSource {

    suspend fun getQuotation(language:String): Response<QuotationDto>
}