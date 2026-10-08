package com.example.vkedu

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var input by rememberSaveable { mutableStateOf("") }
    var errorRes by rememberSaveable { mutableStateOf<Int?>(null) }

    fun validatedText(): String? {
        val text = input.trim()
        if (text.isEmpty()) {
            errorRes = R.string.error_empty
            return null
        }
        return text
    }

    // 1. Явный Intent
    fun openSecond() {
        val text = validatedText() ?: return
        context.startActivity(SecondActivity.newIntent(context, text))
    }

    // 2. Неявный Intent (ACTION_DIAL не требует разрешения CALL_PHONE)
    fun callFriend() {
        val phone = normalizePhone(input)
        if (phone == null) {
            errorRes = R.string.error_invalid_phone
            return
        }
        context.startActivitySafely(Intent(Intent.ACTION_DIAL, "tel:$phone".toUri()))
    }

    // 3. Системный Intent (ACTION_SEND + chooser)
    @SuppressLint("LocalContextGetResourceValueCall")
    fun shareText() {
        val text = validatedText() ?: return
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivitySafely(
            Intent.createChooser(sendIntent, context.getString(R.string.share_title))
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = input,
            onValueChange = {
                input = it
                errorRes = null
            },
            label = { Text(stringResource(R.string.input_hint)) },
            isError = errorRes != null,
            supportingText = errorRes?.let { res -> { Text(stringResource(res)) } },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = ::openSecond, modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.open_second))
        }

        Spacer(Modifier.height(8.dp))
        Button(onClick = ::callFriend, modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.call_friend))
        }

        Spacer(Modifier.height(8.dp))
        Button(onClick = ::shareText, modifier = Modifier.fillMaxWidth()) {
            Text(stringResource(R.string.share_text))
        }
    }
}

private val PHONE_REGEX = Regex("^\\+?\\d{5,15}$")

/** Убирает пробелы, дефисы и скобки; возвращает номер или null, если формат неверный. */
private fun normalizePhone(input: String): String? {
    val cleaned = input.replace(Regex("[\\s\\-()]"), "")
    return cleaned.takeIf { PHONE_REGEX.matches(it) }
}

private fun Context.startActivitySafely(intent: Intent) {
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, R.string.error_no_app, Toast.LENGTH_SHORT).show()
    }
}