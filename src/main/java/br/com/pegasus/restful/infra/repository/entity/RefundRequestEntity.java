package br.com.pegasus.restful.infra.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "refund_request")
public class RefundRequestEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String simulationId;
	private String cardContractId;
	private String balanceRefundId;
	private String status;

	private LocalDateTime creationDate;
	private LocalDateTime updateDate;

	@OneToOne(mappedBy = "refundRequest", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private BankInfoEntity bankInfo;
}
