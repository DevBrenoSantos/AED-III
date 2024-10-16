package Lista2_Arquivos.ex12;

class Aluno {
    String nome;
    double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public boolean isAprovado() {
        return nota >= 7.0;  // Critério de aprovação
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + ", Nota: " + nota + ", " + (isAprovado() ? "Aprovado" : "Reprovado");
    }
}

