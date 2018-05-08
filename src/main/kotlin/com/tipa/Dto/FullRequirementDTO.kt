package com.tipa.Dto

import Util.Database.Hydratable
import com.tipa.Util.DatabaseUtil.ResultSetWrapper
import java.util.*

data class FullRequirementDTO(
        val name:String = "",
        val id:UUID ,
        val lstFntPoints:List<FunctionPointDTO>
){

}