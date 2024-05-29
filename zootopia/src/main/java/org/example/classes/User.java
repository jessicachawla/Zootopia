package org.example.classes;

public abstract class User {

    protected String _name;

    protected String _password;

    public String getName() {
        return _name;
    }

    public User(String _name, String _password) {
        this._name = _name;
        this._password = _password;
    }

    protected abstract boolean login(String username, String password);

}
