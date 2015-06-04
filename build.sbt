name := """sample"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

//lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	"org.elasticsearch" % "elasticsearch" % "1.5.0",
	"mysql" % "mysql-connector-java" % "5.1.6",
//	"org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",

  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
