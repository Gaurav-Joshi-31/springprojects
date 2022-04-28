package com.shopping.style.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.shopping.style.models.Role;
import com.shopping.style.models.User;
import com.shopping.style.repositories.RoleRepository;
import com.shopping.style.repositories.UserRepository;

@Component
public class GoogleSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	UserRepository userRepo;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

		String email = token.getPrincipal().getAttributes().get("email").toString();

		if (!userRepo.findUserByEmail(email).isPresent()) {
			User user = new User();
			user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
			user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
			user.setEmail(email);
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepo.findById(2).get());
			user.setRoles(roles);
			userRepo.save(user);

		}

		redirectStrategy.sendRedirect(request, response, "/");

	}

}
