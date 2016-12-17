package pl.edu.amu.bawsj.jpaint;

/**
 * Created by JanJa on 16.12.2016.
 */
public enum Colors {

    RED {
        @Override
        public String toString() {
            return "#d10606";
        }
    },
    GREEN {
        @Override
        public String toString() {
            return "#349927";
        }
    },
    BLUE {
        @Override
        public String toString() {
            return "#273899";
        }
    },
    GREY_LIGHT {
        @Override
        public String toString() {
            return "#d1d1d1";
        }
    },
    GREY_DARK {
        @Override
        public String toString() {
            return "#7a7a7a";
        }
    }
}
