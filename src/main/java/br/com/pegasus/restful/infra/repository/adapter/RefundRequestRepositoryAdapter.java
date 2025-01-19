package br.com.pegasus.restful.infra.repository.adapter;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.pegasus.restful.app.DTO.BankInfoDto;
import br.com.pegasus.restful.infra.plardprovider.entity.ProcessCreditBalanceRefoundtDto;
import br.com.pegasus.restful.infra.repository.RefundRequestRepository;
import br.com.pegasus.restful.infra.repository.entity.BankInfoEntity;
import br.com.pegasus.restful.infra.repository.entity.RefundRequestEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RefundRequestRepositoryAdapter {

	private final RefundRequestRepository refundRequestRepository;

	public void process(String cardContractId, String simulationId, BankInfoDto bankInfoDto,
			ProcessCreditBalanceRefoundtDto responsePlard) {

		LocalDateTime dataNow = LocalDateTime.now();

		BankInfoEntity bankInfoEntity = new BankInfoEntity();
		RefundRequestEntity requestRefundId = new RefundRequestEntity();

		bankInfoEntity.setAccountNumber(bankInfoDto.getAccountNumber());
		bankInfoEntity.setAgencyNumber(bankInfoDto.getAgencyNumber());
		bankInfoEntity.setBankNumber(bankInfoDto.getBankNumber());
		bankInfoEntity.setCreationDate(dataNow);
//		bankInfoEntity.setDocument();
		bankInfoEntity.setUpdateDate(dataNow);

		requestRefundId.setBalanceRefundId(null);
		requestRefundId.setCardContractId(cardContractId);
		requestRefundId.setCreationDate(LocalDateTime.now());
		requestRefundId.setSimulationId(simulationId);
		requestRefundId.setStatus(simulationId);
		requestRefundId.setUpdateDate(LocalDateTime.now());

		requestRefundId.setBankInfo(bankInfoEntity);
		bankInfoEntity.setRefundRequest(requestRefundId);

		refundRequestRepository.save(requestRefundId);
		System.out.println();
	}

}
