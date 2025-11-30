// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val nome: String, val idade: Int, val escolaridade: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>();
    
    fun matricular(usuarios: List<Usuario>) {
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
    val actions = listOf(2, 1, 3);
    val formacaoEscolhida = "Front-end Developer"
    
    for(action in actions) {
        var count = 1;
        
        println("-----------------------------------------")
        println("----- Bem Vindo às Formações da DIO -----")
        println("-----------------------------------------")
        println("1 - Verificar formações disponíveis.")
        println("2 - Inscrever alunos em uma formação.")
        println("3 - Sair")
        
        println("\nEscolha uma das opções acima: $action")
        
        when(action) {
            1 -> when(formacoes.size) {
                0 -> println("\nNenhuma formação disponível!\n")
                else -> for(formacao in formacoes) {
                    println("\n************ Formação $count ************")
                    println("\t${formacao.nome}")
                    println("\tMódulos: ${formacao.conteudos.size}")
                    println("\tNível: ${formacao.nivel}")

                    println("\n++++++++++++ Conteudos ++++++++++++++")
                    for (conteudo in formacao.conteudos) {
                        println("\t${conteudo.nome} - ${conteudo.duracao}hrs - ${conteudo.nivel}")
                    }
                    
                    println("\n+++++++++++++ Alunos +++++++++++++++")
                    if(formacao.inscritos.size > 0) {
                        for (aluno in formacao.inscritos) {
                            println("${aluno.nome} | ${aluno.idade} anos - ${aluno.escolaridade}\n")
                        }
                    } else {
                        println("\nNenhuma inscrição ativa!\n")
                    }

                    println("************************************")
                    count++
                }
            }
            2 -> for (formacao in formacoes) {
                if (formacao.nome == formacaoEscolhida) {
                    formacao.matricular(usuarios);
                    println("\nInscrição realizada com sucesso!\n")
                    break;
                } else if(count == formacoes.size) {
                    println("Formação inexistente!")
                }
                count++
            }
            3 -> println("\nSAINDO...")
            else -> println("\nOpção inválida!\n")
        }
    }
}
