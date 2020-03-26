package bird.translator.tennisonline.domain.di.models

data class User(
    val id: Int? = null,
    val login: String,
    val password: String,
    val avatar_url: String? = null,
    var token: Token? = null
)