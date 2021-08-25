name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.6"
libraryDependencies ++= {
  val borerVersion = "1.7.2"
  val circeVersion = "0.14.1"
  val jsoniterVersion = "2.9.1"
  val playJsonVersion = "2.9.2"
  val upickleVersion = "1.4.0"
  val zioVersion = "1.0.11"
  val zioJsonVersion = "0.1.5"
  Seq(
    "io.bullet" %% "borer-core" % borerVersion,
    "io.bullet" %% "borer-derivation" % borerVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.typesafe.play" %% "play-json" % playJsonVersion,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-json" % zioJsonVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.5",
    "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )
}