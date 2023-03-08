enablePlugins(JmhPlugin)

name := "scala3.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.2.2"
libraryDependencies ++= {
  val circeVersion = "0.14.4"
  val jsoniterVersion = "2.21.2"
  val upickleVersion = "2.0.0"
  val zioJsonVersion = "0.4.2"
  val sprayJsonVersion = "1.3.6"
  Seq(
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "dev.zio" %% "zio-json" % zioJsonVersion,
    "io.spray" %% "spray-json" % sprayJsonVersion,
    "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
}
parallelExecution := false
