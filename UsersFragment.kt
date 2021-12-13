package mvp

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import moxy.MvpAppCompatFragment
import moxy.ktx.MoxyKtxDelegate
import moxy.ktx.moxyPresenter
import kotlin.reflect.KProperty
import mvp.UsersFragment

class UsersFragment : MvpAppCompatFragment(R.layout.view_users), UsersView, UsersAdapter {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GithubUserRepositoryFactory.create(),
            router = router
        )
    }

    private val usersAdapter = UsersAdapter = UsersAdapter(this)
    private lateinit var viewBinding: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUsersBinding.bind(view)
        viewBinding.usersRecycler.adapter = usersAdapter

    }

    override fun showUsers(user: List<GithubUser>){
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GithubUser) =
        presenter.displayUser(user)

    companion object{

    }


}






