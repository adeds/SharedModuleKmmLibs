package id.adeds.sharedmodulekmmlibs.interactor.character

import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import id.adeds.sharedmodulekmmlibs.interactor.FlowUseCase
import id.adeds.sharedmodulekmmlibs.model.CharacterUiModel
import id.adeds.sharedmodulekmmlibs.model.toDomainModel
import id.adeds.sharedmodulekmmlibs.model.toUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class UpdateCharactersUseCase(
    private val repository: CharacterRepository,
    backgroundThread: CoroutineDispatcher
) : FlowUseCase<List<CharacterUiModel>, CharacterUiModel>(backgroundThread) {
    override suspend fun execute(params: CharacterUiModel?): Flow<List<CharacterUiModel>> {
        return if (params != null) repository.updateCharacter(params.toDomainModel()).toUiModel()
        else throw UnsupportedOperationException("need character")
    }
}