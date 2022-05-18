enablePlugins(JmhPlugin)

name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.1.3-RC3"
libraryDependencies ++= {
  val circeVersion = "0.14.1"
  val jsoniterVersion = "2.13.22"
  val upickleVersion = "2.0.0"
  val zioJsonVersion = "0.3.0-RC8"
  Seq(
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "dev.zio" %% "zio-json" % zioJsonVersion,
    "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )
}