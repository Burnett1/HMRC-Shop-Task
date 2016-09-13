package net.atos.checkout

import net.atos.items.Items.{Apple, Item, Orange}

object Offers {

  def applyOffers(items: List[Item]): List[Item] = {
    val appliedOffer1 = appleDiscount(items)
    orangeDiscount(appliedOffer1)
  }

  def appleDiscount(items: List[Item]): List[Item] = {
    val count = items.count(_ == Apple)
    val newAmount = (count / 2) + (count % 2)
    items.filterNot(_ == Apple) ++ List.fill(newAmount)(Apple)
  }

  def orangeDiscount(items: List[Item]): List[Item] = {
    val count = items.count(_ == Orange)
    val newAmount = ((count / 3) * 2) + (count % 3)
    items.filterNot(_ == Orange) ++ List.fill(newAmount)(Orange)
  }

}
