import java.io.Serializable;

/**
 * Created by denis.selutin on 16.12.2016.
 */
public class Staff implements Serializable {
    private String firsstName;
    private String lastName;
    private String nickName;
    private double sallaryValue;
    private boolean isRegular;

    public String getFirsstName() {
        return firsstName;
    }

    public void setFirsstName(String firsstName) {
        this.firsstName = firsstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getSallaryValue() {
        return sallaryValue;
    }

    public void setSallaryValue(double sallaryValue) {
        this.sallaryValue = sallaryValue;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setIsRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }
}
