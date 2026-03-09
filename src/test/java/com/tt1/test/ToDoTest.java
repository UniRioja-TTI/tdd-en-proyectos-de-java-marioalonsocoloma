package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGettersAndSetters() {
		ToDo todo = new ToDo();
		String nombre = "Tarea Test";
		String descripcion = "Descripcion de prueba";
		LocalDate fecha = LocalDate.now();

		todo.setNombre(nombre);
		todo.setDescripcion(descripcion);
		todo.setFechaLimite(fecha);
		todo.setCompletado(true);

		assertEquals(nombre, todo.getNombre());
		assertEquals(descripcion, todo.getDescripcion());
		assertEquals(fecha, todo.getFechaLimite());
		assertTrue(todo.isCompletado());
	}
}
