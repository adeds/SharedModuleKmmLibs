package id.adeds.sharedmodulekmmlibs.interactor.character

import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import id.adeds.sharedmodulekmmlibs.interactor.FlowUseCase
import id.adeds.sharedmodulekmmlibs.model.CharacterUiModel
import id.adeds.sharedmodulekmmlibs.model.toUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(
    private val repository: CharacterRepository,
    backgroundThread: CoroutineDispatcher
) : FlowUseCase<List<CharacterUiModel>, Unit>(backgroundThread) {
    override suspend fun execute(params: Unit?): Flow<List<CharacterUiModel>> =
        repository.getCharacter().toUiModel()
}