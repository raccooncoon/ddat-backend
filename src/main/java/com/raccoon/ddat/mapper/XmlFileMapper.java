package com.raccoon.ddat.mapper;
import com.raccoon.ddat.dto.XmlFileEntityDto;
import com.raccoon.ddat.entity.XmlFileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XmlFileMapper {
    XmlFileEntityDto toDto(XmlFileEntity entity);

    XmlFileEntity toEntity(XmlFileEntityDto dto);

}
