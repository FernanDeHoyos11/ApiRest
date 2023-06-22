/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author fernan
 */
@Configuration
@EnableWebSecurity
public class SecuritySpring extends WebSecurityConfigurerAdapter{
    
     @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
     
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }
      //metodo para autorizacion de los usuarios, que pueden hacer
        //  HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                // Rutas para las aplicaciones
                .antMatchers(HttpMethod.GET, "/aplicaciones/lista").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/aplicaciones/guardar").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/aplicaciones/servidor/so/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/aplicaciones/buscar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/aplicaciones/eliminar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/aplicaciones/aplicacion/**").hasAnyRole("ADMIN", "USER")
                // Rutas para los servidores
                .antMatchers(HttpMethod.GET, "/servidores/lista").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/servidores/guardar").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/servidores/eliminar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/servidores/buscar/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/con-mas-de-una-aplicacion").hasAnyRole("ADMIN", "USER")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .csrf().disable()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .headers().cacheControl().disable();
        
                
    }

}
