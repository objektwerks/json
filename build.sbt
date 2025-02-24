enablePlugins(JmhPlugin)

name := "json"
organization := "objektwerks"
version := "0.3-SNAPSHOT"
scalaVersion := "3.6.4-RC1"
libraryDependencies ++= {
  val borerVersion = "1.15.0"
  val circeVersion = "0.14.10"
  val jsoniterVersion = "2.33.2"
  val upickleVersion = "4.1.0"
  val zioJsonVersion = "0.7.29"
  val sprayJsonVersion = "1.3.6"
  Seq(
    "io.bullet" %% "borer-core" % borerVersion,
    "io.bullet" %% "borer-derivation" % borerVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "dev.zio" %% "zio-json" % zioJsonVersion,
    "io.spray" %% "spray-json" % sprayJsonVersion,
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
parallelExecution := false
scalacOptions ++= Seq(
  "-Wunused:all"
)
