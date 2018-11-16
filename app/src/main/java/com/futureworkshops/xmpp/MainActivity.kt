package com.futureworkshops.xmpp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.futureworkshops.xmpp.Credentials.Companion.ARIS
import com.futureworkshops.xmpp.Credentials.Companion.IGOR
import com.futureworkshops.xmpp.Credentials.Companion.TEST
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MainActivity() : AppCompatActivity(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private lateinit var connectionManager: ConnectionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectionManager = ConnectionManager()


        arisLoginButton.setOnClickListener {
            login(ARIS)
        }

        testLoginButton.setOnClickListener {
            login(TEST)
        }

        igorLoginButton.setOnClickListener {
            login(IGOR)
        }

    }

    private fun login(credentials: Credentials) {
        launch {
            connectionManager.login(credentials)
        }
    }


}

