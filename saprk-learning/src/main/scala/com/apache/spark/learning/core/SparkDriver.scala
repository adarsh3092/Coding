package com.apache.spark.learning.core

import org.apache.spark.sql.SparkSession

object SparkDriver {
  def main(str:Array[String]){
  val spark= SparkSession.builder().master("local[2]").getOrCreate()
  val broadCastvariible=spark.sparkContext.broadcast("adarsh")
  println(broadCastvariible.value)
  
  //spark.range(1, 12).show()
    
    println("Hello scala world!!")
  }
}