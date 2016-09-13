package net.atos.items

import net.atos.items.Items.{Apple, Orange}
import org.scalatest.FreeSpec

class ItemsTest extends FreeSpec {

  "Items cost" - {
    "Apple should cost 60" in {
      assert(Apple.price == 60)
    }

    "Orange should cost 25" in {
      assert(Orange.price == 25)
    }
  }

  "Parse items from list of" - {
    "empty items should return empty list." in {
      assert(Items.parseItems(Array("")).isEmpty)
    }

    "invalid items should return empty list." in {
      assert(Items.parseItems(Array("asdasd", "asdfasdasdacxxc", "zzzzzzzzzz")).isEmpty)
    }

    "invalid items and 2 valid items should return list of 2 items." in {
      assert(Items.parseItems(Array("asdasd", "asdfasdasdacxxc", "zzzzzzzzzz", "apple", "orange")).length == 2)
    }

    "3 mixed upper and lower case apples should return list of 3 apples" in {
      val items = Items.parseItems(Array("AppLE", "APPLE", "apple"))
      assert(items.length == 3)
      assert(items.forall(_ == Apple))
    }

    "3 mixed upper and lower case oranges should return list of 3 apples" in {
      val items = Items.parseItems(Array("OrANgE", "orange", "ORANGE"))
      assert(items.length == 3)
      assert(items.forall(_ == Orange))
    }

    "2 oranges and 1 apple should return list of 2 oranges and 1 apple" in {
      val items = Items.parseItems(Array("Orange", "Orange", "Apple"))
      assert(items.length == 3)
      assert(items.head == Orange)
      assert(items(1) == Orange)
      assert(items.last == Apple)
    }
  }
}
