class Persona (dni: String,){
    var DNI = dni
        set(value){
            if(value.length==9){
                field = value
            }else{
                println("Los datos introducidos no pertenecen a un DNI")
            }
        }
        get(){
            return field
        }

    var listaCuentas = mutableListOf<Cuenta>()
        set(value){
            if (value.size>=maxCuentas){
                field = value
            }else{
                println("Valor máximo alcanzado")
            }
        }
        get(){
            return field
        }
    var maxCuentas = 8

    init {
        if (listaCuentas.size <= maxCuentas){
            this.listaCuentas = listaCuentas
        }
    }
    var listaMorosos = mutableListOf<Cuenta>()

    fun add_cuenta(cuentaInicial: kotlin.collections.MutableList<Cuenta>){
        if (listaCuentas.size != maxCuentas){
            for (cuentaActual in cuentaInicial) {
                println("Escriba el número de la nueva cuenta:")
                val nuevoNumero = readln().toInt()
                println("Escriba el saldo que tendrá dicha cuenta:")
                val nuevoSaldo = readln().toInt()
                val nuevaCuenta = Cuenta(nuevoNumero,nuevoSaldo)
                listaCuentas.add(nuevaCuenta)
            }
        }else{
            println("Ha alcanzado el número máximo de cuentas")
        }
    }

    fun comprobar_morosidad(){
        for (cuenta in listaMorosos){
            if (cuenta.saldo >0){
                listaMorosos.remove(cuenta)
            }
        }
        println("Estas son las cuentas de los morosos: $listaMorosos")
    }

    fun recibir_dinero(){

    }
    fun menu_usuario(){
        println("1) Recibir dinero de otra de sus cuentas \n2) Transferir dinero a otra de sus cuentas \n3) Crear una nueva cuenta \n4) Ver lista de morosos")
        var opcion = readln().toInt()
        when(opcion){
            1->{

            }
        }
    }
}
