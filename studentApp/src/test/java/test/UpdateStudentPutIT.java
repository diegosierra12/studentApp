package test;

import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;

/**
 * @author Diego Sierra
 */

@Test
public class UpdateStudentPutIT extends TestNGCitrusTestDesigner{
	
	// Declaración del EndPoint
	@Bean
	public HttpClient EndPointStudent() { // EndPoint de tipo HttpClient
		return CitrusEndpoints.http().client().requestUrl("http://localhost:8080").build();
	}
	
	@CitrusTest
    public void updateStudent() {
        http().client(EndPointStudent())
                .send()
                .put("/student/104")
                .messageType(MessageType.JSON)
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .payload(new ClassPathResource("/templates/UpdateStudent.json"));
    }

}
