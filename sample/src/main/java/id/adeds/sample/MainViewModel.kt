package id.adeds.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.adeds.sharedmodulekmmlibs.interactor.character.GetCharactersUseCase
import id.adeds.sharedmodulekmmlibs.model.CharacterUiModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private val _characters = MutableLiveData<List<CharacterUiModel>>()
    val characters: LiveData<List<CharacterUiModel>>
        get() = _characters

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun getCharacter() {
        viewModelScope.launch {
            getCharactersUseCase()
                .catch { _error.postValue(it.message) }
                .collect {
                    _characters.postValue(it)
                }
        }
    }
}