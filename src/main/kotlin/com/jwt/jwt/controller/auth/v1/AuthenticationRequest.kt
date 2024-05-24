package com.jwt.jwt.controller.auth.v1

data class AuthenticationRequest(
    val email: String,
    val password: String
)