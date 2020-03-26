package bird.translator.tennisonline.domain.di.components

import bird.translator.tennisonline.domain.di.modules.NetModule
import bird.translator.tennisonline.presentation.credentials.auth.AuthFragment
import bird.translator.tennisonline.presentation.credentials.loading.LoadingFragment
import bird.translator.tennisonline.presentation.credentials.registration.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
//    AppModule::class,
    NetModule::class
])
interface AppComponent {

    fun inject(target: RegistrationFragment)
    fun inject(target: AuthFragment)
    fun inject(target: LoadingFragment)
}