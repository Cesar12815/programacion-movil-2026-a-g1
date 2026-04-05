package com.corhuila.movineiva.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corhuila.movineiva.model.Route
import com.corhuila.movineiva.model.RouteRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onRouteClick: (String) -> Unit) {
    val routes = RouteRepository.routes

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "🚌 MoviNeiva",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Transporte urbano de Neiva",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B3A6B),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F7FA))
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "📍", fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = "Rutas disponibles", fontWeight = FontWeight.Bold, color = Color(0xFF1B3A6B))
                        Text(text = "${routes.size} líneas activas en Neiva", fontSize = 13.sp, color = Color(0xFF64748B))
                    }
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(routes) { route ->
                    RouteCard(route = route, onClick = { onRouteClick(route.id) })
                }
            }
        }
    }
}

@Composable
fun RouteCard(route: Route, onClick: () -> Unit) {
    val routeColor = try { Color(android.graphics.Color.parseColor(route.color)) } catch (e: Exception) { Color(0xFF1B3A6B) }
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(52.dp).clip(CircleShape).background(routeColor), contentAlignment = Alignment.Center) {
                Text(text = route.lineNumber, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = route.name, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(0xFF1E293B))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(text = "💰 $${String.format("%,.0f", route.fare)}", fontSize = 13.sp, color = Color(0xFF64748B))
                }
            }
            Text(text = "›", fontSize = 24.sp, color = Color(0xFF94A3B8))
        }
    }
}
