package com.androar.kutnow;

import java.io.Serializable;

public class Shops implements Serializable {

        private String shopName;
        private String shopDesc;
        private String price;

        public Shops() {

        }

        public Shops(String shopName, String shopDesc, String price) {
            this.shopName = shopName;
            this.shopDesc = shopDesc;
            this.price = price;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopDesc() {
        return shopDesc;
        }

        public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
        }

        public String getPrice() {
        return price;
        }

        public void setPrice(String price) {
        this.price = price;
        }
}
