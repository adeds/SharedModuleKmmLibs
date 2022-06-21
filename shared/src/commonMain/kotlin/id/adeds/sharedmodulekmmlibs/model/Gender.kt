package id.adeds.sharedmodulekmmlibs.model

sealed class Gender(val value: String) {
    object MALE : Gender("Male")
    object FEMALE : Gender("Female")
    object GENDERLESS : Gender("Genderless")
    object UNKNOWN : Gender("Unknown")
}

fun id.adeds.sharedmodulekmmlibs.domain.model.Gender.toUiModel(): Gender = with(this) {
    when (this) {
        id.adeds.sharedmodulekmmlibs.domain.model.Gender.FEMALE -> Gender.FEMALE
        id.adeds.sharedmodulekmmlibs.domain.model.Gender.MALE -> Gender.MALE
        id.adeds.sharedmodulekmmlibs.domain.model.Gender.GENDERLESS -> Gender.GENDERLESS
        id.adeds.sharedmodulekmmlibs.domain.model.Gender.UNKNOWN -> Gender.UNKNOWN
    }
}

fun Gender.toDomainModel(): id.adeds.sharedmodulekmmlibs.domain.model.Gender = with(this) {
    when (this) {
        Gender.FEMALE -> id.adeds.sharedmodulekmmlibs.domain.model.Gender.FEMALE
        Gender.MALE -> id.adeds.sharedmodulekmmlibs.domain.model.Gender.MALE
        Gender.GENDERLESS -> id.adeds.sharedmodulekmmlibs.domain.model.Gender.GENDERLESS
        Gender.UNKNOWN -> id.adeds.sharedmodulekmmlibs.domain.model.Gender.UNKNOWN
    }
}