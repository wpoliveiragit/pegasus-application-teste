package br.com.pegasus.restful.app.monitor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.pegasus.restful.app.DTO.BankInfoDto;
import br.com.pegasus.restful.infra.plardprovider.entity.ProcessCreditBalanceRefoundtDto;
import br.com.pegasus.restful.infra.plardprovider.entity.ProcessCreditBalanceRefoundtResultDto;
import br.com.pegasus.restful.infra.plardprovider.entity.StatusDetailsInnerEntity;
import br.com.pegasus.restful.infra.plardprovider.entity.StatusDto;
import br.com.pegasus.restful.infra.plardprovider.entity.StatusDto.TypeEnum;
import br.com.pegasus.restful.infra.repository.adapter.RefundRequestRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Component
public class RefundRequestMonitor {

	private @Autowired RefundRequestRepositoryAdapter refundRequestRepositoryAdapter;

	@Scheduled(fixedRate = 2000)
	public void processMonitoring() throws Exception {

		try {
			String cardContractId = UUID.randomUUID().toString();
			String simulationId = UUID.randomUUID().toString();
			String bankNumber = getRandomStringNumber("%04d", 9999);
			String agencyNumber = getRandomStringNumber("%08d", 99999999);
			String accountNumber = getRandomStringNumber("%02d", 99);

			BankInfoDto bankInfo = new BankInfoDto(bankNumber, agencyNumber, accountNumber);
			var response = plardProcessCreditBalanceRefound(cardContractId, simulationId, bankInfo);

			refundRequestRepositoryAdapter.process(cardContractId, simulationId, bankInfo, response);

		} catch (Exception ex) {
			System.out.println();
			log.warn(ex.getMessage());
		}
	}

	private ProcessCreditBalanceRefoundtDto plardProcessCreditBalanceRefound(String cardContractId, String simulationId,
			BankInfoDto bankInfoDto) {

		StatusDto status = new StatusDto(//
				"status.message.id", //
				"status.message", TypeEnum.INFO, //
				Arrays.asList(//
						new StatusDetailsInnerEntity("id1", "value1"), //
						new StatusDetailsInnerEntity("id2", "value2"), //
						new StatusDetailsInnerEntity("id3", "value3")//
				));

		var result = new ProcessCreditBalanceRefoundtResultDto("", BigDecimal.valueOf(10), "");

		return new ProcessCreditBalanceRefoundtDto(status, result);

	}

	private String getRandomStringNumber(String format, int value) {
		return String.format(format, new Random().nextInt(value));
	}

}
