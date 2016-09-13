package net.atos.items

object Items {

  sealed trait Item {
    val price: Int
  }

  case object Apple extends Item {
    val price = 60
  }

  case object Orange extends Item {
    val price = 25
  }

  private def makeItem(item: String): Option[Item] = {
    item.toLowerCase match {
      case "apple"  =>  Some(Apple)
      case "orange" =>  Some(Orange)
      case _        =>  None
    }
  }

  def parseItems(args: Array[String]): List[Item] = {
    args.toList.flatMap(makeItem)
  }
}

