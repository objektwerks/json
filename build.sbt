name := "scala.json"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.3"
libraryDependencies ++= {
  Seq(
    "com.typesafe.play" % "play-json_2.12" % "2.6.3",
    "io.circe" % "circe-parser_2.12" % "0.8.0",
    "io.circe" % "circe-generic_2.12" % "0.8.0",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
  )
}
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:reflectiveCalls",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-feature",
  "-Ywarn-unused-import",
  "-Ywarn-unused",
  "-Ywarn-dead-code",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings",
  "-Xlint:missing-interpolator",
  "-Xlint"
)
fork in test := true
javaOptions += "-server -Xss1m -Xmx2g"