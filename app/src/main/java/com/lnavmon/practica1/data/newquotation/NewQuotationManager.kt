package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.iu.domain.model.Quotation


interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>
}