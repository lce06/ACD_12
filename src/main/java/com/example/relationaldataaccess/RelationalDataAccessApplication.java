package com.example.relationaldataaccess;

// Nombre: Lizbeth Castellanos.E
//Ejercicio 12 : Act_012
//Descripcion: Modificar el codigo y Spring JDBC para trabajar con SGBD relacionales


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelationalDataAccessApplication implements CommandLineRunner {

	@Autowired
	private PersonajeRepository personajeRepository;

	@Autowired
	private HabilidadRepository habilidadRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelationalDataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Primer Personaje: Rusty
		Personaje personaje1 = new Personaje();
		personaje1.setNombre("Rusty");
		personaje1.setClase("Guerrero");
		personaje1.setVida_max(150);
		personaje1.setEnergia_max(80);
		personaje1.setVida_actual(150);
		personaje1.setEnergia_actual(80);
		personaje1.setMonedas(50);
		personaje1.setNpc(false);
		personaje1.setHostil(false);
		personajeRepository.save(personaje1);

		Habilidad habilidad1_1 = new Habilidad("Ataque", 20, 10, "Ataque");
		habilidad1_1.setPersonaje(personaje1);

		Habilidad habilidad1_2 = new Habilidad("Defensa Total", 30, 15, "Defensa");
		habilidad1_2.setPersonaje(personaje1);

		habilidadRepository.save(habilidad1_1);
		habilidadRepository.save(habilidad1_2);

		// Segundo Personaje: Heurimong
		Personaje personaje2 = new Personaje();
		personaje2.setNombre("Heurimong");
		personaje2.setClase("Mago");
		personaje2.setVida_max(120);
		personaje2.setEnergia_max(200);
		personaje2.setVida_actual(120);
		personaje2.setEnergia_actual(200);
		personaje2.setMonedas(100);
		personaje2.setNpc(false);
		personaje2.setHostil(false);
		personajeRepository.save(personaje2);

		Habilidad habilidad2_1 = new Habilidad("Bola de Fuego", 40, 30, "Ataque");
		habilidad2_1.setPersonaje(personaje2);

		Habilidad habilidad2_2 = new Habilidad("Escudo Mágico", 0, 20, "Defensa");
		habilidad2_2.setPersonaje(personaje2);

		habilidadRepository.save(habilidad2_1);
		habilidadRepository.save(habilidad2_2);

		// Tercer Personaje: Zuharong
		Personaje personaje3 = new Personaje();
		personaje3.setNombre("Zuharong");
		personaje3.setClase("Arquera");
		personaje3.setVida_max(130);
		personaje3.setEnergia_max(100);
		personaje3.setVida_actual(130);
		personaje3.setEnergia_actual(100);
		personaje3.setMonedas(80);
		personaje3.setNpc(false);
		personaje3.setHostil(false);
		personajeRepository.save(personaje3);

		Habilidad habilidad3_1 = new Habilidad("Flecha Veloz", 25, 10, "Ataque");
		habilidad3_1.setPersonaje(personaje3);

		Habilidad habilidad3_2 = new Habilidad("Camuflaje", 0, 15, "Defensa");
		habilidad3_2.setPersonaje(personaje3);

		habilidadRepository.save(habilidad3_1);
		habilidadRepository.save(habilidad3_2);

		// Mostrar todos los personajes y habilidades
		System.out.println("Personajes:");
		personajeRepository.findAll().forEach(System.out::println);

		System.out.println("Habilidades:");
		habilidadRepository.findAll().forEach(System.out::println);
	}
}
