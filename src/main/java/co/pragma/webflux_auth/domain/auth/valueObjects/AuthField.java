package co.pragma.webflux_auth.domain.auth.valueObjects;

abstract class AuthField {
    public String value;

    public AuthField(String value) {
        this.value = value;
        this.validate();
    }

    public void validate () {}
}
