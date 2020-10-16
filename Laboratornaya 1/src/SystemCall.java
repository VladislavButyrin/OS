public class SystemCall {

    private String[] parameters;

    public SystemCall(String... parameters) {
        this.parameters = parameters;

    }
    public String[] getParameters() {
        return parameters;
    }


    public int getParametersCount() {
        return parameters.length;
    }
}
