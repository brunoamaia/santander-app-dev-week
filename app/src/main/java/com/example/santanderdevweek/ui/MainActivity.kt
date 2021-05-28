package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta) {
        val nome: List<String> = conta.cliente.nome.split(" ")
        val digitosFinaisCartao: List<String> = conta.cartao.numeroCartao.split(" ")

        findViewById<TextView>(R.id.tv_user_greetings).text = "Olá, " + nome[0]
        findViewById<TextView>(R.id.tv_user_agency).text = "Ag " + conta.agencia
        findViewById<TextView>(R.id.tv_user_account).text = "CC " + conta.numero
        findViewById<TextView>(R.id.tv_user_agency).text = "Ag " + conta.agencia
        findViewById<TextView>(R.id.tv_saldo).text = "R$ " + conta.saldo
        findViewById<TextView>(R.id.tv_value_limit).text = "R$ " + conta.limite
        findViewById<TextView>(R.id.tv_value_final_digits).text = digitosFinaisCartao[3]
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("click", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
     */
}