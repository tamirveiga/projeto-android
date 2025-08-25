package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                TelaConfiguracoes()
            }
        }
    }
}

@Composable
fun TelaConfiguracoes() {
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Color(0xFF0D1117),
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF0D1117)) {
                val items = listOf(
                    Icons.Default.Home to "Início",
                    Icons.Default.Search to "Buscar",
                    Icons.Default.Person to "Spaces",      // substituto do Spaces
                    Icons.Default.Notifications to "Notificações",
                    Icons.Default.Email to "Mensagens",
                    Icons.Default.Person to "Amigos"       // substituto do Group
                )

                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                item.first,
                                contentDescription = item.second,
                                tint = if (selectedItem == index) Color.White else Color.Gray
                            )
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            // Header
            HeaderConfig()

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de opções
            ItemConfig("Sua conta")
            ItemConfig("Monetização")
            ItemConfig("Premium")
            ItemConfig("Assinaturas do Criador")
            ItemConfig("Segurança e acesso à conta")
            ItemConfig("Privacidade e segurança")
            ItemConfig("Notificações")
            ItemConfig("Acessibilidade, exibição e idiomas")
            ItemConfig("Recursos adicionais")
            ItemConfig("Central de Ajuda")
        }
    }
}

@Composable
fun HeaderConfig() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Voltar",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Configurações",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )
    }
}

@Composable
fun ItemConfig(texto: String) {
    Card(
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { /* ação ao clicar */ },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.ArrowForward,
                contentDescription = "Ir",
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaConfiguracoes() {
    MyApplicationTheme {
        TelaConfiguracoes()
    }
}