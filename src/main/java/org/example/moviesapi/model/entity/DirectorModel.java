package org.example.moviesapi.model.entity;
import jakarta.persistence.*;



@Entity
@Table(name = "diretores")
public class DirectorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeDiretor;


    public DirectorModel(){}

    public DirectorModel(int id, String nomeDiretor) {
        this.id = id;
        this.nomeDiretor = nomeDiretor;
    }

    public long getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }
}
