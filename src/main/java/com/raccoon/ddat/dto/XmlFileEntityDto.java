package com.raccoon.ddat.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.raccoon.ddat.entity.XmlFileEntity}
 */
@Builder
public record XmlFileEntityDto(
        Long id,
        String subtag,
        String moduleName,
        String namespace,
        String fileName,
        String xmlid,
        String methodModels,
        String context
) implements Serializable {
}
