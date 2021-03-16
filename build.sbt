name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.5"
libraryDependencies ++= {
  val circeVersion = "0.13.0"
  val jsoniterVersion = "2.6.2"
  val playJsonVersion = "2.9.1"
  val upickleVersion = "1.2.2"
  Seq(
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
    "com.typesafe.play" %% "play-json" % playJsonVersion,
    "com.lihaoyi" %% "upickle" % upickleVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" %% "scalatest" % "3.2.6" % Test
  )
}
