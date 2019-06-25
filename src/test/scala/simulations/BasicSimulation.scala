package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class LoadSimulation extends Simulation {

  val standardEndpoint = "http://localhost:8081/standardendpoint"
  val reactiveEndpoint = "http://localhost:8082/reactiveendpoint"

  val myScenario = scenario("Webflux Demo").exec(
    repeat(30) {
      exec(
        http("request_1").get(reactiveEndpoint)
      ).pause(1 second, 2 seconds)
    }
  )
  setUp(myScenario.inject(rampUsers(3000).over(30 seconds)))
}
