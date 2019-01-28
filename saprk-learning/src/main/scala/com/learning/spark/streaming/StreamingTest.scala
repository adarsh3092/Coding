package com.learning.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel

object StreamingTest {
  def updateState(newValue: Seq[(Int)], runningCurrrentvalue: Option[(Int)]): Option[(Int)] = {
    var reslt: Option[(Int)] = null
    if (newValue.isEmpty) {
      reslt = Some(runningCurrrentvalue.get)
      reslt
    } else {
      newValue.foreach(x => {
        if (runningCurrrentvalue.isEmpty)
          reslt = Some(x)
        else
          reslt = Some(x + runningCurrrentvalue.get)
        reslt
      })
    }
    reslt
  }
  def main(args: Array[String]) {
    val confg = new SparkConf().setMaster("local[8]").setAppName("learning streaming application")
    val sc = new SparkContext(confg)
    val ssc = new StreamingContext(sc, Seconds(3))
    ssc.checkpoint("/Users/adarsh/Desktop")
    
    val sparkRDD = ssc.socketTextStream("localhost", 9999, StorageLevel.MEMORY_ONLY)
      .flatMap(x => x.split(" "))
      .map(x => (x, 1)).reduceByKey(_ + _)
     // sparkRDD.print()
    val updatedRDD = sparkRDD.updateStateByKey(updateState)
  updatedRDD.print()
    ssc.start()
    ssc.awaitTermination()
  }
}