package net.atos.checkout

import net.atos.items.Items.Item

object Checkout {

  def purchase(items: List[Item]): Int = {
    items.foldLeft(0)((totalPrice, nextItem) => totalPrice + nextItem.price)
  }
}
