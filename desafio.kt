class Usuario(val nomeDoUsuario: String) {
    var totalDeXP: Int = 0
    val UPAR_XP: Int = 30
    var cursosMatriculados: Int = 0
    
    fun progredirXP() {  
        println("Progredindo XP de $nomeDoUsuario...")
        totalDeXP += UPAR_XP      
    }
    
    fun contaCursoMatriculado() {
        cursosMatriculados += 1
	}
}

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(var nome: String, val duracao: Int) {
    
}

data class Formacao(val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val tiposDeConteudos = mutableListOf<Formacao>()
    init {
        tiposDeConteudos.add(this)
    }
    
    val inscritos = mutableListOf<Usuario>()
    
    fun obterStringConteudos(): String {
        return conteudos.joinToString("\n") { conteudo ->
            "Nome do Curso: ${conteudo.nome}\nCarga Horária: ${conteudo.duracao}\nNível: $nivel"
        }
    }
    
    fun matricular(usuario: Usuario) {
        // Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).
        inscritos.add(usuario)
        println("\nUsuário matriculado com sucesso! \nNome: ${usuario.nomeDoUsuario} \nXP do Usuário: ${usuario.totalDeXP} \nCurso Matriculado -> ${obterStringConteudos()}")
    }
    
   
}


fun main() {
    
    //ADICIONANDO CURSOS
    val formacao1 = Formacao(
    nivel = Nivel.BASICO,
    conteudos = listOf(ConteudoEducacional("Bootcamp TQI Kotlin - Backend Developer", 112))
	)
    
    val formacao2 = Formacao(
    nivel = Nivel.INTERMEDIARIO,
    conteudos = listOf(ConteudoEducacional("TQI Fullstack Developer", 90))
	)
    
    val formacao3 = Formacao(
    nivel = Nivel.AVANCADO,
    conteudos = listOf(ConteudoEducacional("Formação Quality Assurance (QA)", 60))
	)
    
    println("\n_-------Fazendo testes---------_\n")
    println(formacao1.tiposDeConteudos)
    println(formacao2.tiposDeConteudos)
    println(formacao3.tiposDeConteudos)
    
    //Matriculando alunos:
    println("\n_-------------------------_\n")
    
    println("Lista de formação DIO: \n1 - Bootcamp TQI Kotlin - Backend Developer | Básico") 
    println("2 - TQI Fullstack Developer | Intermediário")
    println("3 - Formação Quality Assurance (QA) | Avançado")
    
    val usuario1 = Usuario("João")
    formacao3.matricular(usuario1)
    usuario1.contaCursoMatriculado()
    
    val usuario2 = Usuario("Maria")
    formacao2.matricular(usuario2)
    usuario2.contaCursoMatriculado()
    
    val usuario3 = Usuario("André")
    formacao1.matricular(usuario3)
    usuario3.contaCursoMatriculado()
    
    println()
    usuario1.progredirXP()
    usuario3.progredirXP()
    usuario1.progredirXP()
    
    
    formacao2.matricular(usuario1)
    usuario1.contaCursoMatriculado()
    

}