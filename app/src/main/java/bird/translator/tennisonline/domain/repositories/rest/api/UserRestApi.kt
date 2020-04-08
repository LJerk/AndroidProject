package bird.translator.tennisonline.domain.repositories.rest.api

import bird.translator.tennisonline.base.ABaseRestApi
import bird.translator.tennisonline.base.IRestClient
import bird.translator.tennisonline.domain.repositories.models.rest.User
import bird.translator.tennisonline.domain.di.modules.NetModule
import bird.translator.tennisonline.domain.repositories.rest.service.IUserRestApiService
import javax.inject.Inject
import javax.inject.Named

class UserRestApi : ABaseRestApi<IUserRestApiService> {


    @Inject
    constructor(@Named(NetModule.NAME_AUTH_REST_CLIENT) client: IRestClient) : super(client)


    fun registration(login: String, password: String)
            = service.registration(
        User(
            login = login,
            password = password
        )
    )


    fun login(login: String, password: String)
            = service.login(
        User(
            login = login,
            password = password
        )
    )


    fun refreshToken(refreshToken: String)
            = service.refreshToken(refreshToken)
}