package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper

data class UserDTO(
        val name: String = "",
        val firstName: String = "",
        val secondName: String = "",
        val id: Int = -1,
        val gender: String? = "",
        val email: String ="",
        val userName:String = "",
        val idRol : Int = -1

){
    companion object Instance: Hydratable<UserDTO> {
        override fun from(row: ResultSetWrapper): UserDTO {
            val email = row.getString("emailUser")
            val name = row.getString("name")
            val firstName = row.getString("firstLastName")
            val secondName = row.getString("secondLastName")
            val id = row.getInt("idUser")
            val gender = row.getString("gender")
            val idRol = row.getInt("idRol")
            val userName= row.getString("username")

            return UserDTO(
                    email = email,
                    name=name,
                    firstName = firstName,
                    secondName = secondName,
                    id = id,
                    gender = gender,
                    userName= userName,
                    idRol = idRol
            )
        }
    }
}