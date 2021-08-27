package com.mysoft.weather.util;

import org.apache.commons.lang3.StringUtils;

public class ParamUtil {

    public static String completeUrl(String urlTemplate, Object... params) {
        assert StringUtils.isNotBlank(urlTemplate);

        urlTemplate = urlTemplate.replaceAll("\\{\\d+\\}", "%s");
        return String.format(urlTemplate, params);
    }

}
