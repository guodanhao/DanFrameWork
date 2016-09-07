package com.halo.framework.vo;

/**
 * Created by muxi on 2016/9/7.
 */
public class Rocket {

    private String pointGuard;

    private String shootingGuard;

    private String smallForward;

    private String powerForward;

    private String center;

    /**
     * 构造器模式
     */
    public static class Builder {

        private String pointGuard;

        private String shootingGuard;

        private String smallForward;

        private String powerForward;

        private String center;

        public Builder pointGuard(String val) {
            pointGuard = val;
            return this;
        }

        public Builder shootingGuard(String val) {
            shootingGuard = val;
            return this;
        }

        public Builder powerForward(String val) {
            powerForward = val;
            return this;
        }

        public Builder smallForward(String val) {
            smallForward = val;
            return this;
        }

        public Builder center(String val) {
            center = val;
            return this;
        }

        public Rocket build(){
            return new Rocket(this);
        }
    }

    public Rocket (Builder builder) {

        pointGuard = builder.pointGuard;
        shootingGuard = builder.shootingGuard;
        smallForward = builder.smallForward;
        powerForward = builder.powerForward;
        center = builder.center;
    }

    public static void main(String[] arg) {
        Rocket rocket = new Builder().center("yaoMing").shootingGuard("guodanhao").build();
    }
}
