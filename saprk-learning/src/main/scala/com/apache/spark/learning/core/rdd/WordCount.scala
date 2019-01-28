package com.apache.spark.learning.core.rdd

import scala.io.Source
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
  def main(args:Array[String]){
    /*val stream=getClass.getResourceAsStream("/adarsh.txt")
    val lines=Source.fromInputStream(stream)
    println(lines.getLines().next())
  }*/
    val config=new SparkConf().setMaster("local").set("spark.serializer", "org.apache.spark.serializer.KryoSerializer").setAppName("my local app")
    val sc=new SparkContext(config)
    val readRDD=  sc.textFile("/Users/adarsh/Desktop/Coding/saprk-learning/src/resource/the_hindu.txt", 4)
    val pairRDD=readRDD.flatMap(x=>x.split(" ")).map(x=>(x,1))
    pairRDD.foreach(println)
    
  }
}