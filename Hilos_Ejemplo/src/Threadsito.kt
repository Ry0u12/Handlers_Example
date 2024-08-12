class Threadsito: Thread()
{
    override fun run() {
        // Código a ejecutar en el hilo
        for (i in 1..5) {
            println("Hilo ejecutándose: $i")
            sleep(500)
        }
    }
}