package EvgeniFomin.sCore.enums;

@SuppressWarnings("ALL")
public enum ServerType {
    АВТОРИЗАЦИЯ(1, "АВТОРИЗАЦИЯ"),
    ХАБ(2, "ХАБ"),
    НЕОПРЕДЕЛЕННЫЙ(3, "НЕОПРЕДЕЛЕННЫЙ"),;

    Integer id;
    String type;

    ServerType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public ServerType getTypeToID(Integer id) {
        switch (id) {
            case 1:
                return АВТОРИЗАЦИЯ;
            case 2:
                return ХАБ;
            case 3:
                return НЕОПРЕДЕЛЕННЫЙ;
            default:
                return null;
        }
    }
}
