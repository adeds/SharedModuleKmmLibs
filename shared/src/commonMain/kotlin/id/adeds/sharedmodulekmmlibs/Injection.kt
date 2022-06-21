package id.adeds.sharedmodulekmmlibs

import id.adeds.sharedmodulekmmlibs.data.remote.CharacterRemoteInterface
import id.adeds.sharedmodulekmmlibs.data.remote.CharacterRemoteInterfaceImpl
import id.adeds.sharedmodulekmmlibs.data.repository.CharacterRepositoryImpl
import id.adeds.sharedmodulekmmlibs.interactor.character.GetCharactersUseCase
import id.adeds.sharedmodulekmmlibs.domain.repository.CharacterRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    modules(
        baseModule,
        clientModule,
        remoteModule,
        repoModule,
        useCaseModule
    )
    appDeclaration()
}

val baseModule = module {
    single { Dispatchers.Default }
}

val clientModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }
}
val remoteModule: Module = module {
    single<CharacterRemoteInterface> { CharacterRemoteInterfaceImpl(get()) }
}

val repoModule: Module = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}

val useCaseModule: Module = module {
    single { GetCharactersUseCase(get(), get()) }
}

