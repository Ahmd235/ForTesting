package amir.simo.myapplication3;

public class Nom {
    private String string;
    private boolean isChecked;

    public Nom(String string) {

        this.string = string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
