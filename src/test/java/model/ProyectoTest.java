package model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ProyectoTest {

	@Test
	void testProyectoSeCreaConTodosSusValores() throws ParseException {
		Localidad unaLocalidad = new Localidad();
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = sdformat.parse("2020-09-12");
		Date fechaFin = sdformat.parse("2020-09-12");
		
		Proyecto unProyecto = new Proyecto("id", 2000, 1, "nombre", fechaInicio, fechaFin, unaLocalidad, 0d);
			
		assertEquals("id", unProyecto.getId());
		assertEquals(2000, unProyecto.getFactor());
		assertEquals(1, unProyecto.getPorcentajeMinimoCierre());
		assertEquals("nombre", unProyecto.getNombre());
		assertEquals(fechaInicio, unProyecto.getFechaInicio());
		assertEquals(fechaFin, unProyecto.getFechaFin());
		assertEquals(unaLocalidad, unProyecto.getLocalidad());
		assertEquals(0d, unProyecto.getTotalRecaudado());
	}
	
	@Test
	void testProyectoSeCreaYSeAsignanTodosSusValores() throws ParseException {
		Localidad unaLocalidad = new Localidad();
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = sdformat.parse("2020-09-12");
		Date fechaFin = sdformat.parse("2020-09-12");
		
		Proyecto unProyecto = new Proyecto();
		unProyecto.setId("id");
		unProyecto.setFactor(2000);
		unProyecto.setPorcentajeMinimoCierre(1);
		unProyecto.setNombre("nombre");
		unProyecto.setFechaInicio(fechaInicio);
		unProyecto.setFechaFin(fechaFin);
		unProyecto.setLocalidad(unaLocalidad);
		unProyecto.setTotalRecaudado(0d);
			
		assertEquals("id", unProyecto.getId());
		assertEquals(2000, unProyecto.getFactor());
		assertEquals(1, unProyecto.getPorcentajeMinimoCierre());
		assertEquals("nombre", unProyecto.getNombre());
		assertEquals(fechaInicio, unProyecto.getFechaInicio());
		assertEquals(fechaFin, unProyecto.getFechaFin());
		assertEquals(unaLocalidad, unProyecto.getLocalidad());
		assertEquals(0d, unProyecto.getTotalRecaudado());
	}
	
	@Test
	void testProyectoSeCreaConValoresPorDefectoYTieneFactor1000() {
		Proyecto unProyecto = new Proyecto();
		assertEquals(1000, unProyecto.getFactor());
	}
	
	@Test
	void testProyectoTieneUnaLocalidadDe2000HabitantesYUnFactorDe2000EntoncesElCostoTotalEsDe3Millones() {
		Localidad unaLocalidad = new Localidad();
		unaLocalidad.setPoblacion(1500);
		
		Proyecto unProyecto = new Proyecto();
		unProyecto.setLocalidad(unaLocalidad);
		unProyecto.setFactor(2000);
		
		assertEquals(3000000, unProyecto.importeTotalParaCompletar());
	}
}
