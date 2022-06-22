package id.adeds.sharedmodulekmmlibs.data.remote

import id.adeds.sharedmodulekmmlibs.data.model.ApiCharactersResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

interface CharacterRemoteInterface {
    suspend fun getCharacter(): ApiCharactersResponse
}

class CharacterRemoteInterfaceImpl(
    private val httpClient: HttpClient
) : CharacterRemoteInterface {
    companion object {
        private const val BASER_URL = "https://rickandmortyapi.com/"
    }

    override suspend fun getCharacter(): ApiCharactersResponse =
        httpClient.get { apiUrl("/api/character") }.body()

    private fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(BASER_URL)
            encodedPath = path
        }
    }
}