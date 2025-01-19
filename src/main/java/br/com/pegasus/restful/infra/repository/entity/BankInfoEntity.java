package br.com.pegasus.restful.infra.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bank_info")
public class BankInfoEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	private String document;
	private String bankNumber;
	private String agencyNumber;
	private String accountNumber;

	private LocalDateTime creationDate;
	private LocalDateTime updateDate;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private RefundRequestEntity refundRequest;
}
