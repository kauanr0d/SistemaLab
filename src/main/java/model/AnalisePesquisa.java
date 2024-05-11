package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "LabQ")
public class AnalisePesquisa extends Analise implements Serializable{

}
