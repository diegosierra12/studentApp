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
public class DeleteStudent extends TestNGCitrusTestDesigner{
	// Declaración del EndPoint
	@Bean
	public HttpClient EndPointStudent() { // EndPoint de tipo HttpClient
		return CitrusEndpoints.http().client().requestUrl("http://localhost:8080").build();
	}
	
	@CitrusTest
    public void deleteEmail() {
        http().client(EndPointStudent())
                .send()
                .delete("/student/104")
                .payload("");
    }

}
