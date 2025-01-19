package br.com.pegasus.restful.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pegasus.restful.infra.repository.entity.RefundRequestEntity;

@Repository
public interface RefundRequestRepository extends JpaRepository<RefundRequestEntity, UUID> {
}
