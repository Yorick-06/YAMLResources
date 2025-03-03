package cz.yorick;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import cz.yorick.api.resources.SimpleResources;
import cz.yorick.ops.JacksonOps;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;

public class YAMLResources implements ModInitializer {
	public static final String MOD_ID = "yaml-resources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final YAMLFactory FACTORY = new YAMLFactory();
	public static final YAMLMapper MAPPER = new YAMLMapper();

	static {
		//support both formats
		SimpleResources.registerOps("yml", JacksonOps.INSTANCE, YAMLResources::readYAML, YAMLResources::writeYAML);
		SimpleResources.registerOps("yaml", JacksonOps.INSTANCE, YAMLResources::readYAML, YAMLResources::writeYAML);
		LOGGER.info("YAML resources are now available.");
	}

	@Override
	public void onInitialize() {
	}

	private static JsonNode readYAML(Reader reader) throws Exception {
		return MAPPER.readTree(reader);
	}

	private static void writeYAML(Writer writer, JsonNode node) throws Exception {
		MAPPER.writeTree(FACTORY.createGenerator(writer), node);
	}

	public static void ensureRegistered() {
	}
}