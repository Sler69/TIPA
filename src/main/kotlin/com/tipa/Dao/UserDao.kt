package com.tipa.Dao

import Util.Database.Database
import com.tipa.Controller.UserControllers.UserForm
import com.tipa.TipaApp

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
                    TipaApp.logger.error { "There was an error with : \"$error\" " }
                }.execute()
    }
}