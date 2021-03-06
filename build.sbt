lazy val root = (project in file(".")).settings(
  name := "spark-kafka",
  organization := "com.tresata",
  version := "0.9.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.10.6", "2.11.8"),
  javacOptions ++= Seq("-Xlint:unchecked", "-source", "1.7", "-target", "1.7"),
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-target:jvm-1.7"),
  libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-api" % "1.7.5" % "compile",
    "org.apache.kafka" %% "kafka" % "0.8.2.1" % "compile"
      exclude("org.jboss.netty", "netty")
      exclude("com.sun.jmx", "jmxri")
      exclude("com.sun.jdmk", "jmxtools")
      exclude("javax.jms", "jms")
      exclude("javax.mail", "mail")
      exclude("jline", "jline"),
    "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
    "org.slf4j" % "slf4j-log4j12" % "1.7.5" % "test",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  ),
  publishMavenStyle := true,
  pomIncludeRepository := { x => false },
  publishArtifact in Test := false,
  publishTo := {
        val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  credentials += Credentials(Path.userHome / ".m2" / "credentials_sonatype"),
  pomExtra := (
    <url>https://github.com/tresata/spark-kafka</url>
        <licenses>
      <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      <comments>A business-friendly OSS license</comments>
      </license>
      </licenses>
      <scm>
      <url>git@github.com:tresata/spark-kafka.git</url>
      <connection>scm:git:git@github.com:tresata/spark-kafka.git</connection>
      </scm>
      <developers>
      <developer>
      <id>koertkuipers</id>
      <name>Koert Kuipers</name>
      <url>https://github.com/koertkuipers</url>
        </developer>
      </developers>)
)
