package com.cg.user.domain;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name= "pictures")
public class ImagesDomain { 
	 
	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY) 
	    @Column(name = "image_id")
	    private int id;
	    
	    @Column(name = "image")
	    private Blob photo;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Blob getPhoto() {
			return photo;
		}

		public void setPhoto(Blob photo) {
			this.photo = photo;
		}

			    
	    
}
