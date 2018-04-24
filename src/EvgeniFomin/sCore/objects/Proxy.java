package EvgeniFomin.sCore.objects;

public class Proxy {
    private String name;
    private String host;
    private Integer port;

    public Proxy() {}

    public static Proxy.Builder newBuilder() {
        return new Proxy().new Builder();
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public class Builder {

        private Builder() {}

        public Builder setName(String name) {
            Proxy.this.name = name;
            return this;
        }

        public Builder setHost(String host) {
            Proxy.this.host = host;
            return this;
        }

        public Builder setPort(Integer port) {
            Proxy.this.port = port;
            return this;
        }

        public Proxy build() {
            return Proxy.this;
        }
    }
}
