package com.dica.m4l2.domain.contract

import com.dica.m4l2.data.model.Account

interface AccountContract {
    interface View{
        fun showAccounts(accounts:List<Account>)
        fun showError(message: String)
        fun showSuccess(message: String)
    }

    interface Presenter{
        fun loadAccounts()
        fun addAccount(name:String,balance:String,currency:String)
        fun deleteAccount(accountId:String)
        fun updateAccount(accountId: String,account: Account)
    }
}