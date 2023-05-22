package br.com.rprodutos.RProdutos;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((request) -> request
				.requestMatchers("/entrar").permitAll()
				.requestMatchers("/inicio").permitAll()
				.requestMatchers("/cadastrar").permitAll()
				.requestMatchers("/api/**").permitAll()
				.anyRequest().authenticated()
			)
		
			.csrf().disable()
			
			.formLogin((form) -> form
				.loginPage("/entrar")
				.defaultSuccessUrl("/principal", true)
				.permitAll()
			)
			
			.logout((logout -> logout
				.logoutUrl("/sair")
				.logoutSuccessUrl("/inicio")
			));

		return http.build();
	}
	
	@Bean
	public UserDetailsManager users(DataSource dataSource) {
//		BCrypt e o responsavel por criptografar a senha e salvala no banco de dados
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//		Criando um usuario e preenchendo seus atributos
		UserDetails user = User.builder()
			.username("ruan2")
			//Nesse momento e feito a criptografia da senha
			.password(encode.encode("123"))
			.roles("ADM")
			.build();
		//Criando uma conexao com o JDBC
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		//Salvando o usuario no banco de dados
//		users.createUser(user);
		return users;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

}
