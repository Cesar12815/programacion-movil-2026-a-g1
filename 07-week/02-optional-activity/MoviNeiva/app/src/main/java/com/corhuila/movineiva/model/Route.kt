package com.corhuila.movineiva.model

data class Route(
    val id: String,
    val name: String,
    val lineNumber: String,
    val color: String,
    val fare: Double,
    val frequency: Int,
    val serviceType: String
)

object RouteRepository {
    val routes = listOf(
        Route("1", "Ruta 10 - Comuna 1", "10", "#E11D48", 2400.0, 15, "Urbano"),
        Route("2", "Ruta 20 - Oriente", "20", "#2563EB", 2400.0, 20, "Colectivo"),
        Route("3", "Ruta 50 - Sur", "50", "#16A34A", 2400.0, 12, "Urbano")
    )
}
