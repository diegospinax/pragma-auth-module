package co.pragma.webflux_auth.domain.role.valueObjects;

abstract class RoleField<T> {
    public T value;

    public RoleField(T value) {
        this.value = value;
        this.validate();
    }

    public void validate() {}
}
