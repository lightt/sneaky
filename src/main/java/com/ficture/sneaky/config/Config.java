package com.ficture.sneaky.config;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 1/3/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    public Integer rpc_port = 9009;
    public String rpc_address; // not yet used...
    public List<String> cassandra_cluster;
    public String keyspace = null;
}
