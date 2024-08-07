package com.example.electronic.store.entity;



import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class User {

	    //@GenratedValue(strategy = GenerationType.IDENTITY
	@jakarta.persistence.Id
	    private String userId;

	    @jakarta.persistence.Column(name = "user_name")
	    private String name;

	    @jakarta.persistence.Column(name = "user_email", unique = true)
	    private String email;

	    @jakarta.persistence.Column(name = "user_password", length = 500)
	    private String password;

	    private String gender;

	    @jakarta.persistence.Column(length = 1000)
	    private String about;

	    @jakarta.persistence.Column(name = "user_image_name")
	    private String imageName;


}
