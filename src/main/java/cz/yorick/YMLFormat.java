package cz.yorick;

public class YMLFormat implements YAMLResources {
    static {
        LOGGER.info("YML resources are now available.");
    }

    @Override
    public String getExtension() {
        return "yml";
    }
}
