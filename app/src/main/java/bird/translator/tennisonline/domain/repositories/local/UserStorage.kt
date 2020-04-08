package bird.translator.tennisonline.domain.repositories.local

import android.media.session.MediaSession
import com.soft.eac.thedepartmentgl.domain.repositories.models.realm.TokenRealm
import com.soft.eac.thedepartmentgl.domain.repositories.models.realm.UserRealm
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User
import com.soft.eac.thedepartmentgl.domain.repositories.models.toBase
import com.soft.eac.thedepartmentgl.domain.repositories.models.toRealm
import io.realm.Realm
import javax.inject.Inject

class UserStorage {

    private var user: User? = null

    @Inject
    constructor()

    fun save(user: User) {
        this.user = user

        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                user.toRealm()?.let { realm.copyToRealmOrUpdate(it) }
            }
        }
    }

    fun save(token: MediaSession.Token) {
        user?.token = token

        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                it.where(UserRealm::class.java).findFirst()?.let {
                    it.token = token.toRealm()
                    realm.copyToRealmOrUpdate(it)
                }
            }
        }
    }

    fun dropCredentials() {
        user = null

        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                it.where(UserRealm::class.java).findAll().deleteAllFromRealm()
                it.where(TokenRealm::class.java).findAll().deleteAllFromRealm()
            }
        }
    }

    fun getUser(): User? {

        user?.let {
            return it
        }

        Realm.getDefaultInstance().use {
            return it.where(UserRealm::class.java).findFirst()?.toBase().apply { user = this }
        }
    }
}