package com.apache.spark.streaming.examples

import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import kafka.server.KafkaConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.sql.types.StringType
import org.apache.spark.SparkConf
import kafka.serializer.StringDecoder


object KafkaStreaming {
  def main(args:Array[String]){
    val conf=new SparkConf().setMaster("local[2]").setAppName("Spark Streaming App")
    val ssc=new StreamingContext(conf,Seconds(2))
    val topics=Set("test")
    val kafkaParams=Map("metadata.broker.list"->"localhost:9092")
    val kafkaStream=KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](ssc, kafkaParams, topics) 
    val streamData= kafkaStream.map(x=>x._2)
        .flatMap(x=>x.split(" "))
          .map(x=>(x,1))
                .reduceByKey((x,y)=>x+y)
    streamData.print()
    ssc.start()
    ssc.awaitTermination()
    
  }
}
  