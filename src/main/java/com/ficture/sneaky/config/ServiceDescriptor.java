package com.ficture.sneaky.config;

import me.prettyprint.cassandra.service.CassandraHostConfigurator;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Loader;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 1/4/12
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceDescriptor {

    public static Config config = null;
    private static final String DEFAULT_CONFIG = "file:sneaky.yaml";
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static CassandraHostConfigurator cassConfigurator = null;
    private static Cluster cassCluster = null;

    static {
        try {
            if (config == null) {
                String configUrl = System.getProperty("STUMPY_CONFIG_FILE");
                if (configUrl == null) {
                    configUrl = DEFAULT_CONFIG;
                }
                URL url = getConfigUrl(configUrl);
                InputStream stream = getInputStream(url);
                Constructor constructor = new Constructor(Config.class);
                Yaml yaml = new Yaml(new Loader(constructor));
                config = (Config)yaml.load(stream);

                if (config.cassandra_cluster.size() < 1)
                    throw new ConfigurationException("No cassandra instances configured");

                if (config.keyspace == null)
                    throw new ConfigurationException("Keyspace must be configured");

                cassConfigurator = new CassandraHostConfigurator(StringUtils.join(config.cassandra_cluster, ","));
                cassCluster = HFactory.getOrCreateCluster("sneaky-cluster", cassConfigurator);
            }
        } catch (YAMLException e) {
            logger.error("Fatal configuration exception", e);
            System.out.println("Shit, failed to load the YAML configuration file (invalid YAML). See log for stacktrace.");
            System.exit(1);
        } catch (ConfigurationException e) {
            logger.error("Fatal configuration exception", e);
            System.out.println("Shit, failed to load the YAML configuration file. See log for stacktrace.");
            System.exit(1);
        }
    }

    private static URL getConfigUrl(String configUrl) throws ConfigurationException
    {
        URL url;
        try {
            url = new URL(configUrl);
            url.openStream().close();
        } catch (Exception e) {
            throw new ConfigurationException("Cannot locate " + configUrl + " " + e.toString());
        }
        return url;
    }

    private static InputStream getInputStream(URL url)
    {
        InputStream input = null;
        try {
            input = url.openStream();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return input;
    }

    public static Keyspace keyspace()
    {
        return HFactory.createKeyspace(config.keyspace, cassCluster);
    }
}
