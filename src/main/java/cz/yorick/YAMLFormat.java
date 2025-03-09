package cz.yorick;

public class YAMLFormat implements YAMLResources {
	static {
		LOGGER.info("YAML resources are now available.");
	}

	@Override
	public String getExtension() {
		return "yaml";
	}
}