package com.pogos.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.pogos.shoppinglist.data.ShopListRepositoryImpl
import com.pogos.shoppinglist.domain.DeleteShopItemUseCase
import com.pogos.shoppinglist.domain.EditShopItemUseCase
import com.pogos.shoppinglist.domain.GetShopListUseCase
import com.pogos.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
