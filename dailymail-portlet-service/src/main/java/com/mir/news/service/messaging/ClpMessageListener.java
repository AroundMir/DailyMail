package com.mir.news.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.mir.news.service.ArticleLocalServiceUtil;
import com.mir.news.service.ArticleServiceUtil;
import com.mir.news.service.ClpSerializer;
import com.mir.news.service.ReviewLocalServiceUtil;
import com.mir.news.service.ReviewServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ArticleLocalServiceUtil.clearService();

            ArticleServiceUtil.clearService();
            ReviewLocalServiceUtil.clearService();

            ReviewServiceUtil.clearService();
        }
    }
}
