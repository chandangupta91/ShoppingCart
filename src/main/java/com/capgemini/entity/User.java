package com.capgemini.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 2225076147595237386L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 3, message = "Length must be more than 3")
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotNull
    private boolean active;
    @NotEmpty
    private String role = "ROLE_CUSTOMER";
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }
}
