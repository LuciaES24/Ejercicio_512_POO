class Cuenta (numero :Int, cantidad :Int) {
    var numero_cuenta = numero
        set(value){
            if (numero_cuenta<9999 && numero_cuenta>0){
                field = value
            }else{
                println("El número de cuenta no puede tener esas cacracterísticas")
            }
        }
        get():Int{
            return field
        }
    var saldo = cantidad
    var cuenta = 0

    companion object{
        var contador = 21000001
        fun mostrarContador() :Int{
            return contador
        }
    }

    init {
        cuenta = contador
        Cuenta.contador ++
    }
    constructor(otraCuenta: Cuenta): this(otraCuenta.numero_cuenta,otraCuenta.saldo){
    }

    fun consultar_saldo(){
        println("Escriba el número de la cuenta de la que quiere consultar el saldo:")
        var numero_consulta = readln().toInt()
        if (numero_consulta == numero_cuenta){
            println("Su saldo es $saldo")
        }else{
            println("La cuenta que ha introducido no está disponible")
        }
    }

    fun enviar_dinero_ajeno(){
        println("Escriba el número de la cuenta que va a realizar el pago:")
        var numero_consulta = readln().toInt()
        println("Escriba el número de la cuenta que va a recibir el abono:")
        var numero_recibir = readln().toInt()
        if (numero_consulta == numero_cuenta){
            println("Escriba el dinero que quiere enviar:")
            var dinero_enviar = readln().toInt()
            saldo-= dinero_enviar
            println("¡Envío realizado con éxito!")
            println("Actualmente su saldo es de $saldo")
        }
    }

    fun recibir_dinero_ajeno(){
        println("Escriba el número de la cuenta que va a recibir el abono:")
        var numero_consulta = readln().toInt()
        println("Escriba el número de la cuenta que va a realizar el pago:")
        var numero_enviar = readln().toInt()
        if (numero_consulta == numero_cuenta){
            println("Escriba el dinero que quiere recibir")
            var dinero_recibir = readln().toInt()
            saldo += dinero_recibir
            println("¡Ingreso realizado con éxito!")
            println("Su saldo actual es de $saldo")
        }
    }
    fun menu_cuenta(){
        println("1) Consultar saldo \n2) Recibir dinero de una cuenta ajena \n3) Enviar dinero a una cuenta ajena")
        var opcion = readln().toInt()
        when(opcion){
            1->{
                println("Consultar saldo")
                consultar_saldo()
            }
            2->{
                println("Recibir abono de una cuenta ajena")
                recibir_dinero_ajeno()
            }
            3->{
                println("Realizar pago a una cuenta ajena")
                enviar_dinero_ajeno()
            }
        }
    }

    fun imprimir_datos(){
        println("El número de cuenta es $cuenta y la cantidad de dinero que tiene es $saldo")
    }

}
