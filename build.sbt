sbtPlugin := true

name := "js-tester-sbt"

organization := "novoda"

version <<= (sbtVersion) { (sv) =>
  val v = "0.0.1-SNAPSHOT"
  if(sv.startsWith("0.10")) "%s-%s" format(v,sv)
  else if(sv.startsWith("0.11")) v
  else error("unsupported version of sbt: %s" format sv)
}

libraryDependencies += "rhino" % "js" % "1.7R2"

publishMavenStyle := true

publishTo :=  Some(Resolver.file("novoda repo", new java.io.File("/var/www/repo")))

seq(ScriptedPlugin.scriptedSettings: _*)