package com.raccoon.ddat.controller;

import com.raccoon.ddat.dto.XmlFileEntityDto;
import com.raccoon.ddat.mapper.XmlFileMapper;
import com.raccoon.ddat.services.XmlFileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/xml_file")
public class XmlFileController {

    final XmlFileService service;
    final XmlFileMapper mapper;

    @GetMapping("/hi")
    public String sayHi() {
        System.out.println("hi!!!!");
        return "hi";
    }

    @GetMapping("context/")
    public Page<XmlFileEntityDto> getXmlFiles(
            @RequestParam List<String> subtags,
            @RequestParam String search,
            @PageableDefault Pageable pageable
    ) {
        return service.getXmlFiles(search, subtags, pageable);
    }

    @PostMapping("/contexts/")
    public XmlFileEntityDto postXmlFile(@RequestBody XmlFileEntityDto dto) {
        return service.saveXmlFile(mapper.toEntity(dto));
    }
}
