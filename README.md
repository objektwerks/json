Json
----
>The purpose of this project is to test Scala json libraries:

1. Circe ( 2s )
2. Play Json ( 3.5s )
3. Upickle ( 60ms )

Test
----
1. sbt clean test

Bloop
-----
1. sbt bloopInstall
2. bloop clean scala-json
3. bloop compile scala-json
4. bloop test scala-json. ( After steps 1 - 3, typically only this step is required. )