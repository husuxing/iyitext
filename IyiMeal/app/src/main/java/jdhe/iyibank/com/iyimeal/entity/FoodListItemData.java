package jdhe.iyibank.com.iyimeal.entity;

/**
 * Created by Administrator on 2017/8/5.
 */

public class FoodListItemData {
    String name;

    public FoodListItemData(String name, String isHneg) {
        this.name = name;
        this.isHneg = isHneg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsHneg() {
        return isHneg;
    }

    public void setIsHneg(String isHneg) {
        this.isHneg = isHneg;
    }

    String isHneg;
}
