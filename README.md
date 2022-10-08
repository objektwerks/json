Scala 3 Json
------------
>Feature tests and performance benchmarks across **4** Scala 3 json libraries:
1. Circe
2. Jsoniter
3. uPickle
4. ZioJson
>Borer, Play-Json and Scala-Json were removed due to ***no*** or ***poor*** Scala 3 support.

Test
----
1. sbt clean test

Benchmark
---------
>See objektwerks.Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu19.28+81-CA (build 19+36), **Scala 3.2.1-RC2**, Apple M1, 2020, 16GB
1. jsoniter - 0.108
2. circe - 0.181
3. ziojson - 0.372
4. upickle - 0.943
>Total time: 803 s (13:23), 10 warmups, 10 iterations, in microseconds, completed **2022.10.8**

>OpenJDK Runtime Environment Zulu18.30+11-CA (build 18.0.1+10), **Scala 3.2.0-RC2**, Apple M1, 2020, 16GB
1. jsoniter - 0.122
2. circe - 0.180
3. ziojson - 0.329
4. upickle - 1.003
>Total time: 803 s (13:23), 10 warmups, 10 iterations, in microseconds, completed **2022.7.27**

>OpenJDK Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), **Scala 2.13.7**, Apple M1, 2020, 16GB
1. sprayjson - 0.071
2. jsoniter - 0.126
3. borer - 0.138
4. circe - 0.164
5. upickle - 0.353
6. ziojson - 0.380
7. playjson - 1.250
>Total time: 1405s (23:25), 10 warmups, 10 iterations, in microseconds, completed **2021.12.12**
