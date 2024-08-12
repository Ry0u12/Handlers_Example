fun main() {
    // Lista de numeros a procesar
    val numbers = listOf(1, 2, 3, 4, 5)

    // Lista para almacenar los resultados de los hilos
    val results = mutableListOf<Int>()

    // Crear un objeto de bloqueo para sincronizar el acceso a la lista de resultados
    val lock = Object()

    // Crear y ejecutar un hilo para cada número
    val threads = numbers.map { number ->
        Thread {
            // Calcular el cuadrado del número
            val squared = number * number
            println("Número: $number, Cuadrado: $squared, Hilo: ${Thread.currentThread().name}")

            // Sincronizar el acceso a la lista de resultados
            synchronized(lock) {
                results.add(squared)
            }
        }
    }
    // Iniciar todos los hilos
    threads.forEach { it.start() }

    // Esperar a que todos los hilos terminen
    threads.forEach { it.join() }

    // Calcular la suma de todos los resultados
    val totalSum = results.sum()
    println("Suma total de los cuadrados: $totalSum")
}