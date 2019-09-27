package Lock;

import redis.clients.jedis.HostAndPort;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JedisClusterConfig implements Serializable {
    private Set<InetSocketAddress> nodes;
    private int timeout;
    private int maxRedirections;
    private String password;

    public JedisClusterConfig() {
    }

    public JedisClusterConfig(Set<InetSocketAddress> nodes, int timeout, int maxRedirections) {
        this(nodes, timeout, maxRedirections, (String)null);
    }

    public JedisClusterConfig(Set<InetSocketAddress> nodes, int timeout, int maxRedirections, String password) {
        this.nodes = nodes;
        this.timeout = timeout;
        this.maxRedirections = maxRedirections;
        this.password = password;
    }

    public Set<HostAndPort> getNodes() {
        Set<HostAndPort> ret = new HashSet();
        Iterator var2 = this.nodes.iterator();

        while(var2.hasNext()) {
            InetSocketAddress node = (InetSocketAddress)var2.next();
            ret.add(new HostAndPort(node.getHostName(), node.getPort()));
        }

        return ret;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getMaxRedirections() {
        return this.maxRedirections;
    }

    public String getPassword() {
        return this.password;
    }

    public static class Builder {
        private Set<InetSocketAddress> nodes;
        private int timeout = 2000;
        private int maxRedirections = 5;
        private String password;

        public Builder() {
        }

        public JedisClusterConfig.Builder setNodes(Set<InetSocketAddress> nodes) {
            this.nodes = nodes;
            return this;
        }

        public JedisClusterConfig.Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public JedisClusterConfig.Builder setMaxRedirections(int maxRedirections) {
            this.maxRedirections = maxRedirections;
            return this;
        }

        public JedisClusterConfig.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public JedisClusterConfig build() {
            return new JedisClusterConfig(this.nodes, this.timeout, this.maxRedirections, this.password);
        }
    }
}
