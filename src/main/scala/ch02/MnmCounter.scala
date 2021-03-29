package ch02

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, desc}

object MnmCounter {

  def main(args: Array[String]): Unit = {
    val session = SparkSession.builder().appName("M&M's Counter").getOrCreate()

    val input = args(0)

    val df = session.read.format("csv").option("header", "true").option("inferSchema", "true").load(input)
    df.show(5, false)

    val count = df.select("State", "Color", "Count")
      .groupBy("State", "Color").sum("Count").orderBy(desc("sum(Count)"))

    count.show(60)
    println(s"Total rows = ${df.count()}")
    println()

    val caCount = df.select("*").where(col("State") === "CA")
      .groupBy("State", "Color").sum("Count").orderBy(desc("sum(Count)"))
    caCount.show(10)

  }
}
