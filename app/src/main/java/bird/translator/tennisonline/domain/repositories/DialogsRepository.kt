package bird.translator.tennisonline.domain.repositories

import bird.translator.tennisonline.domain.repositories.models.DialogItem
import java.util.*
import javax.inject.Inject

class DialogsRepository {

    @Inject
    constructor()

    fun loadDialogs(call: (List<DialogItem>) -> Unit) {

        val result = mutableListOf<DialogItem>()
        val random = Random(System.currentTimeMillis())
        val count = random.nextInt(900) + 100
        for (index in 0 until count)
            result.add(DialogItem("Title: $index", random.nextBoolean()))

        call(result)
    }
}