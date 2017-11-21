package com.datatroniq.calendar.asset.impl

import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}
import com.datatroniq.calendar.asset.api._

import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import org.scalatest.{AsyncWordSpec, Matchers}

class HelloServiceSpec extends AsyncWordSpec with Matchers {

  "MicroserviceCalService" should {
    "query assets" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.getAllAssets.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }



//   restCall(Method.GET, "/api/asset/:id", getAsset _),
//   restCall(Method.GET, "/api/assets",    getAllAssets _),
//   restCall(Method.GET, "/api/asset/:id/entries",    getEntries _),
//   restCall(Method.POST, "/api/asset", createAsset _),
//   restCall(Method.PUT, "/api/asset/:id", updateAsset _),
//   restCall(Method.DELETE, "/api/asset/:id", deleteAsset _),
//   restCall(Method.POST, "/api/asset/:id/entry", createAssetEntry _),
//   restCall(Method.PUT, "/api/asset/entry/:id", updateAssetEntry _),
//   restCall(Method.DELETE, "/api/asset/entry/:id", deleteAssetEntry _),

//   restCall(Method.GET, "/api/entry/:entry_id/exceptions", getEntryExceptionsByEntry _),
//   restCall(Method.POST, "/api/entry/exception", entryExceptionCreate _),        
//   restCall(Method.DELETE, "/api/entry/:entry_id/exception", deleteEntryException _),

//   restCall(Method.GET, "/api/asset/:assetId/availabilities", assetAvailability _),
//   restCall(Method.GET, "/api/asset/:assetId/availabilities_from/:from/:to", assetAvailabilityFromTo _)

  }
}

