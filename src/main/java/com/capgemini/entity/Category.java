package com.capgemini.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="category")
public class Category implements Serializable {
	
	
	private static final long serialVersionUID = -2644316837341041178L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)   
	int id;
	
	@Column(name="name")
	String name;
}