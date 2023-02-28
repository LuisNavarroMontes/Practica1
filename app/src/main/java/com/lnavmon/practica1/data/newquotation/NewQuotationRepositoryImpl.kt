package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.iu.domain.model.Quotation
import javax.inject.Inject
import kotlin.random.Random

class NewQuotationRepositoryImpl @Inject constructor() : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return if (Random.nextDouble() < 0.9) {
            Result.success(getRandomQuotation())
        } else {
            Result.failure(Exception("Failed to get new quotation"))
        }
    }

    private fun getRandomQuotation(): Quotation {
        val num = (0..100).random()
        return Quotation(num.toString(), "Author $num", "Texto$num")
    }


}