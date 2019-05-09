# Getting Started
Quick Demo project to show what Spring Boot 2.x WebFlux can do. Using simple example, it can be seen that with 1000 concurrent requests,
the WebFlux performs beyond traditional approach, this project is self contained and can be pulled and run anywhere

Commands:
./gradlew bootRun
./gradlew gatlingRun

This project also includes the wrong way to use WebFlux which pretty much nullifies its advantages


### Reference Documentation
For further reference, please consider the following sections:

Gatling Output for Normal API invocation VS Wrong Webflux API invocation VS Correct Webflux API invocation

Normal
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       1000 (OK=1000   KO=0     )
> min response time                                    588 (OK=588    KO=-     )
> max response time                                   3590 (OK=3590   KO=-     )
> mean response time                                  1943 (OK=1943   KO=-     )
> std deviation                                        642 (OK=642    KO=-     )
> response time 50th percentile                       1900 (OK=1900   KO=-     )
> response time 75th percentile                       2300 (OK=2301   KO=-     )
> response time 95th percentile                       3186 (OK=3186   KO=-     )
> response time 99th percentile                       3401 (OK=3401   KO=-     )
> mean requests/sec                                    200 (OK=200    KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                            15 (  2%)
> 800 ms < t < 1200 ms                                 112 ( 11%)
> t > 1200 ms                                          873 ( 87%)
> failed                                                 0 (  0%)
================================================================================


Wrong Webflux Usage
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       1000 (OK=1000   KO=0     )
> min response time                                    462 (OK=462    KO=-     )
> max response time                                   2352 (OK=2352   KO=-     )
> mean response time                                  1310 (OK=1310   KO=-     )
> std deviation                                        469 (OK=469    KO=-     )
> response time 50th percentile                       1335 (OK=1335   KO=-     )
> response time 75th percentile                       1727 (OK=1727   KO=-     )
> response time 95th percentile                       1976 (OK=1976   KO=-     )
> response time 99th percentile                       2039 (OK=2039   KO=-     )
> mean requests/sec                                    250 (OK=250    KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                           246 ( 25%)
> 800 ms < t < 1200 ms                                 143 ( 14%)
> t > 1200 ms                                          611 ( 61%)
> failed                                                 0 (  0%)
================================================================================



Correct Webflux Usage
================================================================================
---- Global Information --------------------------------------------------------
> request count                                       1000 (OK=1000   KO=0     )
> min response time                                    103 (OK=103    KO=-     )
> max response time                                    257 (OK=257    KO=-     )
> mean response time                                   155 (OK=155    KO=-     )
> std deviation                                         27 (OK=27     KO=-     )
> response time 50th percentile                        150 (OK=151    KO=-     )
> response time 75th percentile                        172 (OK=172    KO=-     )
> response time 95th percentile                        208 (OK=208    KO=-     )
> response time 99th percentile                        234 (OK=234    KO=-     )
> mean requests/sec                                333.333 (OK=333.333 KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                          1000 (100%)
> 800 ms < t < 1200 ms                                   0 (  0%)
> t > 1200 ms                                            0 (  0%)
> failed                                                 0 (  0%)
================================================================================



* [Official Gradle documentation](https://docs.gradle.org)

### Bonus
If you read the code thoroughly, I have also included a quick way to have gatling running side-by-side with SpringBoot


