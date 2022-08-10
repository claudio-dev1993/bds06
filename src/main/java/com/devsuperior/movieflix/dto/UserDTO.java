package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devsuperior.movieflix.entities.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String email;
    
    Set<RoleDTO> roles = new HashSet<>();

    List<ReviewDTO> reviews = new ArrayList<>();

    public UserDTO() {

    }

    public UserDTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
       
    }

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public boolean hasRole(String roleName){
		for(RoleDTO role : roles){
			if(role.getAuthority().equals(roleName)){
				return true;
			}
		}
		return false;
	}

    
}
