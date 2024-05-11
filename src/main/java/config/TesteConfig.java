package config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import model.Usuario;
import repositories.UsuarioRepository;
 
@Configuration
@Profile("dev")
public class TesteConfig implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuario;

	@Override
	public void run(String... args) throws Exception {
		Usuario u = new Usuario(null,"Kaun","122443",LocalDate.now(),"123123","email@.com");
		usuario.save(u);
				
	}
}
