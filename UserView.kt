package mvp

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView: MvpView {
    @SingleState
    fun ShowUser(user: GitHubUser)
}