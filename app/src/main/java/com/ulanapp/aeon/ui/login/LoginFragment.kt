package com.ulanapp.aeon.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.aeon.R
import com.ulanapp.aeon.data.actions.APILoginActionImpl
import com.ulanapp.aeon.ui.payments.PaymentsFragment
import com.ulanapp.aeon.utils.showMessage
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var login: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login = view.findViewById(R.id.et_login)
        password = view.findViewById(R.id.et_password)

        val apiLoginAction = APILoginActionImpl()

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory(apiLoginAction))
            .get(LoginViewModel::class.java)

        handleClickLogin(view)
    }

    private fun handleClickLogin(view: View) {
        btn_login.setOnClickListener {
            when {
                isEmpty(login) && isEmpty(password) -> {
                    view.showMessage(resources.getString(R.string.enter_login_and_password))
                }
                isEmpty(login) -> {
                    view.showMessage(resources.getString(R.string.enter_login))
                }
                isEmpty(password) -> {
                    view.showMessage(resources.getString(R.string.enter_password))
                }
                else -> {
                    doSuccessLogin(view)
                }
            }
        }
    }

    private fun isEmpty(text: EditText): Boolean {
        val str: CharSequence = text.text.toString()
        return TextUtils.isEmpty(str)
    }

    private fun doSuccessLogin(view: View) {
        loginViewModel.doLogin(login.text.toString(), password.text.toString()).observe(
            viewLifecycleOwner, {
                try {
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, PaymentsFragment.newInstance(it.response.token))
                        .commit()

                } catch (e: Exception) {
                    view.showMessage(resources.getString(R.string.error_login))
                }
            })
    }
}