package id.adeds.sharedmodulekmmlibs.data.repository

import id.adeds.sharedmodulekmmlibs.data.model.toDomain
import id.adeds.sharedmodulekmmlibs.data.remote.CharacterRemoteInterface
import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import id.adeds.sharedmodulekmmlibs.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    private val remoteInterface: CharacterRemoteInterface,
) : CharacterRepository {
    override suspend fun getCharacter(): Flow<List<Character>> {
        return flow { emit(remoteInterface.getCharacter().toDomain()) }
    }

    override suspend fun updateCharacter(character: Character): Flow<List<Character>> {
        // todo: implement after local storage implemented
        return flow { emit(emptyList()) }
    }

}