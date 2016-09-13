package net.atos.checkout

import net.atos.items.Items.{Apple, Orange}
import org.scalatest.FreeSpec

class CheckoutTest extends FreeSpec {

  "Empty list should return 0" in {
    assert(Checkout.purchase(List.empty) == 0)
  }

  "Purchasing a list of " - {
    "1 orange should return 25" in {
      assert(Checkout.purchase(List(Orange)) == 25)
    }
    "3 oranges should return 75" in {
      assert(Checkout.purchase(List(Orange, Orange, Orange)) == 75)
    }

    "1 apple should return 60" in {
      assert(Checkout.purchase(List(Apple)) == 60)
    }

    "3 apple should return 180" in {
      assert(Checkout.purchase(List(Apple, Apple, Apple)) == 180)
    }

    "1 apple and 1 orange should return 85" in {
      assert(Checkout.purchase(List(Apple, Orange)) == 85)
    }

    "3 apple and 2 orange should return 230" in {
      assert(Checkout.purchase(List(Apple, Apple, Apple, Orange, Orange)) == 230)
    }
  }
}
