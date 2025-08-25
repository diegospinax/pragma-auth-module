package co.pragma.webflux_auth.domain.user.valueObjects;

public abstract class UserField<T> {
    public T value;

    public UserField(T value) {
        this.value = value;
        this.validate();
    }

    public void validate() {}
}
