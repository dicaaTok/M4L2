package com.dica.m4l2.data.model

data class Account(
    val id: String? = null,
    val name: String,
    val balance: String,
    val currency: String,
    val isActive: Boolean
)