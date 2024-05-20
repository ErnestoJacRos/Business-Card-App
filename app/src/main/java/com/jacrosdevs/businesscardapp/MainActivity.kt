package com.jacrosdevs.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jacrosdevs.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardAppTheme {
                        BusinessCardApp(
                            fullName = stringResource(R.string.name_text),
                            job = stringResource(R.string.job_text),
                            phone = stringResource(R.string.phone_text),
                            email = stringResource(R.string.email_text),
                            netWorking = stringResource(R.string.networking_text)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    fullName: String,
    job: String,
    phone: String,
    email: String,
    netWorking: String,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .background(Color.Magenta)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagecard),
                contentDescription = null
            )
            Text(
                text = fullName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = job,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Icon(imageVector = Icons.Filled.Call, contentDescription = "phone",
                        tint = Color.Black)
                    Spacer(modifier = Modifier.width(16.dp))
                    TextoContacto(textoContac = phone)
                }
                Row {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "networking",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    TextoContacto(textoContac = netWorking)
                }
                Row {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email",
                        tint = Color.Black)
                    Spacer(modifier = Modifier.width(16.dp))
                    TextoContacto(textoContac = email)
                }

            }
        }
    }
}

@Composable
fun TextoContacto(textoContac: String, modifier: Modifier = Modifier) {
    Text(
        text = textoContac,
        color = Color.Black,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp(
            fullName = stringResource(R.string.name_text),
            job = stringResource(R.string.job_text),
            phone = stringResource(R.string.phone_text),
            email = stringResource(R.string.email_text),
            netWorking = stringResource(R.string.networking_text)
        )
    }
}