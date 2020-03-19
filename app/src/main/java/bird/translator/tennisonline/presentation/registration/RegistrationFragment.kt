package bird.translator.tennisonline.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import bird.translator.tennisonline.R
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_registration.*
import bird.translator.tennisonline.presentation.authorization.AuthorizationFragment

class RegistrationFragment : MvpAppCompatFragment(), IRegistrationView {

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            presenter.registration("${etLogin.text}", "${etPassword.text}","${etMail.text}")
        }

    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}