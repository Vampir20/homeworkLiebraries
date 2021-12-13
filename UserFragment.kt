package mvp

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(R.layout.view_user), UserView {
    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()

    }

    private val presenter: UsersPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
    }

    override fun showUser(user: GitHubUser){
        viewBinding.userLogin.text = user.login
    }

    companion object{
        private const val ARG_USER_LOGIN = "arg_user_login"
    }
}