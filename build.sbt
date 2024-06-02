enablePlugins(JmhPlugin)

name := "scala3.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.5.0-RC1"
libraryDependencies ++= {
  val borerVersion = "1.14.0"
  val circeVersion = "0.14.6"
  val jsoniterVersion = "2.30.1"
  val upickleVersion = "3.3.1"
  val zioJsonVersion = "0.6.2"
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
    "org.scalatest" %% "scalatest" % "3.2.18" % Test
  )
}
parallelExecution := false
scalacOptions ++= Seq(
  "-Wunused:all"
)
