package github.sagubr.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.convert.ConversionContext;
import io.micronaut.core.convert.TypeConverter;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.Optional;

@Singleton
public class JsonbConverter implements TypeConverter<String, Map<String, Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Optional<Map<String, Object>> convert(String object, Class<Map<String, Object>> targetType) {
        return TypeConverter.super.convert(object, targetType);
    }

    @Override
    public Optional<Map<String, Object>> convert(String object, Class<Map<String, Object>> targetType, ConversionContext context) {
        try {
            return Optional.of(objectMapper.readValue(object, Map.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
