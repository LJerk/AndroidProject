package bird.translator.tennisonline.domain.repositories.local

import bird.translator.tennisonline.domain.di.models.Token
import bird.translator.tennisonline.domain.di.models.User
import javax.inject.Inject

class UserStorage {

    var user: User? = null
        private set

    @Inject
    constructor()

    fun save(user: User) {
        this.user = user
    }

    fun save(token: Token) {
        user?.token = token
    }

    fun dropCredentials() {
        user = null
    }
}