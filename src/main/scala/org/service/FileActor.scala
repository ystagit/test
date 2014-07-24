package org.service

import api.File
import akka.actor.Actor

object FileActor {

  case class AddMailList(file: File)
  case class RemoveMailList(file: File)

}

class FileActor extends Actor {
  import FileActor._

  def receive = {
    case AddMailList(file) => {

      println("addMailList method " + file.name)

    }
    case RemoveMailList(file) => {

      println("removeMailList method " + file.name)

    }
  }
}
