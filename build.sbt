name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.9"
libraryDependencies ++= {
  Seq(
    "io.circe" %% "circe-parser" % "0.11.1",
    "io.circe" %% "circe-generic" % "0.11.1",
    "com.typesafe.play" %% "play-json" % "2.7.4",
    "com.lihaoyi" %% "upickle" % "0.7.5",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
}