package cl.bootcamp.myapplication2

fun main() {
    // Solicitar al usuario que ingrese la edad
    println("Ingrese la edad de la persona:")
    val edad = readLine()?.toIntOrNull()

    // Verificar si la edad es válida
    if (edad == null || edad < 0 || edad > 100) {
        println("Error: Edad no válida. Por favor, ingrese una edad entre 0 y 100 años.")
        return
    }

    // Solicitar al usuario que ingrese el día de la semana
    println("Ingrese el día de la semana (lunes, martes, miércoles, jueves, viernes, sábado, domingo):")
    val dia = readLine()?.lowercase()

    // Calcular el precio de la entrada
    val precio = when {
        edad < 4 -> {
            println("Niños menores de 4 años no pagan entrada.")
            0 // Niños menores de 4 años no pagan
        }
        edad <= 15 -> {
            println("El precio de entrada para niños de 15 años o menos es de 15.000 CLP.")
            15000 // Niños de 15 años o menos
        }
        edad in 16..60 -> {
            var precioBase = 30000 // Adultos entre 16 y 60 años
            // Aplicar descuento si es lunes o martes
            if (dia == "lunes" || dia == "martes") {
                precioBase -= 5000
                println("Descuento aplicado: $ 5.000 CLP por ser $dia.")
            }
            println("El precio de entrada para adultos entre 16 y 60 años es de $ $precioBase CLP.")
            precioBase
        }
        else -> {
            println("El precio de entrada para adultos mayores de 60 años es de $20.000 CLP.")
            20000 // Adultos mayores de 60 años
        }
    }

    // Mostrar el precio final
    if (precio > 0) {
        println("El precio de entrada es:$ $precio CLP.")
    }
}