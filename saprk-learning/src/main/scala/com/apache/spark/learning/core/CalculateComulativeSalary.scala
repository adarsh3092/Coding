package com.apache.spark.learning.core

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.sum
object CalculateComulativeSalary {
  def main(args:Array[String]){
    /**
     * 
     */
    val spark= SparkSession.builder().master("local[2]").getOrCreate()
    val seq=Seq((1,1,200),(2,1,300),(2,2,400),(3,2,500),(1,2,500),(2,3,400),(3,3,300),(1,3,800),(2,3,300),(1,4,900),(3,4,100))
    val rdd=spark.sparkContext.parallelize(seq, 4)
    import spark.implicits._
   val df= rdd.toDF("id","month","salary")
    val window=Window.partitionBy("id").orderBy("month").rowsBetween(Long.MinValue,0)
    val windowDF=df.withColumn("tmp", sum(df.col("salary")).over(window))
    windowDF.show()
  }
}