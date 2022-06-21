package id.adeds.sharedmodulekmmlibs.domain.interactor.character

import id.adeds.sharedmodulekmmlibs.domain.interactor.FlowUseCase
import id.adeds.sharedmodulekmmlibs.domain.model.Character
import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class UpdateCharactersUseCase(
    private val repository: CharacterRepository,
    backgroundThread: CoroutineDispatcher
) : FlowUseCase<List<Character>, Character>(backgroundThread) {
    override suspend fun execute(params: Character?): Flow<List<Character>> {
        return if (params!=null)repository.updateCharacter(params)
        else throw UnsupportedOperationException("need character")
    }
}