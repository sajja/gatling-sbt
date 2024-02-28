//package computerdatabase
//
//import io.gatling.core.Predef._
//import io.gatling.http.Predef._
//
//import scala.concurrent.duration._
//import io.gatling.core.controller.inject.InjectionProfileFactory
//import io.gatling.core.controller.inject.open.OpenInjectionSupport
//import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
//
//class BasicSimulation1 extends Simulation {
//
//  val httpProtocol = http
////        .baseUrl("https://api-dev.pageroonline.com") // Here is the root for all relative URLs
//    .baseUrl("http://localhost:20863") // Here is the root for all relative URLs
//    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
//    .acceptEncodingHeader("gzip, deflate")
//    .acceptLanguageHeader("en-US,en;q=0.5")
//    .header("usertype", "admin")
//    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
//
//  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
//    .exec(http("request_1")
//      //      .get("/v1/users1?username=sajith.silva@pagero.com"))
//      //      .get("/v1/users?username=sajith.silva@pagero.com"))
//      .get("/jobs1"))
////      .get("/clearance/v1/jobs1"))
//
//
//  //  setUp(scn.inject(
//  //    atOnceUsers(1)
//  //  ).protocols(httpProtocol))
//  val builder = Config.Extensions(scn).injectDefaults
//  setUp(builder).protocols(httpProtocol)
//
//}
//
//object Config1 {
//  val LOAD_FACTOR: Double = 490
//  var RAMP_UP_TIME: Int = 10
//  val RAMP_USER_PER_SEC = 0.1
//
//  implicit class Extensions(val scenario: ScenarioBuilder) {
//    def injectDefaults: PopulationBuilder = scenario.inject(
//      rampUsersPerSec(RAMP_USER_PER_SEC) to LOAD_FACTOR during (RAMP_UP_TIME seconds),
//      constantUsersPerSec(LOAD_FACTOR) during (100 seconds)
//    )
//  }
//
//}