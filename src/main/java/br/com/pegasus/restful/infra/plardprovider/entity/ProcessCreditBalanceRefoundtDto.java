package br.com.pegasus.restful.infra.plardprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcessCreditBalanceRefoundtDto {

	private StatusDto status;
	private ProcessCreditBalanceRefoundtResultDto result;

}
