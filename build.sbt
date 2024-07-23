enablePlugins(JmhPlugin)

name := "scala3.json"
organization := "objektwerks"
version := "0.2-SNAPSHOT"
scalaVersion := "3.5.0-RC5"
libraryDependencies ++= {
  val borerVersion = "1.14.1"
  val circeVersion = "0.14.9"
  val jsoniterVersion = "2.30.7"
  val upickleVersion = "4.0.0"
  val zioJsonVersion = "0.7.1"
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
