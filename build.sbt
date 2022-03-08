ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.25"

lazy val root = (project in file("."))
  .settings(
    name := "Project0"
  )
