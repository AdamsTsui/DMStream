package com.team.finn.model;

import com.team.finn.utils.BaseParamsMapUtil;

import java.util.Map;

/**
 * <p>
 * <p>
 * 日期：2016/2/25
 * <p>
 * 描述信息： 参数封装类
 * <p>
 * 备注信息:
 */
public class ParamsMapUtils extends BaseParamsMapUtil {

    private static Map<String, String> mapparam;

    /**
     * 默认参数
     *
     * @return
     */
    public static Map<String, String> getDefaultParams() {
        return getParamsMap();
    }

    /**
     *   首页 列表详情
     * @param identification
     * @return
     */
    public static Map<String, String> getHomeCate(String identification) {
        mapparam = getDefaultParams();
        mapparam.put("identification", identification);
        return mapparam;
    }

    public static Map<String, String> getHomeCarousel() {
        mapparam = getDefaultParams();
        mapparam.put("version", "2.421");
        return mapparam;
    }
    /**
     *    首页--推荐--颜值
     *      默认  :4条数据
     * @return
     */
    public static Map<String, String> getHomeFaceScoreColumn(int offset,int limit) {
        mapparam = getDefaultParams();
        mapparam.put("offset",offset+"");
        mapparam.put("limit", limit+"");
        return mapparam;
    }

    /**
     *    其他栏目二级分类
     * @param ColumnName
     * @return
     */
    public static Map<String, String> getLiveOtherTwoColumn(String ColumnName) {
        mapparam = getDefaultParams();
        mapparam.put("shortName",ColumnName);
        return mapparam;
    }


}
