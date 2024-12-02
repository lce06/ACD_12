package com.example.relationaldataaccess;

import jakarta.persistence.*;

@Entity
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Se añade este atributo como clave primaria para la entidad

	// Atributos
	private String nombre;
	private int vida;
	private int energia;
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "personaje_id") // Relación con la entidad Personaje
	private Personaje personaje;

	// Métodos (sin modificaciones)
	public Habilidad() {
		nombre = "ninguno";
		vida = 0;
		energia = 0;
		tipo = "ninguno";
	}

	public Habilidad(String nombre, int vida, int energia, String tipo) {
		this.nombre = nombre;
		this.vida = vida;
		this.energia = energia;
		this.tipo = tipo;
	}

	public Habilidad(Habilidad habilidad) {
		this.nombre = habilidad.nombre;
		this.vida = habilidad.vida;
		this.energia = habilidad.energia;
		this.tipo = habilidad.tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public boolean esIgual(Habilidad habilidad) {
		boolean salida = false;
		if (this.nombre.equals(habilidad.nombre)) {
			salida = true;
		}
		return salida;
	}

	@Override
	public boolean equals(Object habilidad_entrada) {
		boolean salida = false;
		Habilidad habilidad = (Habilidad) habilidad_entrada;
		if (this.nombre.equals(habilidad.nombre)) {
			salida = true;
		}
		return salida;
	}

	public void visualizarBasico() {
		System.out.println("---------------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Vida: " + vida);
		System.out.println("Energia: " + energia);
		System.out.println("Tipo: " + tipo);
		System.out.println("---------------------------");
	}

	public void visualizar() {
		System.out.println("---------------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Vida: " + vida);
		System.out.println("Energia: " + energia);
		System.out.println("Tipo: " + tipo);
		System.out.println("---------------------------");
	}

	public String toString() {
		String cad;
		cad = this.nombre + ";" + this.vida + ";" + this.energia + ";" + this.tipo + ";";
		return cad;
	}
}
