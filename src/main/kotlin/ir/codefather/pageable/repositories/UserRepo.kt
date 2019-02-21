package ir.codefather.pageable.repositories

import ir.codefather.pageable.Models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User, Long>