package com.example.vkedu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getStringExtra(EXTRA_TEXT)
        setContent {
            MaterialTheme {
                SecondScreen(text)
            }
        }
    }

    companion object {
        private const val EXTRA_TEXT = "extra_text"

        fun newIntent(context: Context, text: String): Intent =
            Intent(context, SecondActivity::class.java).putExtra(EXTRA_TEXT, text)
    }
}

@Composable
fun SecondScreen(text: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (text.isNullOrBlank()) stringResource(R.string.error_no_data) else text,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}