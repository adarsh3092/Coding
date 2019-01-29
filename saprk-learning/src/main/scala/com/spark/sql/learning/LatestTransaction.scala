package com.spark.sql.learning

import org.apache.spark.sql.SparkSession
import java.sql.Timestamp

object LatestTransaction {
  def main(ags: Array[String]) {
    val spark = SparkSession.builder().master("local[2]").appName("Custome latest transaction").getOrCreate()
    import spark.implicits._
    val customerDF = Seq((111, "Adarsh", Timestamp.valueOf("2018-12-01 00:00:00")), (111, "Adarsh", Timestamp.valueOf("2018-12-01 00:01:00")),
      (111, "Adarsh", Timestamp.valueOf("2018-12-01 03:00:00")), (111, "Adarsh", Timestamp.valueOf("2018-12-01 03:00:00")),
      (112, "Aman", Timestamp.valueOf("2018-12-01 04:00:00")), (112, "Aman", Timestamp.valueOf("2018-12-01 11:00:00")), (111, "Adarsh", Timestamp.valueOf("2018-12-01 03:00:00")),
      (112,"Aman",Timestamp.valueOf("2018-12-01 13:04:00"))
    
    ).toDF("user","name","datetime")
    customerDF.registerTempTable("customers")
    spark.sql("select * from customers where user in (select min(datetime) from )")
  }

}