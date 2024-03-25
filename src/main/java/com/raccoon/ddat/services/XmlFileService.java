package com.raccoon.ddat.services;

import com.raccoon.ddat.dto.XmlFileEntityDto;
import com.raccoon.ddat.entity.XmlFileEntity;
import com.raccoon.ddat.mapper.XmlFileMapper;
import com.raccoon.ddat.repository.XmlFileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class XmlFileService {

    private final XmlFileRepository repository;
    private final XmlFileMapper mapper;

    public Page<XmlFileEntityDto> getXmlFiles(String context, List<String> subtags, Pageable pageable) {
        return repository.findByContextContainsAndSubtagInOrderByModuleName(context, subtags, pageable)
                .map(mapper::toDto);
    }

    public XmlFileEntityDto saveXmlFile(XmlFileEntity entity) {
        return mapper.toDto(repository.save(entity));
    }
}
