package id.adeds.sharedmodulekmmlibs.model

import id.adeds.sharedmodulekmmlibs.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

data class CharacterUiModel(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val gender: Gender,
    val origin: String,
    val location: String,
    val image: String,
    val isFavorite: Boolean,
)


fun Flow<List<Character>>.toUiModel(): Flow<List<CharacterUiModel>> = with(this) {
    map { list ->
        list.map {
            CharacterUiModel(
                id = it.id,
                name = it.name,
                status = it.status.toUiModel(),
                species = it.species,
                gender = it.gender.toUiModel(),
                origin = it.origin,
                location = it.location,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }
    }
}

fun CharacterUiModel.toDomainModel(): Character = with(this) {
    Character(
        id = id,
        name = name,
        status = status.toDomainModel(),
        species = species,
        gender = gender.toDomainModel(),
        origin = origin,
        location = location,
        image = image,
        isFavorite = isFavorite
    )
}


