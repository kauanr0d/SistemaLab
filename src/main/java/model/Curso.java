package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso implements Serializable{
	private String nome;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
