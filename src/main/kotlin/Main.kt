

const val  PI = 3.1416

fun main(args: Array<String>) {
    println("Hello World!")

    var dinero = 10
    dinero = 23

    println(dinero)

    val nombre = "Celes"
    println(nombre)
 //   nombre = "Luchi"

    println(PI)

    val boolean = true
    val numeroLargo = 3L
    val double = 2.7183
    val float = 1.1f

    val primero = 20
    val segundo = 35
    val tercero = primero.minus(segundo) // minus resta primero - segundo
    println(tercero)

    val apellido = "Masmut"
    val nombreCompleto = " Mi nombre es $nombre $apellido"
    println(nombreCompleto)


    if(nombre.isNotEmpty()){
        println("El largo de la variable nombre es : ${nombre.length}")
    }else{
        println("Error, la variable esta vacia")
    }

    //asignacion inmutable
    val mensaje : String = if (nombre.length > 4){
        "Tu nombre es mayor a 4"
    }else if (nombre.isEmpty()){
        "Error, la variable esta vacia"
    }
    else{
        " Tu nombre es menor a  4"
    }
    println(mensaje)

    //WHEN
    /*Esta sentencia sirve en los casos que tengamos que comparar nuestra variable con múltiples opciones, ya que con la sentencia IF puede resultar poco optimo. */
    val color = "amarillo"
    when(nombre){
        "amarillo" -> println("amarillo es alegria")
        "rojo", "carmesi" -> println("Rojo es calor") // si es uno o el otro
        else -> println("error no hay color")
    }

    val code = 67
    when(code){
        //se encuentra en .. - especificar rango puede ser
        in 200 .. 299 -> println("ok")
        in 400 .. 500 -> println("error rango por fuera del valor")
        else -> println("codigo desconocido , ha fallado ")
    }

    val talle = 40
    val resp = when(talle){
        36,37 -> " disponible"
        35,38 -> "Casi no queda"
        39 -> " no hay dispo"
        else -> "no existe en esta talla"
    }
    println("Talle $talle $resp")


    do {
        println("Generando num aleatorios")
        val numAleatorio = (0..100).random()  // marco el rango entre parentesis y utilizo la fun ramdom
        println("numero generado es : $numAleatorio")
    }while (numAleatorio > 50)

    val frutas = listOf("manzana","frutilla","banana","pera")

    for (fruta in frutas) println("hoy quiero comer una $fruta")  //sintaxis comprimida

    frutas.forEach{ fruta -> println("hoy quiero comeer nuevamente una $fruta")} // las llaves de foreach indican que es una funcion anonima que se ejecutara mientras exista una fruta

    val caracteresFreuta: List<Int> = frutas.map { fruta -> fruta.length }
    println(caracteresFreuta)

    val listaFiltrada = caracteresFreuta.filter { caracterFruta -> caracterFruta > 5 }
    println(listaFiltrada)


    //try-catch
    var name : String? = null  // el ? en el tipo de variable significa que la variable es nulleable.
    try {
        name!!.length
    }catch (exception : NullPointerException){
        println("error")
    }finally {
        println("error... cerrando")
    }

    val valor1 = 10
    val valor2 = 0
    val resultado : Int = try { valor1/valor2 } catch (e : Exception){  0  }
    println(resultado)

    //OPERADOR ELVIS

    val caractName : Int = name?.length ?: 0
    println(caractName)


    //LISTAS
/*Las listas son inmutables, si queremos agregar, remover o usar funciones mas avanzadas necesitaremos una mutableList.
Podemos tener valores duplicados en una lista
Podemos recorrer todos los elementos de una lista
La principal diferencia entre una lista y un array es que la lista no puede actualizar ninguna de las referencias que almacena*/

    val nombres = listOf("cele","lu","sofi") // inmutable

    val emptyList = mutableListOf<String>() // mutable

    emptyList.add("cele")
    emptyList.add("lucho")
    emptyList.add("sofi")
    emptyList.add("mama")
    emptyList.add("marquitos")



    for (name1 in emptyList){
        println(name1)
    }
    println(nombres.firstOrNull())

    emptyList.removeAt(0)
    println(emptyList)

    emptyList.removeIf{ caracteres -> caracteres.length > 3 }

    val mtArray = arrayOf(1,2,3,4)
    println("mi array es ${mtArray.toList()}") // se transforma el array a unalista .

    val numList = listOf(11,22,32,43,56,78,66)

    println(numList.sorted())
    println(numList.sortedDescending())

    println(numList.sortedBy { num -> num < 50 })

    println(numList.shuffled()) // ordena aleatorios

    println(numList.reversed()) // invierte
    println(numList)

    //prog funcional

    val mensajesDeNum = numList.map {  num -> "El numero es $num" }
    println(mensajesDeNum)

    val filtrados = numList.filter {  num -> num > 50  }
    println(filtrados)


    //MAPS
    val edadSuperHeroe = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Captain America" to 99
    )

    println(edadSuperHeroe)

    val edadesMutables = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Captain America" to 99
    )
    println(edadesMutables)

    edadesMutables.put("Thor", 45)

    println(edadesMutables)

    edadesMutables["Hulk"] = 44

    println(edadesMutables)

    println(edadesMutables["Spiderman"])

    edadesMutables.remove("Thor")

    println(edadesMutables)

    println(edadesMutables.keys)
    println(edadesMutables.values)

    //SETS

    val vocalesRepetidas = setOf("a","e","i","o","u","a","e","i","o","u")
    println(vocalesRepetidas)

    val vocalesMutable = mutableSetOf("a","e","i","u")
    println(vocalesMutable)
    vocalesMutable.add("o")
    println(vocalesMutable)
    vocalesMutable.remove("e")
    println(vocalesMutable)

    val vocalDelSet : String? = vocalesMutable.firstOrNull{ vocal -> vocal == "i"}
    println(vocalDelSet)

    //FUNCIONES

