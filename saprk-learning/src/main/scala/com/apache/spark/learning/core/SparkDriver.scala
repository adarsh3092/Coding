package com.apache.spark.learning.core

import org.apache.spark.sql.SparkSession
import java.sql.Timestamp
import java.time.Month
import org.apache.spark.sql.functions.month
import org.apache.spark.sql.functions.countDistinct
import org.apache.spark.sql.functions.count
import org.apache.spark.sql.functions.max
import org.apache.spark.sql.functions.row_number

import org.apache.spark.sql.expressions.Window

object UserMaximumTripInEachMonth {
  def main(str: Array[String]) {
    val spark = SparkSession.builder().master("local[2]").getOrCreate()
    import spark.implicits._
    val seq = Seq(
      ("uesr1", "trip2", Timestamp.valueOf("2018-12-23 12:01:11")),
      ("uesr1", "trip1", Timestamp.valueOf("2018-12-10 02:01:11")),
      ("uesr2", "trip1", Timestamp.valueOf("2018-12-11 21:01:11")),
      ("uesr2", "trip1", Timestamp.valueOf("2018-11-09 21:01:11")),
      ("uesr2", "trip2", Timestamp.valueOf("2018-11-01 09:08:00")),
      ("uesr2", "trip1", Timestamp.valueOf("2018-10-17 19:28:00")),
      ("uesr1", "trip1", Timestamp.valueOf("2018-10-02 12:08:00")),
      ("uesr1", "trip1", Timestamp.valueOf("2018-10-12 15:38:00")),
      ("uesr2", "trip1", Timestamp.valueOf("2018-11-01 09:08:00")))
    //val
    val rdd = spark.sparkContext.parallelize(seq, 8)
    //Convert rdd to dataframe
    val tripsDF = rdd.toDF("user", "trip", "datetime")
    
   // val df = tripsDF.groupBy(month(tripsDF("datetime")), $"user").agg(count($"user")).orderBy("month(datetime)", "count(user)")
   // val window = Window.partitionBy("month(datetime)")
    
    val winForEachMonth = Window.partitionBy(month($"datetime"))
    val win = Window.partitionBy(month($"datetime"), $"user").orderBy(month($"datetime"))
    val countTripUsingWindow = tripsDF
      .withColumn("user_count", row_number().over(win))
      .withColumn("max_trip", max("user_count").over(winForEachMonth))
      .where($"user_count" === $"max_trip").show()
    //df.withColumn("max_tmp", max("count(user)").over(window)).where($"count(user)"===$"max_tmp").show
  }
}