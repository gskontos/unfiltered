description := "User-Agent request matchers"

unmanagedClasspath in (local("agents"), Test) <++=
  (fullClasspath in (local("specs2"), Compile),
   fullClasspath in (local("filter"), Compile)) map {
     (s, f) => s ++ f
   }

libraryDependencies <++= scalaVersion { v =>
  Seq(Common.servletApiDep) ++ Common.integrationTestDeps(v)
}