val frase = "En platzi nunca paramos de aprender"
    println(frase.randomCase())

    imprimirFrase(frase)

    frase.nuevoImpreso()

    imprimirNombre(nombre="celes",apellido="masmut")

    //LAMBDA

    val myLambda : (String) -> Int = { value -> value.length }

    println(myLambda("celes"))

    println(nombres.map(myLambda))

    //FUNCION DE ALTO ORDEM

    val largoDelValorInicial = superFuncion(valorInicial = "Hola", block = {valor -> valor.length})
    println(largoDelValorInicial)

    val myLmabda : () -> String = funcionInception("Celes") // mi variable es de tipo lambda
    val valorMyLambda : String = myLmabda()
    println(valorMyLambda)

    //LET
    var name3 : String? = null
    name3?.let {
        valor -> println("el valor es $name3 ")
    }
    name3 = "Celeste"
    name3?.let {
            valor -> println("el valor es $name3 ")
    }

    //WITH  nos permite a las propiedades de una misma variable.
    val colours = listOf("azul", "amarillo","rojo")
    with(colours){
        println("los colores son $this")
        println("esta lista tiene $size colores")
    }

    //RUN

    val moviles = mutableListOf("Google Pixel 2XL","Google Pixel 4a","Huawei Redmi 9", "Xiaomi mi a3").also {
            lista -> println("el valor original de la lista es $lista")
    }.asReversed()
    println(moviles)

        moviles.run {
            removeIf{movil -> movil.contains("Google")}
            this
        }
    println(moviles)

    //APPLY
    /*La Función apply
El propósito de la función apply es tomar como alcance al objeto recibidor T sobre el que es invocado, aplicar las sentencias del parámetro block que recibe sobre dicho contexto y retornar el mismo objeto modificado.
Lenguaje del código: Kotlin (kotlin)
Como ves, el cuerpo del tipo función a pasar es Unit, esto significa que no es necesario especificar un resultado en la última línea de la lambda con recibidor que pases como argumento.

Para referirte al recibidor, usa la expresión this y así tendrás acceso a los miembros.
La función apply trabaja similar a with, solo que apply es una función de extensión y retorna al objeto recibidor como resultado.

Esto te permite inicializar propiedades cuando creas u obtienes instancias de una clase e incluso encadenar operaciones subsecuentes.

Ejemplo Con La Función apply
Tomemos como ejemplo la declaración de una clase que representa un par de zapatos en el inventario de un negocio.*/
     println(moviles.apply {
         removeIf { movil -> movil.contains("Goolgle") }
     })

   moviles.apply {
       println("Los celularees son $this")
       println("La cantidad de celulares es de $size")
   }


}



