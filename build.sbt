name := "ScissLib"

version := "1.0.1-SNAPSHOT"

organization := "de.sciss"

description := "A Java library covering GUI building, application framework, and audio file I/O"

homepage <<= name { n => Some(url("https://github.com/Sciss/" + n)) }

licenses := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt"))

scalaVersion := "2.11.4"

crossPaths       := false  // this is just a Java project

autoScalaLibrary := false  // this is just a Java project

// retrieveManaged  := true

// ---- publishing ----

publishMavenStyle := true

publishTo <<= version { v =>
  Some(if (v endsWith "-SNAPSHOT")
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra <<= name { n =>
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
  <developer>
    <id>sciss</id>
    <name>Hanns Holger Rutz</name>
    <url>http://www.sciss.de</url>
  </developer>
</developers>
}
