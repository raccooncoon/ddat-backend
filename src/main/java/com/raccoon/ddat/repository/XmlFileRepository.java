package com.raccoon.ddat.repository;

import com.raccoon.ddat.entity.XmlFileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface XmlFileRepository extends JpaRepository<XmlFileEntity, Long> {
    Page<XmlFileEntity> findByContextContainsAndSubtagInOrderByModuleName(String context, List<String> subtags, Pageable pageable);
}