/*
TIPOS DE VARIABLES

VAR : Son variables de lectura y escritura, estas variables el valor puede cambiarse.

VAL : Son variables de solo lectura, dichas variables una vez asignado el valor no puede ser cambiado posteriormente.

CONST : es una variante de las variables de solo lectura, estas se definen fuera de la función y se escriben con la palabra reservada const seguida de la palabra reservada val, este tipo de variables son usada para valores que nunca cambian.

En Kotlin no se puede cambiar el tipo de dato con que se a definido una variable, si la variable se definio con el tipo de dato String solo podremos actualizar dicho valor por otro String, por ejemplo no podemos pasar de un string a un numero.
* */

/*Funciones de extensión en Kotlin
Las funciones de extensión (o extension functions en inglés) son funciones que, como su propio nombre indica, nos ayudan a extender la funcionalidad de clases sin necesidad de tocar su código. Ahora vamos a ver cómo se definen estas funciones, y algunos ejemplos que a mí personalmente me resultan muy útiles.

¿Cómo se define una función de extensión?
Tan solo hay que escribir una función como lo harías normalmente, y ponerle delante el nombre de la clase separado por un punto.

Ejemplo muy sencillo: queremos hacer que una vista tenga la función visible(), que la hace visible. Escribiríamos algo como esto:*/

fun String.randomCase() : String{
    val numAleatorio = 0..99
    val resultadoAleatorio = numAleatorio.random()
    return if(resultadoAleatorio.rem(2) == 0){
         this.uppercase()
    }else {
        this.lowercase()
    }
}

fun imprimirFrase(frase : String) : Unit{
    println("frase es : $frase")
}

fun String.nuevoImpreso() : Unit{
    println("tu frase es : $this")
}

fun imprimirNombre(nombre: String,segundoNombre : String = "", apellido: String){
    println("mi nombre $nombre $segundoNombre y apellido $apellido")
}


/*
Funciones de orden superior

Kotlin es un lenguaje orientado a objetos pero introduce características existentes en los lenguajes funcionales que nos permiten crear un código más claro y expresivo.

Una de las características del paradigma de la programación funcional son las funciones de orden superior.

Las funciones de orden superior son funciones que pueden recibir como parámetros otras funciones y/o devolverlas como resultados.

Veremos una serie de ejemplos muy sencillos para ver como Kotlin implementa el concepto de funciones de orden superior y a medida que avancemos en el curso podremos ver las ventajas de este paradigma.*/

//FUNCION DE ALTO ORDEM
/*Funciones de orden superior

Kotlin es un lenguaje orientado a objetos pero introduce características existentes en los lenguajes funcionales que nos permiten crear un código más claro y expresivo.

Una de las características del paradigma de la programación funcional son las funciones de orden superior.

Las funciones de orden superior son funciones que pueden recibir como parámetros otras funciones y/o devolverlas como resultados.

Veremos una serie de ejemplos muy sencillos para ver como Kotlin implementa el concepto de funciones de orden superior y a medida que avancemos en el curso podremos ver las ventajas de este paradigma.*/

fun superFuncion (valorInicial : String, block : (String) -> Int) : Int{ // block para ejecutar un codigo de lambda
    return  block(valorInicial)
}

fun funcionInception(nombre : String) : () -> String{
    return {
        "Hola desde la lambda $nombre"
    }
}

/*La Función let { }
La función let es una función que crea un alcance temporal para un objeto en el interior de un bloque de código.

Esto quiere decir, que puedes referirte al objeto sin usar su nombre debido a que es el parámetro de la función lambda pasada a let.*/

