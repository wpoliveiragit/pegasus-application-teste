package br.com.pegasus.restful.infra.plardprovider.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusDto {

	private String messageId;
	private String message;
	private TypeEnum type;
	private List<StatusDetailsInnerEntity> detail = new ArrayList<>();

	public enum TypeEnum {
		INFO("info"), WARN("warn"), ERROR("error");

		@Getter
		private String value;

		private TypeEnum(String value) {
			this.value = value;
		}

	}

}
