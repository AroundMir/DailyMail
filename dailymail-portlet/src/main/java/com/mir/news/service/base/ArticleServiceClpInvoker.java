package com.mir.news.service.base;

import com.mir.news.service.ArticleServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ArticleServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;

    public ArticleServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return ArticleServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            ArticleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
