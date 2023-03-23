package com.lnavmon.practica1.data.newquotation

import com.lnavmon.practica1.data.newquotation.model.toDomain
import com.lnavmon.practica1.data.utils.NoInternetException
import com.lnavmon.practica1.iu.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    private val dataSource: NewQuotationDataSource,
    private val connectivityChecker: ConnectivityChecker
    ) : NewQuotationRepository{
    override suspend fun getNewQuotation(language: String): Result<Quotation> {
        return if (connectivityChecker.isConnectionAvailable()) {
            val language = arrayOf("en", "es", "xx").random()
            val response = dataSource.getQuotation(language)
            return response.toDomain()
        } else {
            Result.failure(NoInternetException("No hay internet"))
        }
    }

}