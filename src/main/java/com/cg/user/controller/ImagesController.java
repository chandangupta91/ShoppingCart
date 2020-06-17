
package com.cg.user.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.MultipartConfigElement;
import javax.sql.rowset.serial.SerialException;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cg.user.dao.ImagesDao;
import com.cg.user.domain.ImagesDomain;
import com.cg.user.service.ImagesServiceInterface;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/images")
@CrossOrigin(value="http://localhost:4200")
public class ImagesController {

	@Autowired
	ImagesServiceInterface imagesService;
	
	@Autowired
	ImagesDao idao;
	
	
	@GetMapping(value = "database")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@RequestParam("id") Integer id) throws SQLException {

		Optional<ImagesDomain> images = imagesService.findById(id);
		byte[] imageBytes = null;
		if (images.isPresent()) {

			imageBytes = images.get().getPhoto().getBytes(1, (int) images.get().getPhoto().length());
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	/*
	 * @GetMapping(value="getAllImages") public ResponseEntity<byte[]> getAllImages(
	 * ) throws SQLException {
	 * 
	 * List<ImagesDomain> images = imagesService.findAll();
	 * 
	 * byte[] imageBytes = null; try{
	 * 
	 * imageBytes = images.get().getPhoto().getBytes(1, (int)
	 * images.get(0).getPhoto().length());
	 * 
	 * 
	 * } catch (NullPointerException e) { System.out.println("" + e); }
	 * 
	 * return
	 * ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes); }
	 * 
	 *
	 */
	
	
	
	@PutMapping(value="addproductImage")
	 public ResponseEntity<byte[]> addProductImage( @RequestParam("file") MultipartFile file
	           ) throws SerialException, SQLException, IOException{
		 System.out.println("In Image Uploading :"+file);
		  
	
		 byte[] imageBytes = file.getBytes();
		 Blob blob = new javax.sql.rowset.serial.SerialBlob(imageBytes);
		ImagesDomain i = new ImagesDomain();
		//i.setId(2);
		i.setPhoto(blob);
		idao.save(i);
		
		
		byte[] imagePhoto = null;
		
		Optional<ImagesDomain> images = imagesService.findById(i.getId());
		imagePhoto = images.get().getPhoto().getBytes(1, (int) images.get().getPhoto().length());
		
		 return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagePhoto);
	 }
	 
	

}
