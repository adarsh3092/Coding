package com.spark.sql.learning

import org.apache.spark.sql.SparkSession
import scala.collection.mutable.ListBuffer
import java.sql.Timestamp
import scala.util.Random
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

object FillTheMissTempratureValues {
  def main(args: Array[String]) {
     val spark= SparkSession.builder().master("local[3]").appName("Fill missing temprature").getOrCreate()
      import spark.implicits._
     val secondsPerHourses=(1 to 3600).toDF("seconds")
     val randomNum=new Random
    var list=ListBuffer.empty[(Timestamp,Int)]
    var dateTimeString = "2019-02-12 11"
    /** Ganrate the time seires */
    for (i <- 0 to 59) {
           val tmp=dateTimeString
      if (i / 10 == 0)
        dateTimeString += ":" + "0" + i
      else
        dateTimeString += ":" + i
      for (j <- 0 to 59 by 9) {
        val tmp2=dateTimeString
        if (j / 10 == 0) {
          dateTimeString += ":" + "0" + j
        } else {
          dateTimeString+= ":" + j

        }
         list+=((Timestamp.valueOf(dateTimeString),randomNum.nextInt(45)))
        //println(dateTimeString)
        dateTimeString=tmp2
      }
           dateTimeString=tmp

    }
    val df=list.toDF("time","tmp")
   val (minp,maxp) = df.select(min("time").cast("bigint"),max("time").cast("bigint")).as[(Long,Long)].first()
    val rangeDF=spark.range(minp, maxp, 1).select($"id".cast("timestamp").alias("time"))
    val df_with_missingval=rangeDF.join(df, Seq("time"), "leftouter")
    // df_with_missingval.na.fill(0).show
     df_with_missingval.withColumn("filled_col", last("tmp",true).over(Window.orderBy("time").rowsBetween(-100000, 0))).show
    //println(list.toDF())
   // val index = dateTimeString.substring(dateTimeString.indexOf(":") + 1, dateTimeString.lastIndexOf(":"))
    //println(index)
    //println(dateTimeString.replace(index, "01"))
  }
}