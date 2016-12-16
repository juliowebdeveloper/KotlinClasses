package com.shido


//Definindo interfaces, classes e a main tudo no memso arquivo
interface Signature {
    fun sign()
}

//val name:String é construtor dessa class - tirando construtor primario - immutable
//Default values = colocar um valor default no construtor que pode ou não ser sobreescrito
open class Person (val name:String, var age:Int, var isMarried:Boolean = false) : Signature {


    var partnerName :String ="" //Propriedade da classe
   /* var isMarried = false
    //Constructor em Kotlin recebe os parametros desejados
    //os que já estiverem de acordo com o construtor definido na class irão para o retorno
    //os novos são atribuidos assim como no java. -> Não é o preferível

    constructor(name:String, age:Int, isMarried:Boolean) : this(name, age){
        this.isMarried = isMarried
    }*/

    //Init é um metodo especial que nao utiliza parametros e inicia antes de tudo
    init {
        if (name =="Kevin" && age > 114) throw Exception("Invalid Age")
    }

    override fun sign() = println("I, $name have $age and can sign documents and married status is $isMarried")


    companion object{
        //val is immutable, var is mutable - getters and setters
        @JvmStatic//Isso serve para dizer ao compilador: marque esse metodo como static
        //Assim é possivel roda-la dessa maneira, ja que a main está dentro de um companio object
        //Sem mais erro no Edit Configuration
        fun main(args: Array<String>) {
            val p = Person("Kevin", 21, true)
            p.sign()
            //Mudando o age por ser uma var
            p.age = 64
            p.sign()
            p.partnerName ="Alice"
            println("Partner Name is: ${p.partnerName}") //Para exibir propriedades de um objeto colcoa-se entre ${}

            p.partnerName ="Bob"
            println("Partner Name is: ${p.partnerName}")


            val kevin = User("Kevin", 123)
                println(kevin)//Chama o metodo toString da classe user e imprime o nome
            //Deconstructions
            val (name, idnumber) = kevin //Desconstruindo a referencia de kevin à classe User em variaveis e imprimindo-as
            //Respeitar a ordem das propriedades do data class que é como será impresso
            //Data class vem com os metodos component1, component2, componentN
            println("user is $name and their id is $idnumber")


        }
    }



}

    //Diferente do java, classes são 'final' por padrão ou seja nao podem herdar delas
//Open para poder derivar da class

    //Caso criemos um classe derivando da outra, no construtor deve sempre ser var ou val,
// já que precisar fazer um override daquelas propriedades entao nao precisa atribur var ou val
    class Student(name:String, age:Int) : Person(name, age){}


data class User(val name:String,  val id:Int)
//Data class prove toString hash





