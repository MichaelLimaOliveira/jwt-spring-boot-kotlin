package com.jwt.jwt.repository

import com.jwt.jwt.model.Role
import com.jwt.jwt.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(private val encoder: PasswordEncoder) {

    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            email = "email-1@gmail.com.br",
            password = encoder.encode( "pass1"),
            role = Role.USER
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-2@gmail.com.br",
            password = encoder.encode( "pass2"),
            role = Role.USER
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-3@gmail.com.br",
            password = encoder.encode( "pass3"),
            role = Role.ADMIN
        )
    )


    fun save(user: User): Boolean  {
        val updated = user.copy(password = encoder.encode(user.password))
        return users.add(updated)
    }

    fun findByEmail(email: String): User? =
        users.firstOrNull {it.email == email}

    fun findALl(): List<User> = users

    fun findById(id: UUID): User? =
        users.firstOrNull {it.id == id}

    fun deleteById(id: UUID): Boolean {
        val foundUser = findById(id)

        return foundUser?.let {
            users.remove(it)
        } ?: false
    }
}