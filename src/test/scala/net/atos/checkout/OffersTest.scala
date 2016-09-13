package net.atos.checkout

import net.atos.items.Items.{Apple, Orange}
import org.scalatest.FreeSpec

class OffersTest extends FreeSpec {

  "Orange offer" - {

    "should return list of 3 oranges when buying 4" in {
      val oranges = List(Orange, Orange, Orange, Orange)
      assert(Offers.orangeDiscount(oranges) == List(Orange, Orange, Orange))
    }

    "should return list of 5 oranges when buying 7" in {
      val oranges = List(Orange, Orange, Orange, Orange, Orange, Orange, Orange)
      assert(Offers.orangeDiscount(oranges) == List(Orange, Orange, Orange, Orange, Orange))
    }

    "should return list of 3 oranges and 2 apples when buying 7 oranges and 2 apples" in {
      val oranges = List(Orange, Orange, Orange, Orange, Orange, Orange, Orange, Apple, Apple)
      assert(Offers.orangeDiscount(oranges) == List(Apple, Apple, Orange, Orange, Orange, Orange, Orange))
    }
  }

  "Apple offer" - {
    "should return list of 2 apples when buying 4" in {
      val apples = List(Apple, Apple, Apple, Apple)
      assert(Offers.appleDiscount(apples) == List(Apple, Apple))
    }

    "should return list of 5 apples when buying 9" in {
      val apples = List(Apple, Apple, Apple, Apple, Apple, Apple, Apple, Apple, Apple)
      assert(Offers.appleDiscount(apples) == List(Apple, Apple, Apple, Apple, Apple))
    }

    "should return list of 2 apples and 2 oranges when buying 4 apples and 2 oranges" in {
      val apples = List(Apple, Apple, Apple, Apple, Orange, Orange)
      assert(Offers.appleDiscount(apples) == List(Orange, Orange, Apple, Apple))
    }
  }
}
