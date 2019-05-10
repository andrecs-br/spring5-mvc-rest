package acs.springfamework.spring5mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
	@JsonProperty(value="customer_url")
	private String customerUrl;
    
	@JsonProperty(value="firstname")
    private String firstName;
	
	@JsonProperty(value="lastname")
    private String lastName;

}
