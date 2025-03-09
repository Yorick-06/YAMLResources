package cz.yorick;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.mojang.serialization.DynamicOps;
import cz.yorick.api.FileTypeInitializer;
import cz.yorick.ops.JacksonOps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;

public interface YAMLResources extends FileTypeInitializer<JsonNode> {
    String MOD_ID = "yaml-resources";
    Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    YAMLFactory FACTORY = new YAMLFactory();
    YAMLMapper MAPPER = new YAMLMapper();

    @Override
    default JsonNode read(Reader reader) throws Exception {
        return MAPPER.readTree(reader);
    }

    @Override
    default void write(Writer writer, JsonNode node) throws Exception {
        MAPPER.writeTree(FACTORY.createGenerator(writer), node);
    }

    @Override
    default DynamicOps<JsonNode> getOps() {
        return JacksonOps.INSTANCE;
    }
}
