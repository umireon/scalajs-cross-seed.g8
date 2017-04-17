lazy val root = project.in(file(".")).
  aggregate(helloJS, helloJVM).
  settings(
    publish := {},
    publishLocal := {},
    publishM2 := {}
  )

lazy val hello = crossProject.in(file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.1" % Test
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % Provided
    // Add JVM-specific settings here
  ).
  jsSettings(
    scalaJSUseMainModuleInitializer := true
    // Add JS-specific settings here
  )

lazy val helloJVM = hello.jvm
lazy val helloJS = hello.js
