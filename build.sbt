name := "learning-spark"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.12" % "3.1.1",
  "org.apache.spark" % "spark-sql_2.12"  % "3.1.1"
)