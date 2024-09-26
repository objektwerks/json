Json
----
>Feature tests and performance benchmarks against **6** Scala 3 json libraries:
1. Circe
2. Jsoniter
3. uPickle
4. Zio-Json
5. Spray-Json ( readded on 2022.12.4 )
6. Borer ( readded 2023.11.26 )
>**Note**, Spray-Json ***does not*** provide a ***type discriminator***!

Test
----
1. sbt clean test

Benchmark
---------
>See objektwerks.Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu23.28+85-CA (build 23+37), **Scala 3.5.1**, Apple M1, 2020, 16GB
1. spray-json - 0.051
2. jsoniter - 0.127
3. circe - 0.182
4. borer - 0.194
5. zio-json - 0.245
6. upickle - 0.424
>Total time: 1206 s (20:06), 10 warmups, 10 iterations, average time in microseconds, completed **2024.9.26**

>OpenJDK Runtime Environment Zulu22.30+13-CA (build 22.0.1+8), **Scala 3.5.0-RC4**, Apple M1, 2020, 16GB
1. spray-json - 0.051
2. jsoniter - 0.127
3. circe - 0.182
4. borer - 0.194
5. zio-json - 0.245
6. upickle - 0.424 ( upgrade to 4.0.0 yields a time of: 0.423 [2024.7.23] )
>Total time: 1206 s (20:06), 10 warmups, 10 iterations, average time in microseconds, completed **2024.7.16**

>OpenJDK Runtime Environment Zulu21.30+15-CA (build 21.0.1+12-LTS), **Scala 3.3.1**, Apple M1, 2020, 16GB
1. spray-json - 0.062
2. jsoniter - 0.143
3. circe - 0.165
4. borer - 0.194
5. zio-json - 0.264
6. upickle - 0.458
>Total time: 1203 s (20:03), 10 warmups, 10 iterations, average time in microseconds, completed **2023.11.26**

>OpenJDK Runtime Environment Zulu21.28+85-CA (build 21+35), **Scala 3.3.1**, Apple M1, 2020, 16GB
1. spray-json - 0.062
2. jsoniter - 0.143
3. circe - 0.175
4. zio-json - 0.264
5. upickle - 0.467
>Total time: 1003 s (16:43), 10 warmups, 10 iterations, average time in microseconds, completed **2023.9.20**

>OpenJDK Runtime Environment Zulu20.30+11-CA (build 20.0.1+9), **Scala 3.3.0**, Apple M1, 2020, 16GB
1. spray-json - 0.068
2. jsoniter - 0.139
3. circe - 0.174
4. zio-json - 0.330
5. upickle - 0.406
>Total time: 1003 s (16:43), 10 warmups, 10 iterations, average time in microseconds, completed **2023.7.29**

>OpenJDK Runtime Environment Zulu20.28+85-CA (build 20+36), **Scala 3.2.2**, Apple M1, 2020, 16GB
1. spray-json - 0.069
2. jsoniter - 0.123
3. circe - 0.137
4. zio-json - 0.271
5. upickle - 0.393
>Total time: 1003 s (16:43), 10 warmups, 10 iterations, average time in microseconds, completed **2023.3.25**

>OpenJDK Runtime Environment Zulu19.30+11-CA (build 19.0.1+10), **Scala 3.2.1**, Apple M1, 2020, 16GB
1. spray-json - 0.067
2. jsoniter - 0.114
3. circe - 0.177
4. zio-json - 0.365
5. upickle - 0.929
>Total time: 1003 s (16:43), 10 warmups, 10 iterations, average time in microseconds, completed **2023.1.10**

>OpenJDK Runtime Environment Zulu19.28+81-CA (build 19+36), **Scala 3.2.1-RC2**, Apple M1, 2020, 16GB
1. jsoniter - 0.108
2. circe - 0.181
3. zio-json - 0.372
4. upickle - 0.943
>Total time: 803 s (13:23), 10 warmups, 10 iterations, average time in microseconds, completed **2022.10.8**

>OpenJDK Runtime Environment Zulu18.30+11-CA (build 18.0.1+10), **Scala 3.2.0-RC2**, Apple M1, 2020, 16GB
1. jsoniter - 0.122
2. circe - 0.180
3. zio-json - 0.329
4. upickle - 1.003
>Total time: 803 s (13:23), 10 warmups, 10 iterations, average time in microseconds, completed **2022.7.27**

>OpenJDK Runtime Environment Zulu17.30+51-CA (build 17.0.1+12-LTS), **Scala 2.13.7**, Apple M1, 2020, 16GB
1. spray-json - 0.071
2. jsoniter - 0.126
3. borer - 0.138
4. circe - 0.164
5. upickle - 0.353
6. zio-json - 0.380
7. play-json - 1.250
>Total time: 1405s (23:25), 10 warmups, 10 iterations, average time in microseconds, completed **2021.12.12**