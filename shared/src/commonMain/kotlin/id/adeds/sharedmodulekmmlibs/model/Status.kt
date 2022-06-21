package id.adeds.sharedmodulekmmlibs.model

sealed class Status(val value: String) {
    object ALIVE : Status("Alive")
    object DEAD : Status("Dead")
    object UNKNOWN : Status("Unknown")
}

fun id.adeds.sharedmodulekmmlibs.domain.model.Status.toUiModel() = with(this) {
    when(this){
        id.adeds.sharedmodulekmmlibs.domain.model.Status.ALIVE -> Status.ALIVE
        id.adeds.sharedmodulekmmlibs.domain.model.Status.DEAD -> Status.DEAD
        id.adeds.sharedmodulekmmlibs.domain.model.Status.UNKNOWN -> Status.UNKNOWN
    }
}

fun Status.toDomainModel() : id.adeds.sharedmodulekmmlibs.domain.model.Status = with(this) {
    when(this){
        Status.ALIVE -> id.adeds.sharedmodulekmmlibs.domain.model.Status.ALIVE
        Status.DEAD -> id.adeds.sharedmodulekmmlibs.domain.model.Status.DEAD
        Status.UNKNOWN -> id.adeds.sharedmodulekmmlibs.domain.model.Status.UNKNOWN
    }
}