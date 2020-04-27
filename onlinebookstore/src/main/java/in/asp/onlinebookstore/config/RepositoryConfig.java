package in.asp.onlinebookstore.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		// config.exposeIdsFor(Book.class); In this way we need to expose Ids for each entities we create.
		
		/* This is the process to expose ids for all the entities created 
		 * 'entityManager.getMetamodel().getEntities()' is to get all the entities
		 * 'stream' is from JAVA 8, 'getJavaTyp' to get the Java type and 'toArray' to covert to array*/
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type :: getJavaType)
				.toArray(Class[] :: new));
		
		/* This is the process to apply CORS logic to all the repositories, 
		 * instead applying '@CrossOrigin' to all the repositories.
		 * 'addMapping' method with '/**' means to add the mapping for all the requests.
		 * 'allowedOrigins' method with 'http://localhost:4200' is specyfing host name, which is in here
		 * we need 'localhost 4200'. Similarly we add multiple hosts/origins using comma(,) seperator in sting */
		config.getCorsRegistry()
				.addMapping("/**")
				.allowedOrigins("http://localhost:4200");
		
	}

}
