package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.utils.Utils.parseFullName
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar:String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = null,
    val isOnline:Boolean = false
) {
    constructor(id:String, firstName: String?,lastName: String?) : this(
        id=id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)

    constructor(id: String) :this(id, "John","Doe $id")

    init{
        println("It's alive!!! and his name is $firstName $lastName")
    }

   companion object Factory {
       private var lastId : Int = 1
       fun makeUser(fullName:String?) : User {
           lastId ++
           val (firstName,lastName) = Utils.parseFullName(fullName)
           when(fullName)
           {
               "" -> return User(id = "$lastId",firstName = null, lastName = null)
               " " -> return User(id = "$lastId",firstName = null, lastName = null)
           }
           return User(id = "$lastId",firstName = firstName,lastName = lastName)
       }
   }
}