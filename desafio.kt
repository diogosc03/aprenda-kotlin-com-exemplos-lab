// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val nome: String, val idade: Int, val escolaridade: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>();
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
        }
    }
}

val formacoes = listOf<Formacao>(
    Formacao(
        nome = "Front-end Developer",
        conteudos = listOf(
            ConteudoEducacional(
                nome = "HTML5",
            	duracao = 5,
            	nivel = Nivel.BASICO
            ),
            ConteudoEducacional(
                nome = "CSS3",
            	duracao = 5,
            	nivel = Nivel.BASICO
            )
        ),
        nivel = Nivel.BASICO
    ),
    Formacao(
        nome = "Back-end Developer",
        conteudos = listOf(
            ConteudoEducacional(
                nome = "PHP",
            	duracao = 5,
            	nivel = Nivel.BASICO
            ),
            ConteudoEducacional(
                nome = "SQL",
            	duracao = 5,
            	nivel = Nivel.BASICO
            )
        ),
        nivel = Nivel.BASICO
    )
)

val usuarios = listOf<Usuario>(
    Usuario(
        nome = "João Barbosa",
        idade = 16,
        escolaridade = "Ensino fundamental completo"
    ),
    Usuario(
        nome = "Ana Maria",
        idade = 24,
        escolaridade = "Ensino superior"
    )
)

fun main() {
    val actions = listOf(2, 3);
    var count = 1;
    
    for(action in actions) {
        println("-----------------------------------------")
        println("----- Bem Vindo às Formações da DIO -----")
        println("-----------------------------------------")
        println("1 - Verificar formações disponíveis.")
        println("2 - Se inscrever em uma formação.")
        println("3 - Sair")
        
        println("\nEscolha uma das opções acima: $action")
        
        when(action) {
            1 -> when(formacoes.size) {
                0 -> println("\nNenhuma formação disponível.\n")
                else -> for(formacao in formacoes) {
                    println("\n************ Formação $count ************")
                    println("\t${formacao.nome}")
                    println("\tMódulos: ${formacao.conteudos.size}")
                    println("\tNível: ${formacao.nivel}")

                    println("\n++++++++++++ Conteudos ++++++++++++++")
                    for (conteudo in formacao.conteudos) {
                        println("\t${conteudo.nome} - ${conteudo.duracao}hrs - ${conteudo.nivel}")
                    }

                    println("\n************************************")
                    count++
                }
            }
            3 -> println("\nSAINDO...")
        }
    }
}
