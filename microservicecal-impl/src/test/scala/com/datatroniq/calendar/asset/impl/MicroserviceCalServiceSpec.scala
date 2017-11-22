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

    "create asset" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      val asset = com.datatroniq.calendar.asset.api.Asset(None, "name")

      client.createAsset().invoke(asset).map { response =>
        println(response)
        response.id.isDefined should be(true)
      }
    }
//   restCall(Method.PUT, "/api/asset/:id", updateAsset _),

    "query assets" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.getAllAssets.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

    "query entries" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.getEntries.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }





"query createAssetEntry" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.createAssetEntry.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

"query updateAssetEntry" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.updateAssetEntry.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

"query deleteAssetEntry" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.deleteAssetEntry.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }


"query getEntryExceptionsByEntry" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.getEntryExceptionsByEntry.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

"query entryExceptionCreate" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.entryExceptionCreate.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

"query deleteEntryException" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.deleteEntryException.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }

"query assetAvailability" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.assetAvailability.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }


"query assetAvailabilityFromTo" in ServiceTest.withServer(ServiceTest.defaultSetup.withCassandra(true)) { ctx =>
      new MicroserviceCalApplication(ctx) with LocalServiceLocator
    } { server =>
      val client = server.serviceClient.implement[MicroserviceCalService]
      client.assetAvailabilityFromTo.invoke().map { response =>
        println(response)
        response.length should be > 0
      }
    }
    
  }
}

