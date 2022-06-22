package id.adeds.sharedmodulekmmlibs.domain.model

sealed class Gender(val value: String) {
    object MALE : Gender("Male")
    object FEMALE : Gender("Female")
    object GENDERLESS : Gender("Genderless")
    object UNKNOWN : Gender("Unknown")
}