package com.raccoon.ddat.services;

import com.raccoon.ddat.dto.XmlFileEntityDto;
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

    public Page<XmlFileEntityDto> getXmlFiles(String context, List<String> subtags, Pageable pageable) {
        return repository.findByContextContainsAndSubtagInOrderByModuleName(context, subtags, pageable).map(entity ->
                XmlFileEntityDto.builder()
                        .id(entity.getId())
                        .context(entity.getContext())
                        .subtag(entity.getSubtag())
                        .moduleName(entity.getModuleName())
                        .build());
    }

    public Page<XmlFileEntityDto> saveXmlFile(XmlFileEntityDto dto) {

        return null;
        //return repository.save(dto.toEntity());
    }
}
