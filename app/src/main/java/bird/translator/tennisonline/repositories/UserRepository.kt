package bird.translator.tennisonline.repositories

class UserRepository {

    fun registration(subscriber: (String) -> Unit, login: String, pass: String, mail: String) {
        subscriber.invoke("$login : $pass : $mail")
    }
}