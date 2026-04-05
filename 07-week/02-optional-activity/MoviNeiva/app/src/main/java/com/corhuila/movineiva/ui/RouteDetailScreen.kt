package com.corhuila.movineiva.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corhuila.movineiva.model.RouteRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteDetailScreen(routeId: String, onBack: () -> Unit) {
    val route = RouteRepository.routes.find { it.id == routeId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de Ruta ${route?.lineNumber ?: ""}", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1B3A6B))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (route != null) {
                Text(text = route.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Tarifa: $${route.fare}", fontSize = 18.sp)
                Text(text = "Frecuencia: cada ${route.frequency} min", fontSize = 18.sp)
                Text(text = "Tipo: ${route.serviceType}", fontSize = 18.sp)
            } else {
                Text(text = "Ruta no encontrada")
            }
        }
    }
}
