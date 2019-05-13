package acs.springfamework.spring5mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Customer",
			description="Customer data")
public class CustomerDTO {
	
	@ApiModelProperty(value="URL to access details of the costumer")
	@JsonProperty(value="customer_url")
	private String customerUrl;

	@ApiModelProperty(value="This is the first name",
			required=true)
	@JsonProperty(value="firstname")
    private String firstName;

	@ApiModelProperty(value="This is the last name",
			required=false)
	@JsonProperty(value="lastname")
    private String lastName;

}
