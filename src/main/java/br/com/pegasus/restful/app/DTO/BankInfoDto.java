package br.com.pegasus.restful.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankInfoDto {

	private String bankNumber;
	private String agencyNumber;
	private String accountNumber;

}
