package com.dica.m4l2.domain.contract

import com.dica.m4l2.data.model.Account

interface AccountContract {
    interface View {
        //Отображение списка счетов
        fun showAccounts(accounts: List<Account>)

        //Отображение об ошибке
        fun showError(message: String)

        //Отображение об успехе
        fun showSuccess(message: String)
    }

    interface Presenter {
        //Загрузка списка счетов
        fun loadAccounts()

        //Добавление нового счета
        fun addAccount(name: String, balance: String, currency: String)

        //Удаление счета
        fun deleteAccount(accountId: String)

        //Обновление счета
        fun updateAccount(accountId: String, account: Account)

        //Обновление компанента
        fun updateAccountStatus(accountId: String, isActive: Boolean)
    }
}