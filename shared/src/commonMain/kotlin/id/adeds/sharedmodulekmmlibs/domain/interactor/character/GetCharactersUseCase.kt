package id.adeds.sharedmodulekmmlibs.domain.interactor.character

import id.adeds.sharedmodulekmmlibs.domain.interactor.FlowUseCase
import id.adeds.sharedmodulekmmlibs.domain.model.Character
import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val repository: CharacterRepository,
    backgroundThread: CoroutineDispatcher
) : FlowUseCase<List<Character>, Unit>(backgroundThread) {
    override suspend fun execute(params: Unit?): Flow<List<Character>> =
        repository.getCharacter()
}