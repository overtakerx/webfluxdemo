import io.gatling.http.Predef._
import io.gatling.core.Predef._
class BasicSimulation extends Simulation {
  val httpConf = http.baseUrl("http://localhost:9090/")
  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get("wrongwebflux"))

  setUp(scn.inject(atOnceUsers(1000))).protocols(httpConf)
}