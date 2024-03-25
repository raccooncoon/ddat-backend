package com.raccoon.ddat.controller;

import com.raccoon.ddat.dto.XmlFileEntityDto;
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

    @GetMapping("/hi")
    public String sayHi() {
        System.out.println("hi!!!!");
        return "hi";
    }

    @GetMapping("context/{context}")
    public Page<XmlFileEntityDto> getXmlFiles(
            @PathVariable String context,
            @RequestParam List<String> subtags,
            @PageableDefault Pageable pageable
    ) {
        return service.getXmlFiles(context, subtags, pageable);
    }

    @PostMapping("/context/")
    public Page<XmlFileEntityDto> postXmlFile(
            @RequestBody XmlFileEntityDto dto
    ) {
        return service.saveXmlFile(dto);
    }
}
