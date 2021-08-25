Scala Json
----------
>Tests:

1. Borer : 26ms
2. Circe : 122ms
3. Jsoniter : 17ms
4. PlayJson : 150ms
5. uPickle : 28ms
6. ZioJson : 147ms

>Note:
* Tests are similar, with UPicleTest being a bit more involved.
* Logging is used in all tests. 
* So performance numbers should ***not*** be taken ***too*** seriously.

Test
----
1. sbt clean test