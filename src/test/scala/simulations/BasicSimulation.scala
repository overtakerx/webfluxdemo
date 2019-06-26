package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class LoadSimulation extends Simulation {

  val standardEndpoint = "http://localhost:8081/standardendpoint"
  val reactiveEndpoint = "http://localhost:8082/reactiveendpoint"
  val wrongReactiveEndpoint = "http://localhost:8082/wrongreactiveendpoint"
  val callableEndpoint = "http://localhost:8083/callableendpoint"
  val deferredendpoint = "http://localhost:8084/deferredendpoint"


  val scn = scenario("Webflux Demo").exec(
    repeat(30) {
      exec(
        http("request_1").get(deferredendpoint)
      ).pause(1 second, 2 seconds)
    }
  )
  setUp(scn.inject(rampUsers(100).over(30 seconds)))
}
