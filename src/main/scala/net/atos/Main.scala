package net.atos

import net.atos.checkout.Checkout
import net.atos.items.Items

object Main {

  def main(args: Array[String]): Unit = {
    println(s"Welcome to the shop, you want to buy: ${args.mkString(", ")}")

    require(args.nonEmpty, "Not enough items to go through the checkout.")

    val items = Items.parseItems(args)

    require(items.nonEmpty, "You didn't buy any valid items.")

    val price = Checkout.purchase(items, true)

    println(s"Your total cost today is: $price")
  }

}
