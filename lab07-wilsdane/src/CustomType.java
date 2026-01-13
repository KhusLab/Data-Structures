public class CustomType implements Comparable<CustomType> {
    private String value;
    public CustomType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public int compareTo(CustomType o) {
        return value.length() - o.getValue().length();
    }
}
