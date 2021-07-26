package com.liurui.arsenal.base.common.check;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @ClassName CheckChain
 * @Description 数据校验，链式，遇错中断
 * @Author liurui
 * @Date 2021/7/26 9:46 上午
 * @Version 1.0
 **/
public abstract class CheckChain {


    private CheckChain() {
    }

    public static CheckChain start() {
        return ACTIVE;
    }

    private static final CheckChain ACTIVE = new CheckChain() {
        @Override
        public <T> CheckChain check(T val, Predicate<T> predicate) {
            return classify(predicate.test(val));
        }

        @Override
        public CheckChain check(String val) {
            return classify(StringUtils.isNotBlank(val));
        }

        @Override
        public CheckChain check(Collection vals) {
            return classify(vals != null && !vals.isEmpty());
        }

        @Override
        public CheckChain check(Map map) {
            return classify(map != null && !map.isEmpty());
        }

        @Override
        public <T> CheckChain checkNotNull(T val) {
            return classify(val != null);
        }

        @Override
        public CheckChain checkEquals(Comparable v1, Comparable v2) {
            return classify(v1.compareTo(v2) == 0);
        }

        @Override
        public CheckChain checkEquals(int v1, int v2) {
            return classify(v1 == v2);
        }

        @Override
        public CheckChain checkEquals(double v1, double v2) {
            return classify(Double.compare(v1, v2) == 0);
        }

        @Override
        public CheckChain checkEquals(float v1, float v2) {
            return classify(Float.compare(v1, v2) == 0);
        }

        @Override
        public CheckChain checkEquals(long v1, long v2) {
            return classify(v1 == v2);
        }

        @Override
        public boolean result() {
            return true;
        }

        public CheckChain classify(boolean result) {
            return result ? ACTIVE : FALSE;
        }

    };

    private static final CheckChain FALSE = new InactiveCheckChain();

    private static final class InactiveCheckChain extends CheckChain {
        @Override
        public <T> CheckChain check(T val, Predicate<T> predicate) {
            return this;
        }

        @Override
        public CheckChain check(String val) {
            return this;
        }

        @Override
        public CheckChain check(Collection vals) {
            return this;
        }

        @Override
        public CheckChain check(Map map) {
            return this;
        }

        @Override
        public <T> CheckChain checkNotNull(T val) {
            return this;
        }

        @Override
        public CheckChain checkEquals(Comparable<?> v1, Comparable<?> v2) {
            return this;
        }

        @Override
        public CheckChain checkEquals(int v1, int v2) {
            return this;
        }

        @Override
        public CheckChain checkEquals(double v1, double v2) {
            return this;
        }

        @Override
        public CheckChain checkEquals(float v1, float v2) {
            return this;
        }

        @Override
        public CheckChain checkEquals(long v1, long v2) {
            return this;
        }

        @Override
        public boolean result() {
            return false;
        }
    }


    /**
     * 检查
     * @param val
     * @param predicate
     * @param <T>
     * @return
     */
    public abstract <T> CheckChain check(T val, Predicate<T> predicate);

    /**
     * 检查不为blank
     * true不是blank，false是blank
     * @param val
     * @return
     */
    public abstract CheckChain check(String val);

    /**
     * 检查集合
     * 不为null，且不为空
     * @param vals
     * @return
     */
    public abstract CheckChain check(Collection vals);

    /**
     * 检查map
     * 不为null，且不为空
     * @param map
     * @return
     */
    public abstract CheckChain check(Map map);

    /**
     * 检查不为null
     * true不为null，false为null
     * @param val
     * @param <T>
     * @return
     */
    public abstract <T> CheckChain checkNotNull(T val);

    /**
     * 以下checkEquals方法都为检查值是否相等
     * @param v1
     * @param v2
     * @return
     */
    public abstract CheckChain checkEquals(Comparable<?> v1, Comparable<?> v2);
    public abstract CheckChain checkEquals(int v1, int v2);
    public abstract CheckChain checkEquals(double v1, double v2);
    public abstract CheckChain checkEquals(float v1, float v2);
    public abstract CheckChain checkEquals(long v1, long v2);

    /**
     * 获取结果
     * @return
     */
    public abstract boolean result();

}
