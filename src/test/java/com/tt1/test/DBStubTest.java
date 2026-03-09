package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBStubTest {

	private DBStub db;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		db = new DBStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPersistenciaTareas() {
		ToDo tarea = new ToDo();
		tarea.setNombre("Prueba DB");
		
		db.crear(tarea);
		
		ToDo recuperada = db.leer("Prueba DB");
		assertNotNull(recuperada);
		assertEquals("Prueba DB", recuperada.getNombre());
	}
	
	@Test
	void testAgendaEmails() {
		String email = "test@ejemplo.com";
		db.anadirEmail(email);
		
		List<String> emails = db.obtenerEmails();
		assertTrue(emails.contains(email));
	}
	
	@Test
	void testBorrado() {
		ToDo tarea = new ToDo();
		tarea.setNombre("Borrar");
		db.crear(tarea);
		
		db.borrar("Borrar");
		assertNull(db.leer("Borrar"));
	}
}