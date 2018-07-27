package com.mir.news.service.base;

import com.mir.news.service.ArticleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ArticleLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
<<<<<<< HEAD
    private String _methodName62;
    private String[] _methodParameterTypes62;
=======
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4

    public ArticleLocalServiceClpInvoker() {
        _methodName0 = "addArticle";

        _methodParameterTypes0 = new String[] { "com.mir.news.model.Article" };

        _methodName1 = "createArticle";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteArticle";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteArticle";

        _methodParameterTypes3 = new String[] { "com.mir.news.model.Article" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchArticle";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getArticle";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getArticles";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getArticlesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateArticle";

        _methodParameterTypes15 = new String[] { "com.mir.news.model.Article" };

        _methodName16 = "addReviewArticle";

        _methodParameterTypes16 = new String[] { "long", "long" };

        _methodName17 = "addReviewArticle";

        _methodParameterTypes17 = new String[] {
                "long", "com.mir.news.model.Article"
            };

        _methodName18 = "addReviewArticles";

        _methodParameterTypes18 = new String[] { "long", "long[][]" };

        _methodName19 = "addReviewArticles";

        _methodParameterTypes19 = new String[] { "long", "java.util.List" };

        _methodName20 = "clearReviewArticles";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "deleteReviewArticle";

        _methodParameterTypes21 = new String[] { "long", "long" };

        _methodName22 = "deleteReviewArticle";

        _methodParameterTypes22 = new String[] {
                "long", "com.mir.news.model.Article"
            };

        _methodName23 = "deleteReviewArticles";

        _methodParameterTypes23 = new String[] { "long", "long[][]" };

        _methodName24 = "deleteReviewArticles";

        _methodParameterTypes24 = new String[] { "long", "java.util.List" };

        _methodName25 = "getReviewArticles";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "getReviewArticles";

        _methodParameterTypes26 = new String[] { "long", "int", "int" };

        _methodName27 = "getReviewArticles";

        _methodParameterTypes27 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName28 = "getReviewArticlesCount";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "hasReviewArticle";

        _methodParameterTypes29 = new String[] { "long", "long" };

        _methodName30 = "hasReviewArticles";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "setReviewArticles";

        _methodParameterTypes31 = new String[] { "long", "long[][]" };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };
<<<<<<< HEAD

        _methodName62 = "getArticleReviews";

        _methodParameterTypes62 = new String[] { "long" };
=======
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ArticleLocalServiceUtil.addArticle((com.mir.news.model.Article) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ArticleLocalServiceUtil.createArticle(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ArticleLocalServiceUtil.deleteArticle(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ArticleLocalServiceUtil.deleteArticle((com.mir.news.model.Article) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ArticleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ArticleLocalServiceUtil.fetchArticle(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ArticleLocalServiceUtil.getArticle(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ArticleLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ArticleLocalServiceUtil.getArticles(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ArticleLocalServiceUtil.getArticlesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ArticleLocalServiceUtil.updateArticle((com.mir.news.model.Article) arguments[0]);
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            ArticleLocalServiceUtil.addReviewArticle(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            ArticleLocalServiceUtil.addReviewArticle(((Long) arguments[0]).longValue(),
                (com.mir.news.model.Article) arguments[1]);

            return null;
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            ArticleLocalServiceUtil.addReviewArticles(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            ArticleLocalServiceUtil.addReviewArticles(((Long) arguments[0]).longValue(),
                (java.util.List<com.mir.news.model.Article>) arguments[1]);

            return null;
        }

        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            ArticleLocalServiceUtil.clearReviewArticles(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            ArticleLocalServiceUtil.deleteReviewArticle(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            ArticleLocalServiceUtil.deleteReviewArticle(((Long) arguments[0]).longValue(),
                (com.mir.news.model.Article) arguments[1]);

            return null;
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            ArticleLocalServiceUtil.deleteReviewArticles(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            ArticleLocalServiceUtil.deleteReviewArticles(((Long) arguments[0]).longValue(),
                (java.util.List<com.mir.news.model.Article>) arguments[1]);

            return null;
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return ArticleLocalServiceUtil.getReviewArticles(((Long) arguments[0]).longValue());
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return ArticleLocalServiceUtil.getReviewArticles(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return ArticleLocalServiceUtil.getReviewArticles(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return ArticleLocalServiceUtil.getReviewArticlesCount(((Long) arguments[0]).longValue());
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return ArticleLocalServiceUtil.hasReviewArticle(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return ArticleLocalServiceUtil.hasReviewArticles(((Long) arguments[0]).longValue());
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            ArticleLocalServiceUtil.setReviewArticles(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ArticleLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ArticleLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

<<<<<<< HEAD
        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ArticleLocalServiceUtil.getArticleReviews(((Long) arguments[0]).longValue());
        }

=======
>>>>>>> 816e3130999f956bdec64fcf78b511dbf024c3e4
        throw new UnsupportedOperationException();
    }
}
