package com.jwt.jwt.controller.user.v1

data class UserRequest(
    val email: String,
    val password: String
)
