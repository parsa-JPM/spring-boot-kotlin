package ir.codefather.pageable.controllers

import ir.codefather.pageable.Models.User
import ir.codefather.pageable.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class KotlinController(@Autowired val userRepo: UserRepo) {


    @RequestMapping("/kotlin")
    @ResponseBody
    fun test(): List<User> {
        for (i in 1..50) {
            val user = User()
            user.name = "test-$i"
            userRepo.save(user)
        }

        val userPage = getUsersPages(0, 5)

        println(userPage.totalPages)

        return userPage.content
    }


    fun getUsersPages(page: Int, limit: Int): Page<User> {
        val pageable = PageRequest.of(page, limit)
        return userRepo.findAll(pageable)
    }
}