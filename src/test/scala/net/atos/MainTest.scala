package net.atos

import org.scalatest.FreeSpec

class MainTest extends FreeSpec {

  "When main class is called with" - {
    "empty args " in {

      val caught = intercept[IllegalArgumentException] {
        Main.main(Array())
      }
      println(caught.getMessage)
      assert(caught.getMessage == "requirement failed: Not enough items to go through the checkout.")
    }

    "invalid args " in {

      val caught = intercept[IllegalArgumentException] {
        Main.main(Array("test"))
      }
      assert(caught.getMessage == "requirement failed: You didn't buy any valid items.")
    }

    "invalid args and valid args" in {
      Main.main(Array("ssdfx", "apple", "orange", "faasdasd"))
      succeed
    }

    "valid args" in {
      Main.main(Array("apple", "orange"))
      succeed
    }
  }
}
