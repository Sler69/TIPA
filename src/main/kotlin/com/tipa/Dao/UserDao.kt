package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.UserControllers.SaveUserController
import com.tipa.Controller.UserControllers.UserForm
import com.tipa.Dto.UserDTO
import com.tipa.TipaApp
import org.slf4j.LoggerFactory

internal var logger = LoggerFactory.getLogger(UserDao::class.java)
object UserDao{
    fun addUser(user: UserForm):Int{
        val query = """
                INSERT INTO Users (emailUser,username,name,firstLastName,secondLastName,password,gender)
                VALUES (?,?,?,?,?,?,?);
                     """
        return Database.Builder()
                    .statement(query)
                    .preparable{statement ->
                        statement.setString(1,user.email)
                        statement.setString(2,user.username)
                        statement.setString(3,user.name)
                        statement.setString(4,user.firstName)
                        statement.setString(5,user.secondName)
                        statement.setString(6,user.password)
                        statement.setString(7,user.gender)
                    }.onError{error->
                    logger.error ("There was an error while creating the user: \"$error\" ")
                }.execute()
    }

    fun verifyUsername(username:String):Boolean{

        val query = """
                SELECT COUNT(*) FROM Users WHERE username = ?
            """
        val lngUsernames =Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setString(1,username)
                }.onError{error->
                    logger.error("There was an error verifying the username: $username with error: $error")
                }.scalar<Any>()

        val foundUser = lngUsernames.orElse(0).equals(1);
        return foundUser;
    }

    fun getUserWithUsername(username: String,password:String):List<UserDTO>{
        val query = """
                SELECT * FROM Users WHERE username = ? AND password = ?
            """
        return  Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setString(1,username)
                    statement.setString(2,password)
                }.onError{error->
                    logger.error("There was an error retrieving the User with username :$username error :  $error")
                }.query(UserDTO)

    }

    fun verifyEmail(email:String):Boolean{
        val query = """
                SELECT COUNT(*) FROM Users WHERE email = ?
            """
        val lngUsernames =Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setString(1,email)
                }.onError{error->
                    logger.error("There was an error verifying the email: $email error : $error")
                }.scalar<Any>()

        val foundUser = lngUsernames.orElse(0).equals(1);
        return foundUser;
    }

    fun getUserWithEmail(email: String,password:String):List<UserDTO>{
        val query = """
                SELECT * FROM Users WHERE email = ? AND password = ?
            """
        return  Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setString(1,email)
                    statement.setString(2,password)
                }.onError{error->
                    logger.error("There was an error retrieving the User with email : \"$email\" error :  \"$error\"")
                }.query(UserDTO)

    }
}