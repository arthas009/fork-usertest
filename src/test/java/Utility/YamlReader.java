package Utility;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class YamlReader {
    static Map<String, Object> yamlMaps;

    public YamlReader(String path) {
        Yaml yaml = new Yaml();
        Reader yamlFile = null;
        try {
            yamlFile = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        yamlMaps = (Map<String, Object>) yaml.load(yamlFile);
    }

    public static String getVariable(String varName) {
        return yamlMaps.get(varName).toString();
    }

}
