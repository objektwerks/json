Scala Json
----------
>Scala json library benchmark and common test.

Test
----
1. sbt clean test
>Performance in milliseconds:

1. Jsoniter : 13
2. SprayJson : 23
3. uPickle : 24
4. Borer : 25
5. Circe : 123
6. ZioJson : 132
7. PlayJson : 149

>The top 4 and bottom 3 json libraries form a 2-tier ecosystem, in terms of performance.

ScalaJs
-------
>Jsoniter, uPickle, Borer, Circe, ZioJson and PlayJson suport **ScalaJs**.

Benchmark
---------
1. sbt jmh:run