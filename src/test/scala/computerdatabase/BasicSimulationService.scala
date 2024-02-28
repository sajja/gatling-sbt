package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._

import scala.concurrent.duration._

class BasicSimulation extends Simulation {
  val httpProtocol = http
    .baseUrl("http://www.google.com") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/"))
  //  setUp(scn.inject(
  //    atOnceUsers(1)
  //  ).protocols(httpProtocol))
  val builder = Config.Extensions(scn).injectDefaults
  setUp(builder).protocols(httpProtocol)

}

object Config {
  val LOAD_FACTOR: Double = 50
  var RAMP_UP_TIME: Int = 10
  val RAMP_USER_PER_SEC = 0.1

  implicit class Extensions(val scenario: ScenarioBuilder) {
    def injectDefaults: PopulationBuilder = scenario.inject(
      rampUsersPerSec(RAMP_USER_PER_SEC) to LOAD_FACTOR during (RAMP_UP_TIME seconds),
      constantUsersPerSec(LOAD_FACTOR) during (100 seconds)
    )
  }
}
