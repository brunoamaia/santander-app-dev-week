package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Bruno Maia")
        val cartao = Cartao("1111 2222 3333 4444")
        return Conta (
            "1111111-1",
            "1234",
            "2.000,00",
            "3.000,00",
            cliente,
            cartao
        )
    }
}