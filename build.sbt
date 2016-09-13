lazy val shop = (project in file(".")).settings(
  name := "hmrc-shop-exercise",
  scalaVersion := "2.11.7",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)
