package com.raccoon.ddat.repository;

import com.raccoon.ddat.entity.XmlFileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface XmlFileRepository extends JpaRepository<XmlFileEntity, Long> {
    Page<XmlFileEntity> findByContextContainsAndSubtagInOrderByUrlCountDesc(String search, List<String> subtags, Pageable pageable);

    Page<XmlFileEntity> findBySubtagInOrderByUrlCountDesc(List<String> subtags, Pageable pageable);

    void deleteByModuleName(String moduleName);

    @Query("SELECT x.moduleName, COUNT(x) FROM XmlFileEntity x GROUP BY x.moduleName")
    List<Object[]> countByModuleName();
}
