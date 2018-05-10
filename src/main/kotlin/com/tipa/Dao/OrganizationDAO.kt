package com.tipa.Dao

import Util.Database.Database
import com.tipa.Dto.OrganizationCountDTO
import com.tipa.Dto.OrganizationDTO

object OrganizationDAO{

    fun insertOrganization(organizationName: String,idUser: Int):Int {
        val query = """
                INSERT INTO Organizations (name,idUser)
                VALUES (?,?)
            """

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setString(1,organizationName)
                    statement.setInt(2,idUser)
                }.onError { error ->
                    logger.error("""There was an error creating the organizatin $organizationName with the user id $idUser
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }

    fun getOrganizationsOfUser(idUser: Int):List<OrganizationDTO>{
        val query = """
                SELECT * FROM Organizations
                WHERE idUser = ?
            """
        return Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setInt(1,idUser)
                }.onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list of organizations for the user id: $idUser
                        | Error: $error
                    """.trimMargin())
                }.query(OrganizationDTO)
    }

    fun getOrganizationOfUserCout(idUser:Int):List<OrganizationCountDTO>{
        val query = """
        SELECT *
        FROM Organizations  O
        LEFT OUTER JOIN (SELECT  idOrganizacion,count(*) as cnt
                     FROM Projects
                    GROUP BY idOrganizacion) P ON O.idOrganization = P.idOrganizacion
        WHERE O.idUser = ?
        """.trimIndent()
        return Database.Builder()
                .statement(query)
                .preparable{statement ->
                    statement.setInt(1,idUser)
                }.onError{error ->
                    logger.error("""There wasa an erro on retrivieng the list of organizations for the user id: $idUser
                        | Error: $error
                    """.trimMargin())
                }.query(OrganizationCountDTO)
    }

    fun updateOrganizationName(idOrganization:Int,organizationName: String):Int{
        val query = """
                UPDATE Organizations
                SET name = ?
                WHERE idOrganization = ?
            """

        return Database.Builder()
                .statement(query)
                .preparable { statement ->
                    statement.setString(1,organizationName)
                    statement.setInt(2,idOrganization)
                }.onError { error ->
                    logger.error("""There was an error when updating the organizatin $organizationName with the user id $idOrganization
                        | Error: $error
                    """.trimMargin())
                }.execute()
    }
}