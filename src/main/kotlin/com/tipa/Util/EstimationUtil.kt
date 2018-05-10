package com.tipa.Util

import com.tipa.Dto.EstimateHistoryDTO
import com.tipa.Dto.FunctionPointDTO
import com.tipa.Dto.MultipliersDTO
import com.tipa.Dto.ScaleFactorsDTO


object EstimationUtil{
    fun getUFP(funtionPoints:List<FunctionPointDTO>):Int{
        var ufp = 0
        funtionPoints.forEach{fntPnt ->
            if(fntPnt.tipoFuncion.equals("Entrada Externa/Peticion Externa")){
                ufp += calculateEI_EQ(fntPnt)
            }else if(fntPnt.tipoFuncion.equals("Salida Externa")){
                ufp += calculateE0(fntPnt)
            }else if(fntPnt.tipoFuncion.equals("Archivos Logicos Internos")){
                ufp += calculateILF(fntPnt)
            }else if(fntPnt.tipoFuncion.equals("Archivos Logicos Externos")){
                ufp += calculateEIF(fntPnt)
            }else{
                ufp+=0
            }

        }
        return ufp
    }

    fun getMultipliersResult(multi:MultipliersDTO):Float{
        var multiPliersResult = (multi.analyst * multi.applicationExp * multi.complexity * multi.continuity
                * multi.dataCost *multi.documentation *multi.execution * multi.languageExp * multi.multisiteDev *
                multi.platformExp * multi.programmer * multi.reusability * multi.schedule *
                multi.softwareReliability * multi.storage * multi.useSoftware * multi.volatility )
        return multiPliersResult
    }

    fun getScaleFactorsResult(scaleFactor:ScaleFactorsDTO):Float{
        var result = scaleFactor.architecture + scaleFactor.cohesion +scaleFactor.development + scaleFactor.maturity + scaleFactor.precedentedness
        return result
    }

    fun getDeviationEstimationTime(oldEstimates:List<EstimateHistoryDTO>):Float{
        var median =0.0f
        val lengthList = oldEstimates.size
        oldEstimates.forEach{estimate ->
            median += estimate.estimateTime
        }

        median /= lengthList

        var sumDistanceMedian = 0.0

        oldEstimates.forEach{estimate ->
            val valueOfRest = estimate.estimateTime - median
            sumDistanceMedian += Math.pow(valueOfRest.toDouble(),2.0)
        }

        val valueForSqrt = sumDistanceMedian/lengthList

        return Math.sqrt(valueForSqrt.toDouble()).toFloat()
    }


    fun getDeviationEstimationTeam(oldEstimates:List<EstimateHistoryDTO>):Float{
        var median =0.0f
        val lengthList = oldEstimates.size
        oldEstimates.forEach{estimate ->
            median += estimate.estimateTeamSize
        }

        median /= lengthList

        var sumDistanceMedian = 0.0

        oldEstimates.forEach{estimate ->
            val valueOfRest = estimate.estimateTeamSize - median
            sumDistanceMedian += Math.pow(valueOfRest.toDouble(),2.0)
        }

        val valueForSqrt = sumDistanceMedian/lengthList

        return Math.sqrt(valueForSqrt.toDouble()).toFloat()
    }

    internal fun calculateEI_EQ(fntPnt:FunctionPointDTO):Int{

        if((fntPnt.intEntities in 0..2) && (fntPnt.intAtributes in 1..4)){
            return 3
        }else if(fntPnt.intEntities>2 && fntPnt.intAtributes in 1..4){
            return 4
        }else if((fntPnt.intEntities in 0..1) && (fntPnt.intAtributes in 5..15)){
            return 3
        }else if((fntPnt.intEntities ==2) && (fntPnt.intAtributes in 5..15)){
            return 4
        }else if((fntPnt.intEntities > 2) && (fntPnt.intAtributes in 5..15)){
            return 6
        }else if((fntPnt.intEntities in 0..1) && (fntPnt.intAtributes > 15)){
            return 4
        }else if((fntPnt.intEntities >= 2) && (fntPnt.intAtributes > 15)){
            return 6
        }else {
            return 0
        }
    }


    internal fun calculateE0(fntPnt:FunctionPointDTO):Int{
        if((fntPnt.intEntities in 0..2) && (fntPnt.intAtributes in 1..4)){
            return 4
        }else if(fntPnt.intEntities>2 && fntPnt.intAtributes in 1..4){
            return 5
        }else if((fntPnt.intEntities in 0..1) && (fntPnt.intAtributes in 5..15)){
            return 4
        }else if((fntPnt.intEntities ==2) && (fntPnt.intAtributes in 5..15)){
            return 5
        }else if((fntPnt.intEntities > 2) && (fntPnt.intAtributes in 5..15)){
            return 7
        }else if((fntPnt.intEntities in 0..1) && (fntPnt.intAtributes > 15)){
            return 5
        }else if((fntPnt.intEntities >= 2) && (fntPnt.intAtributes > 15)){
            return 7
        }else {
            return 0
        }
    }

    internal fun calculateILF(fntPnt:FunctionPointDTO):Int{
        if((fntPnt.intEntities in 1..5) && (fntPnt.intAtributes in 1..19)){
            return 7
        }else if(fntPnt.intEntities>5 && fntPnt.intAtributes in 1..19){
            return 10
        }else if((fntPnt.intEntities ==1) && (fntPnt.intAtributes in 20..50)){
            return 7
        }else if((fntPnt.intEntities in 2..5) && (fntPnt.intAtributes in 20..50)){
            return 10
        }else if((fntPnt.intEntities > 5) && (fntPnt.intAtributes in 20..50)){
            return 15
        }else if((fntPnt.intEntities ==1) && (fntPnt.intAtributes > 50)){
            return 10
        }else if((fntPnt.intEntities >= 2) && (fntPnt.intAtributes > 15)){
            return 15
        }else {
            return 0
        }
    }


    internal fun calculateEIF(fntPnt:FunctionPointDTO):Int{
        if((fntPnt.intEntities in 1..5) && (fntPnt.intAtributes in 1..19)){
            return 5
        }else if(fntPnt.intEntities>5 && fntPnt.intAtributes in 1..19){
            return 7
        }else if((fntPnt.intEntities ==1) && (fntPnt.intAtributes in 20..50)){
            return 5
        }else if((fntPnt.intEntities in 2..5) && (fntPnt.intAtributes in 20..50)){
            return 7
        }else if((fntPnt.intEntities > 5) && (fntPnt.intAtributes in 20..50)){
            return 10
        }else if((fntPnt.intEntities ==1) && (fntPnt.intAtributes > 50)){
            return 7
        }else if((fntPnt.intEntities >= 2) && (fntPnt.intAtributes > 15)){
            return 10
        }else {
            return 0
        }
    }
}