package acs.springfamework.spring5mvcrest.api.v1.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Customers",
	description="Customers list")
public class CustomerListDTO {

	@ApiModelProperty(value="Customers list")
	private List<CustomerDTO> customers;
	
}
