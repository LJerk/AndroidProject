package bird.translator.tennisonline.misc.dialogs

import android.content.Context
import android.util.AttributeSet
import kotlinx.android.synthetic.main.view_dialog_type_2.view.*

class Type2View @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ABaseView(context, attrs, defStyleAttr), ITypeView {

    override fun getViewId(): Int = R.layout.view_dialog_type_2

    override fun bind(data: DialogItem) {
        tvTitle.text = data.title
    }
}