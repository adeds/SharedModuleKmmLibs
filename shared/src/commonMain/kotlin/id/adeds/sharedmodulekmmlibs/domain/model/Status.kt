package id.adeds.sharedmodulekmmlibs.domain.model

sealed class Status(val value: String) {
    object ALIVE : Status("Alive")
    object DEAD : Status("Dead")
    object UNKNOWN : Status("Unknown")
}
