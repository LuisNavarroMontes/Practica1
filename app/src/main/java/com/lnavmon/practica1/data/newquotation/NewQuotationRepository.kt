package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.iu.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation(): Result<Quotation>
}