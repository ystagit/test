package org.service.api


import akka.actor.ActorRef
import scala.concurrent.ExecutionContext
import spray.routing.Directives
import org.service.CoreActors
import spray.httpx.Json4sSupport
import org.json4s.{DefaultFormats, Formats}

object Json4sProtocol extends Json4sSupport {
  implicit def json4sFormats: Formats = DefaultFormats
}

/* Our case class, used for request and responses */
case class File(name: String)

class FileService(fileManipulations: ActorRef)(implicit executionContext: ExecutionContext)
  extends Directives {

  import org.service.FileActor._
  import Json4sProtocol._

  val route =
    path("addMailList") {
      post {
        handleWith { file: File => fileManipulations ! AddMailList(file); "{}" }
      }
    }~
    path("removeMailList") {
      post {
        handleWith { file: File => fileManipulations ! RemoveMailList(file); "{}" }
      }
    }
}
