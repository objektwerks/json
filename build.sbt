name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.2"
libraryDependencies ++= {
  Seq(
    "io.circe" %% "circe-parser" % "0.13.0",
    "io.circe" %% "circe-generic" % "0.13.0",
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.2.1",
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.2.1" % Provided,
    "com.typesafe.play" %% "play-json" % "2.8.1",
    "com.lihaoyi" %% "upickle" % "1.1.0",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
}