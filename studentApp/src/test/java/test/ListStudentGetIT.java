package test;

import org.springframework.context.annotation.Bean;
import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;

/**
 * @author Diego Sierra
 */

@Test
public class ListStudentGetIT extends TestNGCitrusTestDesigner {

	// Declaración del EndPoint
	@Bean
	public HttpClient EndPointStudent() { // EndPoint de tipo HttpClient
		return CitrusEndpoints.http().client().requestUrl("http://localhost:8080/student").build();
	}
	
	//Test para generar JSON con todos los estudiantes.
	@CitrusTest
	public void listStudentFull() {
		http().client(EndPointStudent()).send().get("/list").payload("");
	}

	//Test para generar JSON con un estudiante según ID.
	@CitrusTest
	public void listOneStudent() {
		http().client(EndPointStudent()).send().get("/100").payload("");
	}

	//Test para generar JSON con todos los estudiantes que tengan programa Computer Science
	@CitrusTest
	public void listStudentProgrammeFull() {
		http().client(EndPointStudent()).send().get("/list?programme=Computer Science").payload("");
	}
	
	//Test para generar JSON con dos estudiantes que tengan programa Computer Science
	@CitrusTest
	public void listStudentProgrammeLimit() {
		http().client(EndPointStudent()).send().get("/list?programme=Computer Science&limit=2").payload("");
	}

}
