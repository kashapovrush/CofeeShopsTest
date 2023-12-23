package com.kashapovrush.cofeeshopstest.presentation.signInScreen

import com.kashapovrush.cofeeshopstest.data.model.User

sealed class AuthState {

    object Initial: AuthState()

    object NotAuthorized: AuthState()

    data class Authorized(val user: User): AuthState()
}
