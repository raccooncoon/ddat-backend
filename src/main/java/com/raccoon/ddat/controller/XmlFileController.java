package com.raccoon.ddat.controller;

import com.raccoon.ddat.dto.XmlFileEntityDto;
import com.raccoon.ddat.mapper.XmlFileMapper;
import com.raccoon.ddat.services.LambdaService;
import com.raccoon.ddat.services.XmlFileService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/xml_file")
public class XmlFileController {

    final XmlFileService service;
    final XmlFileMapper mapper;
    final LambdaService lambdaService;

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

    @GetMapping("total_context/")
    public Map<String, Long> getTotalXmlFiles(
    ) {
        return service.getAllXmlFiles();
    }

    @PostMapping("/contexts/")
    public XmlFileEntityDto postXmlFile(@RequestBody XmlFileEntityDto dto) {
        return service.saveXmlFile(mapper.toEntity(dto));
    }

    @DeleteMapping("/contexts/{moduleName}")
    public void deleteXmlFile(@PathVariable String moduleName) {
        service.deleteByModuleName(moduleName);
    }

    @GetMapping("/aws/lambdas/status")
    public String getAwsLambdaStatus() {
        return lambdaService.getLambdaStatus();
    }
}
