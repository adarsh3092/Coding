package com.apache.spark.learning.core

import org.apache.spark.sql.SparkSession
import java.text.SimpleDateFormat
import java.sql.Date
import java.sql.Timestamp
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.first
/**Find the latest transaction for each cards.*/
object LeatestTransaction {
  
  case class CreditCardDetials(cardId: String, transitionId: String, dateTime: Timestamp)
  
  def main(args: Array[String]) {
    val spark = SparkSession.builder().master("local[2]").getOrCreate()
    import spark.implicits._

    val df = spark.sparkContext.parallelize(Seq(
      ("c1", "t1", Timestamp.valueOf("2018-12-12 11:00:00")),
      ("c1", "t3", Timestamp.valueOf("2018-12-12 09:08:00")), 
      ("c2", "t2", Timestamp.valueOf("2018-12-12 19:02:00")),
      ("c2", "t6", Timestamp.valueOf("2018-12-12 11:20:00"))), 8)
      .toDF("cid", "tid", "datetime")

    //    val c1=CreditCardDetials("c1","t1",Timestamp.valueOf("2018-12-12 11:00:00"))
    //    val c2=CreditCardDetials("c1","t21",Timestamp.valueOf("2018-12-12 01:00:00"))
    //    val c3=CreditCardDetials("c2","t2",Timestamp.valueOf("2018-12-12 19:02:00"))
    //    val c4=CreditCardDetials("c2","t3",Timestamp.valueOf("2018-12-12 11:20:00"))
    //    val listDitial=List(c1,c2,c3,c4)
    val window = Window.partitionBy("cid").orderBy($"datetime".desc)
    val cardWithLatestDF = df.withColumn("tmp", first("datetime").over(window)).select("*").where($"tmp" === $"datetime")
    cardWithLatestDF.show()

  }
}