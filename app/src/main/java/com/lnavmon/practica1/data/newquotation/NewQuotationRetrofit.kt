package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.data.newquotation.model.QuotationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewQuotationRetrofit {

    @GET("api/1.0/?method=getQuote&format=json")
    suspend fun getQuotation(@Query("lang") lang: String): Response<QuotationDto>

}