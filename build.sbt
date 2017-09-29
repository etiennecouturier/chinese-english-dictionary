import sbt.Keys.libraryDependencies

name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  jdbc,
  guice,
  evolutions,
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

//libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.44"


javaOptions in Test += "-Dconfig.file=conf/application.test.conf"

