package br.com.pegasus.restful.infra.plardprovider.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcessCreditBalanceRefoundtResultDto {

	private String baseCurrency;
	private BigDecimal refundedAmount;
	private String balanceRefoundId;

}
