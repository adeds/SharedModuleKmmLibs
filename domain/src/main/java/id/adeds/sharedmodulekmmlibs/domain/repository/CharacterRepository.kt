package id.adeds.sharedmodulekmmlibs.domain.repository

import id.adeds.sharedmodulekmmlibs.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacter(): Flow<List<Character>>
    suspend fun updateCharacter(character: Character): Flow<List<Character>>
}