public enum Type {

    GMBH("gmbh"),

    SSC("ssc");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
