package com.jwt.jwt.service

import com.jwt.jwt.model.User
import com.jwt.jwt.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {


    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if(found == null) {
            userRepository.save(user)
            user
        } else null
    }


    fun findById(id: UUID): User? =
        userRepository.findById(id)

    fun findAll(): List<User> =
        userRepository.findALl()

    fun deleteById(id: UUID): Boolean =
        userRepository.deleteById(id)

}