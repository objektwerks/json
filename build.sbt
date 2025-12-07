enablePlugins(JmhPlugin)

name := "json"
organization := "objektwerks"
version := "1.0.0"
scalaVersion := "3.8.0-RC3"
libraryDependencies ++= {
  val borerVersion = "1.16.2"
  val circeVersion = "0.14.15"
  val jsoniterVersion = "2.38.5"
  val upickleVersion = "4.4.2-RC2"
  val zioJsonVersion = "0.7.45"
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
