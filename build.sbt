name := "load-test-service"
description := "Load test"
enablePlugins(GatlingPlugin)

scalaVersion := "2.13.8"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")
//enablePlugins(ServicePlugin)
val gatlingVersion = "3.7.4"

lazy val akkaVersion = "2.6.18"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test,it"
libraryDependencies += "io.gatling" % "gatling-test-framework" % gatlingVersion % "test,it"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.googlecode.flyway" % "flyway-core" % "2.3.1"
//  "com.pagero.paysol.formats" %% "paysol-internal-format" % "1.184.1-GO",
//  "com.pagero" %% "paysol-domain-jboss" % "1.266.1-GO"
)

// Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-cloud
// Enterprise Self-Hosted configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-self-hosted
