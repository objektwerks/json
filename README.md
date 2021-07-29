Scala Json
----------
>Scala json library tests:

1. Borer ( 37ms )
2. Circe ( 152ms )
3. Jsoniter ( 16ms )
4. Play Json ( 177ms )
5. uPickle ( 30ms )

>Note:
* Tests are similar, with UPicleTest being a bit more involved.
* Logging is used in all tests. 
* So performance numbers should not be taken too seriously.

Test
----
1. sbt clean test