lazy val commonSettings = Seq(
    name := """ergo-miner-calc""",
    organization := "portugal.ergo",
    version := "0.2.4",
    scalaVersion := "2.13.8"
)

lazy val myOptions = Seq(
    "-unchecked",
    "-deprecation",
    "-encoding", "utf-8",
    "-explaintypes",
    "-Wdead-code",
    "-Wextra-implicit",
    "-Wmacros:both",
    "-Wnumeric-widen",
    "-Woctal-literal",
    "-Xlint:implicit-recursion",
    "-Wunused:imports",
    "-Wunused:patvars",
    "-Wunused:privates",
    "-Wunused:locals",
    "-Wunused:explicits",
    "-Wunused:implicits",
    "-Wunused:params",
    "-Wunused:linted",
    "-Wvalue-discard"
)

lazy val myLibraries = Seq(
    "com.typesafe.play" %% "play-guice" % "2.8.16",
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
    "com.typesafe.play" %% "play-slick" % "5.0.2",
    "com.typesafe.play" %% "play-json" % "2.10.0-RC6",
    "mysql" % "mysql-connector-java" % "8.0.30"
)

lazy val root = (project in file("."))
    .enablePlugins(PlayScala)
    .enablePlugins(ScalaJSPlugin)
    .settings(
        commonSettings,
        libraryDependencies ++= myLibraries,
        libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.3.0",
        scalacOptions ++= myOptions
    )

scalaJSUseMainModuleInitializer := false