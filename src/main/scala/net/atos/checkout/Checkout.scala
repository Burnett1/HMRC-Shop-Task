package net.atos.checkout

import net.atos.items.Items.Item

object Checkout {

  def purchase(items: List[Item], withOffers: Boolean): Int = {
    val itemsWithOffers = if (withOffers) Offers.applyOffers(items) else items
    itemsWithOffers.foldLeft(0)((totalPrice, nextItem) => totalPrice + nextItem.price)
  }
}
