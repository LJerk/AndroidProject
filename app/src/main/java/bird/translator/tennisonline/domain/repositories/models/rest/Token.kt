package bird.translator.tennisonline.domain.repositories.models.rest

data class Token(
    val access: String,
    val refresh: String
)